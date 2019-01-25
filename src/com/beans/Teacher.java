package com.beans;

public class Teacher {
	private int id;
	private String name;
	private String password;
	private String lesson;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLesson() {
		return lesson;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
