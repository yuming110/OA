package com.we.bean;

import java.io.Serializable;

public class Menu implements Serializable{
	//菜单编号
	private int menuid;
	//菜单名称
	private String mName;
	//连接地址
	private String url;
	//是否显示 1.显示 0.不显示
	private int isshow;
	//菜单级别
	private int level;
	//父类菜单
	private int parentid;
	
	
	public Menu() {}


	public Menu(int menuid, String mName, String url, int isshow, int level,
			int parentid) {
		super();
		this.menuid = menuid;
		this.mName = mName;
		this.url = url;
		this.isshow = isshow;
		this.level = level;
		this.parentid = parentid;
	}


	public int getMenuid() {
		return menuid;
	}


	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public int getIsshow() {
		return isshow;
	}


	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getParentid() {
		return parentid;
	}


	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	
	
	
}
