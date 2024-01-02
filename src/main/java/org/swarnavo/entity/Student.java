package org.swarnavo.entity;

import java.sql.Date;

public class Student {

	private int student_id;
	private String course;
	private String branch;
	private int roll_no;
	private String name;
	private Date dob;
	private int password;
	private String email;
	private String father_name;
	private String gender;
	
	
	
	
	
	public Student(String course, String branch, int roll_no, String name, Date dob, String email, String father_name,
			String gender) {
		super();
		this.course = course;
		this.branch = branch;
		this.roll_no = roll_no;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.father_name = father_name;
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Student(String course, String branch, int roll_no, String name, Date dob, int password,String email, String father_name,
			String gender) {
		super();
		this.course = course;
		this.branch = branch;
		this.roll_no = roll_no;
		this.name = name;
		this.dob = dob;
		this.password = password;
		this.email = email;
		this.father_name = father_name;
		this.gender = gender;
	}


	public Student(int student_id, String course, String branch, int roll_no, String name, Date dob, int password, String email,
			String father_name, String gender) {
		super();
		this.student_id = student_id;
		this.course = course;
		this.branch = branch;
		this.roll_no = roll_no;
		this.name = name;
		this.dob = dob;
		this.password = password;
		this.email = email;
		this.father_name = father_name;
		this.gender = gender;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public int getPassword() {
		return password;
	}


	public void setPassword(int password) {
		this.password = password;
	}


	public Student(int student_id, String course, String branch, int roll_no, String name, String father_name,
			String gender) {
		super();
		this.student_id = student_id;
		this.course = course;
		this.branch = branch;
		this.roll_no = roll_no;
		this.name = name;
		this.father_name = father_name;
		this.gender = gender;
	}
	
	
	public Student(String course, String branch, int roll_no, String name, String father_name, String gender) {
		super();
		this.course = course;
		this.branch = branch;
		this.roll_no = roll_no;
		this.name = name;
		this.father_name = father_name;
		this.gender = gender;
	}


	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
