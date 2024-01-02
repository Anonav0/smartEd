package org.swarnavo.entity;

import java.sql.Date;

public class Admin {

	private int admin_id;
	private String name;
	private int password;
	private Date dob;
	private String gender;
	private String email;
	private String squestion;
	private String sanswer;
	private byte[] imageData;
	
	
	
	public Admin(String name, String sanswer) {
		super();
		this.name = name;
		this.sanswer = sanswer;
	}
	public Admin(String name, int password, Date dob, String gender, String email, byte[] imageData) {
		super();
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.imageData = imageData;
	}
	public Admin(String name, int password, Date dob, String gender, String email, String squestion, String sanswer) {
		super();
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.squestion = squestion;
		this.sanswer = sanswer;
	}
	public Admin(String name, int password) {
		super();
		this.name = name;
		this.password = password;
	}
	public Admin(String name, int password, Date dob, String gender, String email, String squestion, String sanswer, byte[] imageData) {
		super();
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.squestion = squestion;
		this.sanswer = sanswer;
		this.imageData = imageData;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public Admin(int admin_id, String name, int password, Date dob, String gender, String email, String squestion,
			String sanswer, byte[] imageData) {
		super();
		this.admin_id = admin_id;
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.squestion = squestion;
		this.sanswer = sanswer;
		this.imageData = imageData;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSquestion() {
		return squestion;
	}
	public void setSquestion(String squestion) {
		this.squestion = squestion;
	}
	public String getSanswer() {
		return sanswer;
	}
	public void setSanswer(String sanswer) {
		this.sanswer = sanswer;
	}
	
	
	
	
	
}
