package ie.aidan.domain;

import java.sql.Date;

public class Student {
	private int student_id;
	private String firstname;
	private String lastname;
	private Date  dob;
	private String password;
	private int class_id;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", dob=" + dob + ", password="
				+ password + ", class_id=" + class_id + "]";
	}
	
	
}
