package com.student.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.book.model.Book;
import com.student.model.Student;

public class StudentServicesImpl implements StudentServices {
	
	private List<Student> registerdStudentList;
	
	public StudentServicesImpl()
	{
		this.registerdStudentList=new ArrayList<Student>();
	}
	

	@Override
	public boolean register(Student studentObj) {
		// TODO Auto-generated method stub
		if(!this.registerdStudentList.contains(studentObj))
		{
		this.registerdStudentList.add(studentObj);
		return true;
		}
		else
		{
			return false;
		}
		
	}

	
}
