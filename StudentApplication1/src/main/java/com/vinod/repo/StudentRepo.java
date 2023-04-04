package com.vinod.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vinod.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {


}
