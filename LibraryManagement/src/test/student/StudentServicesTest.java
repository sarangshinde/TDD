package test.student;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import org.junit.Before;
import org.junit.Test;

import com.book.model.Book;
import com.student.model.Student;
import com.student.services.StudentServices;
import com.student.services.StudentServicesImpl;

public class StudentServicesTest {

	Student studentObj,studentObjzero;
	String issueDateStr = "11-11-2012";
	String submitDateStr = "29-11-2012";
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Date issueDate,submitDate;
	StudentServicesImpl studentServiceImpl ;
	Book nonTechnicalbook,technicalBook;

	@Before
	public void setUp() throws Exception {

		nonTechnicalbook=new Book("abc","xyz",10.0f,Book.BookType.NONTECHNICAL);
		technicalBook=new Book("pqr","xyz",10.0f,Book.BookType.TECHNICAL);

		
		issueDate = dateFormat.parse(issueDateStr);
		submitDate = dateFormat.parse(submitDateStr);
		studentObj=new Student("Sarang",11);
		studentObjzero=new Student("Sarang",11);
		studentServiceImpl= new StudentServicesImpl();
	}

/*	@Test
	public void testStudentRegister() {
		fail("Not yet implemented");
	}*///Assume it is added

	
	
}
