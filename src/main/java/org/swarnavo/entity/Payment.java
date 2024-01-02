package org.swarnavo.entity;

import java.util.Date;

public class Payment {
	private int fee_id;
	private Date date;
	private String institute;
	private String course;
	private int roll_no;
	private int sem;
	private String name;
	private String email;
	private int books;
	private int copies;
	private int sem_fee;
	private int com_fee;
	private int misc;
	private int total;
	private int utr;
	
	
	
	
	public Payment(String institute, String course, int roll_no, int sem, String name, String email, int books,
			int copies, int sem_fee, int com_fee, int misc, int total, int utr) {
		super();
		this.institute = institute;
		this.course = course;
		this.roll_no = roll_no;
		this.sem = sem;
		this.name = name;
		this.email = email;
		this.books = books;
		this.copies = copies;
		this.sem_fee = sem_fee;
		this.com_fee = com_fee;
		this.misc = misc;
		this.total = total;
		this.utr = utr;
	}
	public Payment(Date date, String institute, String course, int roll_no, int sem, String name, String email,
			int books, int copies, int sem_fee, int com_fee, int misc, int total, int utr) {
		super();
		this.date = date;
		this.institute = institute;
		this.course = course;
		this.roll_no = roll_no;
		this.sem = sem;
		this.name = name;
		this.email = email;
		this.books = books;
		this.copies = copies;
		this.sem_fee = sem_fee;
		this.com_fee = com_fee;
		this.misc = misc;
		this.total = total;
		this.utr = utr;
	}
	public Payment(int fee_id, Date date, String institute, String course, int roll_no, int sem, String name,
			String email, int books, int copies, int sem_fee, int com_fee, int misc, int total, int utr) {
		super();
		this.fee_id = fee_id;
		this.date = date;
		this.institute = institute;
		this.course = course;
		this.roll_no = roll_no;
		this.sem = sem;
		this.name = name;
		this.email = email;
		this.books = books;
		this.copies = copies;
		this.sem_fee = sem_fee;
		this.com_fee = com_fee;
		this.misc = misc;
		this.total = total;
		this.utr = utr;
	}
	public int getFee_id() {
		return fee_id;
	}
	public void setFee_id(int fee_id) {
		this.fee_id = fee_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBooks() {
		return books;
	}
	public void setBooks(int books) {
		this.books = books;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public int getSem_fee() {
		return sem_fee;
	}
	public void setSem_fee(int sem_fee) {
		this.sem_fee = sem_fee;
	}
	public int getCom_fee() {
		return com_fee;
	}
	public void setCom_fee(int com_fee) {
		this.com_fee = com_fee;
	}
	public int getMisc() {
		return misc;
	}
	public void setMisc(int misc) {
		this.misc = misc;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getUtr() {
		return utr;
	}
	public void setUtr(int utr) {
		this.utr = utr;
	}
	
	
	
	

}
