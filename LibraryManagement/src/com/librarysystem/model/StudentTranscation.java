package com.librarysystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.book.model.Book;
import com.student.model.Student;

public class StudentTranscation {
	
	public Student getStudentObj() {
		return studentObj;
	}
	public Date getBookIssuedDate() {
		return bookIssuedDate;
	}
	public Date getBookSubmitedDate() {
		return bookSubmitedDate;
	}
	public StudentTranscation(Student studentObj, Date bookIssuedDate,
			Date bookSubmitedDate,float fineAmount) {
		super();
		this.studentObj = studentObj;
		this.bookIssuedDate = bookIssuedDate;
		this.bookSubmitedDate = bookSubmitedDate;
		this.fineAmount=fineAmount;
		this.issuedBookListByStudent = new ArrayList<Book>();
		this.previousIssuedBookListByStudent= new ArrayList<Book>();
	}
	private Student studentObj;
	private Date bookIssuedDate;
	private Date bookSubmitedDate;
	public float getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(float fineAmount) {
		this.fineAmount = fineAmount;
	}
	private float fineAmount;
	
	//Need to Disccuss
	//Initalizationf of this list is done in constructor is it right?
	//Can we pass an empty list  as argument in constructor while initalizing object
	//plz provide suggestions
	private List<Book> issuedBookListByStudent;
	private List<Book> previousIssuedBookListByStudent;
	
	
	public List<Book> getPreviousIssuedBookListByStudent() {
		return previousIssuedBookListByStudent;
	}
	public List<Book> getIssuedBookListByStudent() {
		return issuedBookListByStudent;
	}

	private Date lastTranscationBookSubmitDate;
	public Date getLastTranscationBookSubmitDate() {
		return lastTranscationBookSubmitDate;
	}
	public void setLastTranscationBookSubmitDate(Date lastTranscationBookSubmitDate) {
		this.lastTranscationBookSubmitDate = lastTranscationBookSubmitDate;
	}
	
	
	

}
