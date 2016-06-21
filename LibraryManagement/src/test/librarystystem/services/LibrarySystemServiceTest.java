package test.librarystystem.services;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import test.librarystystem.exceptions.NoSuchBookException;

import com.book.model.Book;
import com.book.model.Book.BookType;
import com.librarysystem.model.StudentTranscation;
import com.librarysystem.services.LibrarySystemService;
import com.librarysystem.services.LibrarySystemServiceImpl;
import com.librarysystem.services.StudentTranscationService;
import com.librarysystem.services.StudentTranscationServiceImpl;
import com.student.model.Student;
import com.student.services.StudentServicesImpl;

public class LibrarySystemServiceTest {

	Student studentObj,studentObjzero;
	String issueDateStr = "11-11-2012";
	String submitDateStr = "22-11-2012";
	String returnedDateStr = "30-11-2012";
	String returnedDateStrn="11-12-2012";
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Date issueDate,submitDate,returnedDate,returnedDateN;
	StudentServicesImpl studentServiceImpl ;
	
	StudentTranscationService studentTranscationServiceObj;
	StudentTranscation studentTranscationObj,studentWithUniqueBookTranscationObj,studentWithUniqueBookTranscationObjd;
	
	Book nonTechnicalbook,technicalBook,uniqueTechnicalBook,uniqueNonTechnicalBook;
	List<Book> technicalBookList;
	List<Book> nontechnicalBookList;
	List<Book> requestedBookListByStudent;
	
	
	LibrarySystemService librarySystemServiceObj;
	
	@Before
	public void setUp() throws Exception {
		studentObj = new Student("xyz",123);
		returnedDateN= dateFormat.parse(returnedDateStrn);
		returnedDate= dateFormat.parse(returnedDateStr);
		issueDate= dateFormat.parse(issueDateStr);
		submitDate = dateFormat.parse(submitDateStr);
		studentTranscationObj= new StudentTranscation(studentObj, issueDate, submitDate,0f);
		studentWithUniqueBookTranscationObj= new StudentTranscation(studentObj, issueDate, submitDate,0f);
		studentWithUniqueBookTranscationObjd= new StudentTranscation(studentObj, returnedDateN, returnedDateN, 0f);
		studentTranscationServiceObj = new StudentTranscationServiceImpl();
		
		
		
		librarySystemServiceObj= new LibrarySystemServiceImpl();
		technicalBookList=new ArrayList<Book>();
		nontechnicalBookList= new ArrayList<Book>();
		requestedBookListByStudent= new ArrayList<Book>();
		nonTechnicalbook=new Book("abc","xyz",10.0f,Book.BookType.NONTECHNICAL);
		technicalBook=new Book("pqr","xyz",10.0f,Book.BookType.TECHNICAL);
		
		uniqueTechnicalBook= new Book("mno","mno",20.0f,Book.BookType.TECHNICAL);
		uniqueNonTechnicalBook= new Book("efg","efg",20.0f,Book.BookType.NONTECHNICAL);
	/*	technicalBookList.add(technicalBook);
		technicalBookList.add(technicalBook);
	
		nontechnicalBookList.add(nonTechnicalbook);
		nontechnicalBookList.add(nonTechnicalbook);*/

		requestedBookListByStudent.add(technicalBook);
		requestedBookListByStudent.add(nonTechnicalbook);
		requestedBookListByStudent.add(technicalBook);
		requestedBookListByStudent.add(nonTechnicalbook);
		
		nontechnicalBookList.add(nonTechnicalbook);
		nontechnicalBookList.add(nonTechnicalbook);
		nontechnicalBookList.add(nonTechnicalbook);
		nontechnicalBookList.add(technicalBook);
		
		technicalBookList.add(technicalBook);
		technicalBookList.add(technicalBook);
		technicalBookList.add(technicalBook);
		technicalBookList.add(nonTechnicalbook);
		
		
		
		librarySystemServiceObj.addBookToBookRepoList(nonTechnicalbook);
		librarySystemServiceObj.addBookToBookRepoList(nonTechnicalbook);
		librarySystemServiceObj.addBookToBookRepoList(nonTechnicalbook);
		librarySystemServiceObj.addBookToBookRepoList(nonTechnicalbook);
		
		librarySystemServiceObj.addBookToBookRepoList(technicalBook);
		librarySystemServiceObj.addBookToBookRepoList(technicalBook);
		librarySystemServiceObj.addBookToBookRepoList(technicalBook);
		librarySystemServiceObj.addBookToBookRepoList(technicalBook);

		
		issueDate = dateFormat.parse(issueDateStr);
		submitDate = dateFormat.parse(submitDateStr);
		studentObj=new Student("Sarang",11);
		studentObjzero=new Student("Sarang",11);
		studentServiceImpl= new StudentServicesImpl();
	}
	
	@Test(expected=NoSuchBookException.class)
	public void testremoveBookFromBookCountRepoMappingWithNonExistingBook() {
		
	
		Book nonexsitingbook= new Book("adsf","adsf",200.0f,BookType.TECHNICAL);
		assertEquals(false, librarySystemServiceObj.removeBookFromBookCountRepoMapping(nonexsitingbook));		
	}
	@Test
	public void testremoveBookFromBookCountRepoMappingWithNoCopyForBook() {
		
		 //can be implemented with no enough copies exists for this book
		Book onecopyBook= new Book("adsf","adsf",200.0f,BookType.TECHNICAL);
		librarySystemServiceObj.addBookIntoBookCountRepoMapping(onecopyBook);
		assertEquals(true, librarySystemServiceObj.removeBookFromBookCountRepoMapping(onecopyBook));		
		assertEquals(false, librarySystemServiceObj.removeBookFromBookCountRepoMapping(onecopyBook));
		
	}
	

	
	
