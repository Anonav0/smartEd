package org.swarnavo.entity;

public class StudentResultBCA {
	
	private String roll_no;
	private String course;
	private String branch;
	private String name;
	private String father_name;
	private String gender;
	private String it;
	private String network;
	private String elective;
	private String it_lab;
	private String network_lab;
	private String minor_project;
	private String remark;
	
	
	
	public StudentResultBCA(String roll_no, String course, String branch, String name, String father_name, String gender,
			String it, String network, String elective, String it_lab, String network_lab, String minor_project,
			String remark) {
		super();
		this.roll_no = roll_no;
		this.course = course;
		this.branch = branch;
		this.name = name;
		this.father_name = father_name;
		this.gender = gender;
		this.it = it;
		this.network = network;
		this.elective = elective;
		this.it_lab = it_lab;
		this.network_lab = network_lab;
		this.minor_project = minor_project;
		this.remark = remark;
	}
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
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
	public String getIt() {
		return it;
	}
	public void setIt(String it) {
		this.it = it;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getElective() {
		return elective;
	}
	public void setElective(String elective) {
		this.elective = elective;
	}
	public String getIt_lab() {
		return it_lab;
	}
	public void setIt_lab(String it_lab) {
		this.it_lab = it_lab;
	}
	public String getNetwork_lab() {
		return network_lab;
	}
	public void setNetwork_lab(String network_lab) {
		this.network_lab = network_lab;
	}
	public String getMinor_project() {
		return minor_project;
	}
	public void setMinor_project(String minor_project) {
		this.minor_project = minor_project;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
