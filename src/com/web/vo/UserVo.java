package com.web.vo;

import java.io.Serializable;

public class UserVo implements Serializable{

	//用户编号
	private int uid;
	//用户账号
	private String userName;
	//用户登录密码
	private String userPass;
	//用户名字
	private String uName;
	//部门
	private String dpmid;
	//职位
	private String jobid;
	//职称
	private String jobtitle;
	
	
	public String toString(){
		return "{\"uid\":"+uid+",\"userName\":"+userName+",\"userPass\":"+userPass+",\"uName\":"+uName+",\"dpmid\":"+dpmid+",\"jobid\":"+jobid+",\"jobtitle\":"+jobtitle+"}";
	}
	
	public UserVo() {}


	public UserVo(int uid, String userName, String userPass, String uName,
			String dpmid, String jobid, String jobtitle) {
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

	public String getDpmid() {
		return dpmid;
	}

	public void setDpmid(String dpmid) {
		this.dpmid = dpmid;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}



	public String getJobtitle() {
		return jobtitle;
	}



	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	
	
}