	@Test
	public void testStudentBookIssueRequestForMorethantwoTechnicalBooks() {
		
		 //can be implemented with expected more than two technical books not allowed exception
		assertEquals(false, librarySystemServiceObj.issuedBookRequestBy(studentTranscationObj,technicalBookList,studentTranscationServiceObj));		
	}


	@Test
	public void testStudentBookIssueRequestForTwoTechnicalAndTwoNonTechnicalBooks() {
		assertEquals(true, librarySystemServiceObj.issuedBookRequestBy(studentTranscationObj,requestedBookListByStudent,studentTranscationServiceObj));
		
	}



	@Test
	public void testStudentBookIssueRequestForMorethanTwoNonTechnicalBooks() {
		
	 //can be implemented with expected more than two non technical books not allowed exception 
	
		assertEquals(false, librarySystemServiceObj.issuedBookRequestBy(studentTranscationObj,nontechnicalBookList,studentTranscationServiceObj));
		
	}
	
	
	@Test
	public void testStudentIssuedBookSubmitRequestWithTimePeriodOfMoreThanTwoWeeks() {
		
	 //can be implemented with expected more than two non technical books not allowed exception 
		assertEquals(false, librarySystemServiceObj.submitBookIssuedBy(studentTranscationObj,studentTranscationServiceObj,returnedDate));
		
	}
	
	@Test
	public void testStudentIssuedBookSubmitRequestWithTimePeriodOfLessThanEqualToTwoWeeks() {
		
	 //can be implemented with expected more than two non technical books not allowed exception 
		assertEquals(true, librarySystemServiceObj.submitBookIssuedBy(studentTranscationObj,studentTranscationServiceObj,submitDate));
		
	}
	

	@Test
	public void testStudentWithFineAmountGreaterThanZero() {

	assertEquals(50f, librarySystemServiceObj.getFineAmountFor(studentTranscationObj,returnedDate), 0.0002); // true
	}

	@Test
	public void testStudentWithNOFineAmount() {
		System.out.println(librarySystemServiceObj.getFineAmountFor(studentTranscationObj,submitDate));
	assertEquals(0f, librarySystemServiceObj.getFineAmountFor(studentTranscationObj,submitDate), 0.0002); // true
	}
	
	@Test
	//Need to disscuss regarding is it right to call another method of service from testmethod to prepare
	//data for test
	public void testisAnyLastIssuedBookAndRequestedBookIsSameWithFalseCondition()
	{
		studentTranscationServiceObj.addBookIntoPreviousIssuedBookListBy(studentWithUniqueBookTranscationObj, uniqueTechnicalBook);
		assertEquals(false,librarySystemServiceObj.isAnyLastIssuedBookAndRequestedBookIsSame(studentWithUniqueBookTranscationObj,requestedBookListByStudent));
		
	}
	
	@Test
	//Need to disscuss regarding is it right to call another method of service from testmethod to prepare
	//data for test
	public void testisAnyLastIssuedBookAndRequestedBookIsSameWithTrueCondition()
	{
		studentTranscationServiceObj.addBookIntoPreviousIssuedBookListBy(studentWithUniqueBookTranscationObj, technicalBook);
		assertEquals(true,librarySystemServiceObj.isAnyLastIssuedBookAndRequestedBookIsSame(studentWithUniqueBookTranscationObj,requestedBookListByStudent));
		
	}
	
	@Test
	//Need to disscuss regarding is it right to call another method of service from testmethod to prepare
	//data for test
	//Need to Test
	public void testStudentCannotIssueSameBookForConsicitiveTwoTimes()
	{
		studentWithUniqueBookTranscationObj.setLastTranscationBookSubmitDate(returnedDateN);
		studentTranscationServiceObj.addBookIntoPreviousIssuedBookListBy(studentWithUniqueBookTranscationObj, technicalBook);
		assertEquals(true,librarySystemServiceObj.isStudentRequestingSameBookForConsicitiveTwoTimes(studentWithUniqueBookTranscationObj,requestedBookListByStudent));
	}
	
	@Test
	//Need to disscuss regarding is it right to call another method of service from testmethod to prepare
	//data for test
	//Need to Test
	public void testStudentCanIssueDiffentBookForConsicitiveTwoTimes()
	{
		studentWithUniqueBookTranscationObj.setLastTranscationBookSubmitDate(returnedDateN);
		studentTranscationServiceObj.addBookIntoPreviousIssuedBookListBy(studentWithUniqueBookTranscationObj, uniqueTechnicalBook);
		assertEquals(false,librarySystemServiceObj.isStudentRequestingSameBookForConsicitiveTwoTimes(studentWithUniqueBookTranscationObj,requestedBookListByStudent));
	}
	

	@Test
	public void testEmptyListOfBooksWithSingleCopy()
	{
		LibrarySystemService librarySystemServiceObjtemp=new LibrarySystemServiceImpl();  
		assertEquals(0, librarySystemServiceObjtemp.getListOfSingleCopyBooks().size());
	}


	@Test
	public void testReserveBookWhenBookCopiesAreAvailable()
	{
		assertEquals(false,librarySystemServiceObj.reserveBookFor(studentObj, technicalBook));
	}
	
	@Test(expected=NoSuchBookException.class)
	public void testReserveBookWhenBookNotExists()
	{
		assertEquals(true,librarySystemServiceObj.reserveBookFor(studentObj, uniqueTechnicalBook));
	}
	
	
	public void testReserveBookWhenBookCopiesAreNotAvailable()
	{
		assertEquals(true,librarySystemServiceObj.reserveBookFor(studentObj, uniqueNonTechnicalBook));
	}
}
