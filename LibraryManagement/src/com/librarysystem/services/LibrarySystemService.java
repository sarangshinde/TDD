package com.librarysystem.services;

import java.util.Date;
import java.util.List;

import com.book.model.Book;
import com.librarysystem.model.StudentTranscation;
import com.student.model.Student;
import com.student.services.StudentServicesImpl;

public interface LibrarySystemService {
	
	
	
	public boolean issuedBookRequestBy(StudentTranscation studentTranscationObj,List<Book> requestedBookList,StudentTranscationService studentTranscationServiceObj);
	public void addBookToBookRepoList(Book bookObj);
/*	public void addNonTechnicalBookToList(Book bookObj);*/
	public void addBookIntoBookCountRepoMapping(Book bookObj);
	public List<Book> getListOfSingleCopyBooks();
	public boolean removeBookFromBookCountRepoMapping(Book bookObj);
	public boolean submitBookIssuedBy(StudentTranscation studentTranscationObj,StudentTranscationService studentTranscationServiceObj,Date booksReturedDate);
	public float getFineAmountFor(StudentTranscation studentTranscationObj,Date bookR);
	public boolean isAnyLastIssuedBookAndRequestedBookIsSame(
			StudentTranscation studentTranscationObj,
			List<Book> requestedBookListByStudent);
	public boolean isStudentRequestingSameBookForConsicitiveTwoTimes(
			StudentTranscation studentTranscationObj,
			List<Book> requestedBookListByStudent);
	public boolean reserveBookFor(Student studentObj,Book bookObj);
}
