package com.ln.web.model;

public class TabRow {
	private int id;
	private String username;
	private String password;
	private String role;
	private String name;
	private int age;
	private String theclass;
	private int class_grade;
	private int chapter;
	private int test_grade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTheclass() {
		return theclass;
	}
	public void setTheclass(String theclass) {
		this.theclass = theclass;
	}
	public int getClass_grade() {
		return class_grade;
	}
	public void setClass_grade(int class_grade) {
		this.class_grade = class_grade;
	}
	public int getChapter() {
		return chapter;
	}
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
	public int getTest_grade() {
		return test_grade;
	}
	public void setTest_grade(int test_grade) {
		this.test_grade = test_grade;
	}
	@Override
	public String toString() {
		return id + " "
				+ username + " "
				+ password + " "
				+ role + " "
				+ name + " "
				+ age + " "
				+ theclass + " "
				+ class_grade + " "
				+ chapter + " "
				+ test_grade + " ";
	}

	
}
