package com.student.model;

import java.util.Date;
import java.util.List;

import com.book.model.Book;

public class Student {

	public String getStudentName() {
		return studentName;
	}
	public int getStudentRollnumber() {
		return studentRollnumber;
	}

/*	public float getFineAmount() {
		return fineAmount;
	}*/

	public Student(String studentName, int studentRollnumber) {
		super();
		this.studentName = studentName;
		this.studentRollnumber = studentRollnumber;

	}
	private String studentName;
	private int studentRollnumber;
	//private float fineAmount;Need to discuss

	
}
