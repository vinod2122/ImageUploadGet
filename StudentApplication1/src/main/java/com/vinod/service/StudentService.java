package com.vinod.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vinod.model.Student;

public interface StudentService {
	
	public Student saveStudent(MultipartFile file,Integer stdId, String stdName, String course, double fees);
	
	public List<Student> getAllStudent();
	
	public void updateStudent(Integer stdId, MultipartFile file, String stdName, String course, double fees);
	

}
