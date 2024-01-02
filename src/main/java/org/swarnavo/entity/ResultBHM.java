package org.swarnavo.entity;

public class ResultBHM {
	
	private int result_id;
	private int roll_no;
	private int epi_health;
	private int support_ut;
	private int fm_ra;
	private int project;
	private String remark;
	
	
	
	public ResultBHM(int roll_no, int epi_health, int support_ut, int fm_ra, int project, String remark) {
		super();
		this.roll_no = roll_no;
		this.epi_health = epi_health;
		this.support_ut = support_ut;
		this.fm_ra = fm_ra;
		this.project = project;
		this.remark = remark;
	}
	public ResultBHM(int result_id, int roll_no, int epi_health, int support_ut, int fm_ra, int project,
			String remark) {
		super();
		this.result_id = result_id;
		this.roll_no = roll_no;
		this.epi_health = epi_health;
		this.support_ut = support_ut;
		this.fm_ra = fm_ra;
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
	public int getEpi_health() {
		return epi_health;
	}
	public void setEpi_health(int epi_health) {
		this.epi_health = epi_health;
	}
	public int getSupport_ut() {
		return support_ut;
	}
	public void setSupport_ut(int support_ut) {
		this.support_ut = support_ut;
	}
	public int getFm_ra() {
		return fm_ra;
	}
	public void setFm_ra(int fm_ra) {
		this.fm_ra = fm_ra;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	
	
	

}
