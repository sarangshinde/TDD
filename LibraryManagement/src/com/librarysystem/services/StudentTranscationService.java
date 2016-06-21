package com.librarysystem.services;

import java.util.Date;
import java.util.List;

import com.book.model.Book;
import com.librarysystem.model.StudentTranscation;
import com.student.model.Student;

public interface StudentTranscationService {
	
	public List<Book> getCurrentIssedBooksBy(StudentTranscation studentTranscationObj);
	public int getCurrentCountOfNonTechnicalIssedBooksBy(StudentTranscation studentTranscationObj);
	public int getCurrentCountOfTechnicalIssedBooksBy(StudentTranscation studentTranscationObj);
	public Date getCurrentIssedBooksDate(StudentTranscation studentTranscationObj);
	public Date getCurrentIssedBookSubmitDate(StudentTranscation studentTranscationObj);
	public boolean addBookToIssuedBookListOf(StudentTranscation studentTranscationObj,Book bookObj);
	public void addBookIntoPreviousIssuedBookListBy(StudentTranscation studentTranscationObj,Book bookObj);
	public void clearPreviousIssuedBookListBy(StudentTranscation studentTranscationObj);
	

}
