package com.librarysystem.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import test.librarystystem.exceptions.NoSuchBookException;

import com.book.model.Book;
import com.book.model.Book.BookType;
import com.librarysystem.model.StudentTranscation;
import com.student.model.Student;
import com.student.services.StudentServicesImpl;

public class LibrarySystemServiceImpl implements LibrarySystemService{
	
	/*List<Book> listOfTechnicalBooksAvaliable;
	List<Book> listOfNonTechnicalBooksAvaliable;*/
	List<Book> listOfBooksAvaliable;
	Map<Book,Integer> mappingOfAvailableBooksAndThereNumberOfCopies; 
	Map<Book,List<Student>> listBookReservedByStudents;
	public LibrarySystemServiceImpl()
	{
		mappingOfAvailableBooksAndThereNumberOfCopies= new HashMap<Book,Integer>();
		listBookReservedByStudents =new HashMap<Book,List<Student>>();
	/*	listOfTechnicalBooksAvaliable =new ArrayList<Book>();
		listOfNonTechnicalBooksAvaliable =new ArrayList<Book>();*/
		listOfBooksAvaliable=new ArrayList<Book>();
	}

	@Override
	public boolean issuedBookRequestBy(StudentTranscation studentTranscationObj,List<Book> requestedBookList,StudentTranscationService studentTranscationServiceObj) {
		Iterator<Book> requestedBookListIterator =requestedBookList.iterator();
		Book bookObj;
		boolean issuedRequestSuccessFlag=true;
		if(isStudentRequestingSameBookForConsicitiveTwoTimes(studentTranscationObj, requestedBookList))
		{
			 issuedRequestSuccessFlag=false;
		}
		else
		{
		while(requestedBookListIterator.hasNext())
		{
			bookObj=requestedBookListIterator.next();
		 if(removeBookFromBookCountRepoMapping(bookObj))
		 {
				//Can implement custom excepitons
			 
			 if(!studentTranscationServiceObj.addBookToIssuedBookListOf(studentTranscationObj, bookObj))
			 {
				 issuedRequestSuccessFlag=false;
				 break;
			 }
		 }
		 else
		 {
			//Can implement custom excepitons
			 issuedRequestSuccessFlag=false;
			 break;
			 
		 }
		}
		}
	
		return issuedRequestSuccessFlag;
		
	
	}

/*	@Override
	public void addTechnicalBookToList(Book bookObj) {
		this.listOfTechnicalBooksAvaliable.add(bookObj);
		addBookIntoBookCountRepoMapping(bookObj);
		
	}

	@Override
	public void addNonTechnicalBookToList(Book bookObj) {
		this.listOfNonTechnicalBooksAvaliable.add(bookObj);
		addBookIntoBookCountRepoMapping(bookObj);
		
	}*/

	@Override
	public void addBookIntoBookCountRepoMapping(Book bookObj) {
		if(isBookAvaliableInBookCountRepository(bookObj))
		{
				int existingBookCount=this.mappingOfAvailableBooksAndThereNumberOfCopies.get(bookObj);
				existingBookCount+=1;
				this.mappingOfAvailableBooksAndThereNumberOfCopies.put(bookObj, existingBookCount);
		}
		else
			{
				this.mappingOfAvailableBooksAndThereNumberOfCopies.put(bookObj, 1);
			}
		
	}

	public boolean isBookAvaliableInBookCountRepository(Book bookObj)
	{
		if(mappingOfAvailableBooksAndThereNumberOfCopies.containsKey(bookObj))
			return true;
		else
			return false;
	}
	@Override
	public boolean removeBookFromBookCountRepoMapping(Book bookObj) {
		// TODO Auto-generated method stub
		if(isBookAvaliableInBookCountRepository(bookObj))
		{
				int existingBookCount=this.mappingOfAvailableBooksAndThereNumberOfCopies.get(bookObj);
				if(existingBookCount==0)
				{
				 System.out.println("No enough copies exist for this book");
				 return false;
				}
				else
				{
				existingBookCount-=1;
				this.mappingOfAvailableBooksAndThereNumberOfCopies.put(bookObj, existingBookCount);
				return true;
				}
		}
		else
			{
				throw new NoSuchBookException("This book is not avaliable");
				
			}
	}

