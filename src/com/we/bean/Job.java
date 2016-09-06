package com.we.bean;

import java.io.Serializable;

public class Job implements Serializable {
	//职位编号
	private int jobid;
	//职位名称
	private String jobName;
	//职位状态 0表示未使用 1表示使用
	private int status;
	
	
	public Job() {}
	
	public Job(int jobid, String jobName,int status) {
		super();
		this.jobid = jobid;
		this.jobName = jobName;
		this.status = status;
	}
	
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
