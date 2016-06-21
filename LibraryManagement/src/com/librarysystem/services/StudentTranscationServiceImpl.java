package com.librarysystem.services;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.book.model.Book;
import com.book.model.Book.BookType;
import com.librarysystem.model.StudentTranscation;
import com.student.model.Student;

public class StudentTranscationServiceImpl implements StudentTranscationService {

	@Override
	public List<Book> getCurrentIssedBooksBy(StudentTranscation studentTranscationObj) {
		return studentTranscationObj.getIssuedBookListByStudent();
	}



	@Override
	public int getCurrentCountOfNonTechnicalIssedBooksBy(StudentTranscation studentTranscationObj) {
		return getCountOfIssuedBooksByType(BookType.NONTECHNICAL,studentTranscationObj);
	}

	
	public int getCountOfIssuedBooksByType(BookType bookType,StudentTranscation studentTranscationObj)
	{
		Iterator<Book> issuedBookListIterator =studentTranscationObj.getIssuedBookListByStudent().iterator();
		int bookCount=0;
		while(issuedBookListIterator.hasNext())
		{
			if(issuedBookListIterator.next().getBookType()==bookType)
			{
				bookCount+=1;
			}
		}
		return bookCount;
	}
	
	@Override
	public int getCurrentCountOfTechnicalIssedBooksBy(StudentTranscation studentTranscationObj) {

		return getCountOfIssuedBooksByType(BookType.TECHNICAL,studentTranscationObj);
		
	}

	@Override
	public Date getCurrentIssedBooksDate(StudentTranscation studentTranscationObj) {
		// TODO Auto-generated method stub
		return studentTranscationObj.getBookIssuedDate();
	}

	@Override
	public Date getCurrentIssedBookSubmitDate(StudentTranscation studentTranscationObj) {
		// TODO Auto-generated method stub
		return studentTranscationObj.getBookSubmitedDate();
	}


	@Override
	public boolean addBookToIssuedBookListOf(StudentTranscation studentTranscationObj,Book bookObj) {

		if(getCurrentCountOfTechnicalIssedBooksBy(studentTranscationObj)==2 && getCurrentCountOfNonTechnicalIssedBooksBy(studentTranscationObj)==2)
		{
			return true;
		}
		else if(getCurrentCountOfTechnicalIssedBooksBy(studentTranscationObj)>2)
		{
		return false;
		}
		else if(getCurrentCountOfNonTechnicalIssedBooksBy(studentTranscationObj)>2)
		{
		return false;
		}
		else
		{
			studentTranscationObj.getIssuedBookListByStudent().add(bookObj);
			return true;
		}
		
		
		
	}

	@Override
	public void clearPreviousIssuedBookListBy(StudentTranscation studentTranscationObj)
	{
		studentTranscationObj.getPreviousIssuedBookListByStudent().clear();
	}


	@Override
	public void addBookIntoPreviousIssuedBookListBy(
			StudentTranscation studentTranscationObj,Book bookObj) {
		
		studentTranscationObj.getPreviousIssuedBookListByStudent().add(bookObj);
		
	}



	


}
