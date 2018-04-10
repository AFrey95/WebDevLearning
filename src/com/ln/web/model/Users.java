package com.ln.web.model;

public class Users {

	private String name;
	private String occupation;
	private int age;
	
	public Users(String n, String o, int a) {
		this.name = n;
		this.occupation = o;
		this.age = a;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
