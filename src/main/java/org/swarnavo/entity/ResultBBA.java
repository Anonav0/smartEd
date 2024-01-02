package org.swarnavo.entity;

public class ResultBBA {
	private int result_id;
	private int roll_no;
	private int management_acc;
	private int ad_sales;
	private int ind_relations;
	private int public_serv;
	private int project;
	private String remark;
	
	
	
	
	public ResultBBA(int roll_no, int management_acc, int ad_sales, int ind_relations, int public_serv, int project,
			String remark) {
		super();
		this.roll_no = roll_no;
		this.management_acc = management_acc;
		this.ad_sales = ad_sales;
		this.ind_relations = ind_relations;
		this.public_serv = public_serv;
		this.project = project;
		this.remark = remark;
	}
	public ResultBBA(int result_id, int roll_no, int management_acc, int ad_sales, int ind_relations, int public_serv,
			int project, String remark) {
		super();
		this.result_id = result_id;
		this.roll_no = roll_no;
		this.management_acc = management_acc;
		this.ad_sales = ad_sales;
		this.ind_relations = ind_relations;
		this.public_serv = public_serv;
		this.project = project;
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
	public int getManagement_acc() {
		return management_acc;
	}
	public void setManagement_acc(int management_ac) {
		this.management_acc = management_ac;
	}
	public int getAd_sales() {
		return ad_sales;
	}
	public void setAd_sales(int ad_sales) {
		this.ad_sales = ad_sales;
	}
	public int getInd_relations() {
		return ind_relations;
	}
	public void setInd_relations(int ind_relations) {
		this.ind_relations = ind_relations;
	}
	public int getPublic_serv() {
		return public_serv;
	}
	public void setPublic_serv(int public_serv) {
		this.public_serv = public_serv;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	
	
}
