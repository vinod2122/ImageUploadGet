package com.vinod.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vinod.model.Student;
import com.vinod.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("vk")
public class StudentController {
	
	@Autowired
	private StudentService stdServ;
	@PostMapping("/save")
	public String saveStudent(@RequestParam MultipartFile file,
							  @RequestParam Integer stdId,
							  @RequestParam String stdName,
							  @RequestParam String course,
							  @RequestParam double fees) {
		Student s1=stdServ.saveStudent(file, stdId, stdName, course, fees);
		String message=null;
		if(s1!=null)
		{
		      message = "Students data save successfully";
		    }
		    else
		    {
		      message ="not save data properly";
		   }
		return message;
		
	}
	
	
	@GetMapping("/getAll")
	public List<Student> getAll() {
		List<Student> std=stdServ.getAllStudent();
		return std;
	}
	
	@PutMapping("/update/{stdId}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer stdId,
                                                 @RequestParam(value = "file", required = false) MultipartFile file,
                                                 @RequestParam(value = "stdName", required = false) String stdName,
                                                 @RequestParam(value = "course", required = false) String course,
                                                 @RequestParam(value = "fees", required = false) Double fees) {
        stdServ.updateStudent(stdId, file, stdName, course, fees);
        return ResponseEntity.ok("Student updated successfully");
    }
	



}

