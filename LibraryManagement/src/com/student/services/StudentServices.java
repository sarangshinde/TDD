package com.student.services;

import java.util.Date;
import java.util.List;

import com.book.model.Book;
import com.student.model.Student;

public interface StudentServices {

	public boolean register(Student studentObj);
	/*public List<Book> getCurrentTechnicalIssedBooksBy(Student studentObj);
	public List<Book> getCurrentNonTechnicalIssedBooksBy(Student studentObj);
	public int getCurrentCountOfNonTechnicalIssedBooksBy(Student studentObj);
	public int getCurrentCountOfTechnicalIssedBooksBy(Student studentObj);
	public Date getCurrentIssedBooksDate(Student studentObj);
	public Date getCurrentIssedBookSubmitDate(Student studentObj);
	public float getFineAmountFor(Student studentObj);
	public boolean addTechnicalBookToTechnicalBookListOf(Student studentObj,Book bookObj);
	public boolean addNonTechnicalBookToNonTechnicalBookListOf(Student studentObj,Book bookObj);
	*/
}
