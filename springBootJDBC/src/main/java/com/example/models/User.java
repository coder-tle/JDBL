package com.example.models;

public class User {
	private int id;
	private String name;
    private String firstName;
    private String lastName;
    private boolean isSeniorCitizen;
    private int age;
    private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isSeniorCitizen() {
		return isSeniorCitizen;
	}
	public void setSeniorCitizen(boolean isSeniorCitizen) {
		this.isSeniorCitizen = isSeniorCitizen;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name="+ name+ ", firstName=" + firstName + ", lastName=" + lastName + ", isSeniorCitizen="
				+ isSeniorCitizen + ", age=" + age + ", email=" + email + "]";
	}
    

}
