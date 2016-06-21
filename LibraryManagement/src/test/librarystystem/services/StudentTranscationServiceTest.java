package test.librarystystem.services;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.book.model.Book;
import com.librarysystem.model.StudentTranscation;
import com.librarysystem.services.StudentTranscationService;
import com.librarysystem.services.StudentTranscationServiceImpl;
import com.student.model.Student;

public class StudentTranscationServiceTest {

	StudentTranscation studentTranscationObj;
	StudentTranscationService studentTranscationServiceObj;
	Student studentObj,studentObjZero;
	String issueDateStr = "11-11-2012";
	String issueDateStrz = "19-11-2012";
	String submitDateStr = "29-11-2012";
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Date issueDate,submitDate,issueDatez;
	
	Book nonTechnicalbook,technicalBook;
	
	@Before
	public void setUp() throws Exception {
		studentObj = new Student("xyz",123);
		studentObjZero= new Student("abc",124);
		issueDate= dateFormat.parse(issueDateStr);
		issueDatez= dateFormat.parse(issueDateStrz);
		submitDate = dateFormat.parse(submitDateStr);
		studentTranscationObj= new StudentTranscation(studentObj, issueDate, submitDate,0f);
		
		studentTranscationServiceObj = new StudentTranscationServiceImpl();
		nonTechnicalbook=new Book("abc","xyz",10.0f,Book.BookType.NONTECHNICAL);
		technicalBook=new Book("pqr","xyz",10.0f,Book.BookType.TECHNICAL);
	}



	
	

	


	//please verify multiple asserts are allowed this or not and provide suggestions
	@Test
	public void testAddMoreThanTwoNonTechnicalBookToIssuedBookListOfStudent() {
	//if(studentTranscationServiceObj.getCurrentCountOfNonTechnicalIssedBooksBy(studentTranscationObj)==2)	
		StudentTranscation studentTranscationObj  = new StudentTranscation(studentObj, issueDate, submitDate,0f);
		assertEquals(true,studentTranscationServiceObj.addBookToIssuedBookListOf(studentTranscationObj,nonTechnicalbook));
		assertEquals(true,studentTranscationServiceObj.addBookToIssuedBookListOf(studentTranscationObj,nonTechnicalbook));	
	assertEquals(true,studentTranscationServiceObj.addBookToIssuedBookListOf(studentTranscationObj,nonTechnicalbook));
	assertEquals(false,studentTranscationServiceObj.addBookToIssuedBookListOf(studentTranscationObj,nonTechnicalbook));
	}
	
	@Test
	public void testAddMoreThanTwoTechnicalBookToIssuedBookListOfStudent() {
		StudentTranscation studentTranscationObj  = new StudentTranscation(studentObj, issueDate, submitDate,0f);
		assertEquals(true,studentTranscationServiceObj.addBookToIssuedBookListOf(studentTranscationObj,technicalBook));
		assertEquals(true,studentTranscationServiceObj.addBookToIssuedBookListOf(studentTranscationObj,technicalBook));
		assertEquals(true,studentTranscationServiceObj.addBookToIssuedBookListOf(studentTranscationObj,technicalBook));
		assertEquals(false,studentTranscationServiceObj.addBookToIssuedBookListOf(studentTranscationObj,technicalBook));
	}  
}