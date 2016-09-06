package com.we.bean;

import java.io.Serializable;

public class User implements Serializable{
	//用户编号
	private int uid;
	//用户账号
	private String userName;
	//用户登录密码
	private String userPass;
	//用户名字
	private String uName;
	//部门
	private int dpmid;
	//职位
	private int jobid;
	//职称
	private int jobtitle;
	
	
	public User() {}


	public User(int uid, String userName, String userPass, String uName,
			int dpmid, int jobid, int jobtitle) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.userPass = userPass;
		this.uName = uName;
		this.dpmid = dpmid;
		this.jobid = jobid;
		this.jobtitle = jobtitle;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public int getDpmid() {
		return dpmid;
	}


	public void setDpmid(int dpmid) {
		this.dpmid = dpmid;
	}


	public int getJobid() {
		return jobid;
	}


	public void setJobid(int jobid) {
		this.jobid = jobid;
	}


	public int getJobtitle() {
		return jobtitle;
	}


	public void setJobtitle(int jobtitle) {
		this.jobtitle = jobtitle;
	}

	
	
	
	

}