	@Override
	public void addBookToBookRepoList(Book bookObj) {
		listOfBooksAvaliable.add(bookObj);
		addBookIntoBookCountRepoMapping(bookObj);
	}

	
	@Override
	public boolean submitBookIssuedBy(StudentTranscation studentTranscationObj,StudentTranscationService studentTranscationServiceObj,Date booksReturedDate) {
		float fineAmount=getFineAmountFor(studentTranscationObj,booksReturedDate);
		if(fineAmount>0)
		{
			studentTranscationObj.setFineAmount(fineAmount)	;
			return false;
		}
		else
		{
			Iterator<Book> requestedBookListIterator =studentTranscationObj.getIssuedBookListByStudent().iterator();
			Book bookObj;
			studentTranscationServiceObj.clearPreviousIssuedBookListBy(studentTranscationObj);
			studentTranscationObj.setLastTranscationBookSubmitDate(studentTranscationObj.getBookSubmitedDate());
			while(requestedBookListIterator.hasNext())
			{
				bookObj=requestedBookListIterator.next();
				addBookIntoBookCountRepoMapping(bookObj);
				studentTranscationServiceObj.addBookIntoPreviousIssuedBookListBy(studentTranscationObj,bookObj);
			}
			
			return true;
		}

	}
	

	@Override
	public float getFineAmountFor(StudentTranscation studentTranscationObj,Date bookReturnedDate) {
		long diff=bookReturnedDate.getTime()-studentTranscationObj.getBookIssuedDate().getTime();
		long days =TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		if(days>14)
		{
			return ((days-14)*10);
		}
		else
		{
			return 0;
		}
		
	}

	@Override
	public boolean isAnyLastIssuedBookAndRequestedBookIsSame(
			StudentTranscation studentTranscationObj,
			List<Book> requestedBookListByStudent) {
		boolean bookExistInPreviousBookListFlag=false;
		Iterator<Book> previousIssuedBookListIterator =studentTranscationObj.getPreviousIssuedBookListByStudent().iterator();
		while(previousIssuedBookListIterator.hasNext())
		{
			if(requestedBookListByStudent.contains(previousIssuedBookListIterator.next()))
			{
				bookExistInPreviousBookListFlag=true;	
			}
		}
		
		return bookExistInPreviousBookListFlag;
	}

	@Override
	public boolean isStudentRequestingSameBookForConsicitiveTwoTimes(
			StudentTranscation studentTranscationObj,
			List<Book> requestedBookListByStudent) {
		boolean consicitiveBookRequestFlag=false;
		Date lastStudentTranscationDate =studentTranscationObj.getLastTranscationBookSubmitDate();
		if(lastStudentTranscationDate!=null)
		{
		long dateTimeDifference=lastStudentTranscationDate.getTime()-studentTranscationObj.getBookIssuedDate().getTime();
		long dateDaysDifference= TimeUnit.DAYS.convert(dateTimeDifference, TimeUnit.MILLISECONDS);
		if(dateDaysDifference>28)
		{
			if(isAnyLastIssuedBookAndRequestedBookIsSame(studentTranscationObj,requestedBookListByStudent))
			{
				consicitiveBookRequestFlag=true;	
			}
		}
		}
		return consicitiveBookRequestFlag;
	}

	@Override
	public List<Book> getListOfSingleCopyBooks() {
		
	 List<Book> returnListOfBooksWithSingleCopy=new ArrayList<Book>();
		for (Map.Entry<Book,Integer>  listOfAvailableBooksWithCopyCount : this.mappingOfAvailableBooksAndThereNumberOfCopies.entrySet()) {
			if(listOfAvailableBooksWithCopyCount.getValue()==1)
			{
				returnListOfBooksWithSingleCopy.add(listOfAvailableBooksWithCopyCount.getKey());
			}
		}
		return returnListOfBooksWithSingleCopy;
	}
	
	@Override
	public boolean reserveBookFor(Student studentObj,Book bookObj)
	{
		
		Integer bookCopiesCount=this.mappingOfAvailableBooksAndThereNumberOfCopies.get(bookObj);
		if(bookCopiesCount==null)
		{
			throw new NoSuchBookException("This book is not available");
		}
		else if(bookCopiesCount!=null && bookCopiesCount>0)
		{
			return false;
		}
		else
		{
		if(this.listBookReservedByStudents.containsKey(bookObj))
		{
			List<Student> listOfStudents= this.listBookReservedByStudents.get(bookObj);
			listOfStudents.add(studentObj);
			this.listBookReservedByStudents.put(bookObj, listOfStudents);
			
		}
		else
		{
			List<Student> listOfStudents = new LinkedList<Student>();
			listOfStudents.add(studentObj);
			this.listBookReservedByStudents.put(bookObj, listOfStudents);
		}
		return true;
		}
		
	}
}
