package com.thanmayee.Hibernate;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentName {
	private String sname;
	private String fname;
	private String lname;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "StudentName [sname=" + sname + ", fname=" + fname + ", lname=" + lname + "]";
	}

}
