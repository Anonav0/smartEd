package org.swarnavo.entity;

public class ResultBCA {
	private int result_id;
	private int roll_no;
	private int it;
	private int network;
	private int elective;
	private int it_lab;
	private int network_lab;
	private int minor_project;
	private String remark;
	
	
	
	
	public ResultBCA(int roll_no, int it, int network, int elective, int it_lab, int network_lab, int minor_project,
			String remark) {
		super();
		this.roll_no = roll_no;
		this.it = it;
		this.network = network;
		this.elective = elective;
		this.it_lab = it_lab;
		this.network_lab = network_lab;
		this.minor_project = minor_project;
		this.remark = remark;
	}


	public ResultBCA(int result_id, int roll_no, int it, int network, int elective, int it_lab, int network_lab,
			int minor_project, String remark) {
		super();
		this.result_id = result_id;
		this.roll_no = roll_no;
		this.it = it;
		this.network = network;
		this.elective = elective;
		this.it_lab = it_lab;
		this.network_lab = network_lab;
		this.minor_project = minor_project;
		this.remark = remark;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	
	
	public int getResult_id() {
		return result_id;
	}
	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public int getIt() {
		return it;
	}
	public void setIt(int it) {
		this.it = it;
	}
	public int getNetwork() {
		return network;
	}
	public void setNetwork(int network) {
		this.network = network;
	}
	public int getElective() {
		return elective;
	}
	public void setElective(int elective) {
		this.elective = elective;
	}
	public int getIt_lab() {
		return it_lab;
	}
	public void setIt_lab(int it_lab) {
		this.it_lab = it_lab;
	}
	public int getNetwork_lab() {
		return network_lab;
	}
	public void setNetwork_lab(int network_lab) {
		this.network_lab = network_lab;
	}
	public int getMinor_project() {
		return minor_project;
	}
	public void setMinor_project(int minor_project) {
		this.minor_project = minor_project;
	}
	
	
}
