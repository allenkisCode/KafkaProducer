package com.example.beans;

public class PatientInfo {

	private String name;
	private String preferences;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreferences() {
		return preferences;
	}
	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PatientInfo [name=" + name + ", preferences=" + preferences + ", age=" + age + "]";
	}
	
}
