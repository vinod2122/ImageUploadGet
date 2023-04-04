package com.vinod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="Stud")
public class Student {
	@Id
	private Integer stdId;
	private String stdName;
	private String course;
	private double fees;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String stdImage;
	public Student() {
		super();
	}
	public Student(Integer stdId, String stdName, String course, double fees, String stdImage) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.course = course;
		this.fees = fees;
		this.stdImage = stdImage;
	}
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public String getStdImage() {
		return stdImage;
	}
	public void setStdImage(String stdImage) {
		this.stdImage = stdImage;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", course=" + course + ", fees=" + fees
				+ ", stdImage=" + stdImage + "]";
	}
	
	
}
