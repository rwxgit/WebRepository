package com.gandhi.springweb.model;

import java.util.Date;

public class Todo {

	private int id;
	private String user;
	private String desc;
	private Date targetDate;
	private boolean isDone;

	public Todo(int i, String string, String string2, Date date, boolean b) {
		this.setId(i);
		this.setUser(string);
		this.setDesc(string2);
		this.setTargetDate(date);
		this.setDone(b);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
