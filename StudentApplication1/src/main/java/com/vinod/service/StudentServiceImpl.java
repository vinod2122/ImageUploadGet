package com.vinod.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.vinod.model.Student;
import com.vinod.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo repo;

	@Override
	public Student saveStudent(MultipartFile file, Integer stdId, String stdName, String course, double fees) {
		Student s = new Student();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			s.setStdImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.setStdId(stdId);
		s.setStdName(stdName);
		s.setCourse(course);  
		s.setFees(fees);
		repo.save(s);
		return s;
		
		
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> s=repo.findAll();
		return s;
	}


	@Override
	public void updateStudent(Integer stdId, MultipartFile file, String stdName, String course, double fees) {
	    Optional<Student> optionalStudent = repo.findById(stdId);
	    if (optionalStudent.isPresent()) {
	        Student student = optionalStudent.get();
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	        if(fileName.contains(".."))
	        {
	            System.out.println("not a valid file");
	        }
	        try {
	            student.setStdImage(Base64.getEncoder().encodeToString(file.getBytes()));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        student.setStdName(stdName);
	        student.setCourse(course);
	        student.setFees(fees);
	        repo.save(student);
	    } else {
	        System.out.println("Student not found");
	    }
	}



}
