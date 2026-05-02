package com.jobtracker.demo.model;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="job")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer jobID;
	
	private String company;
	private String role;
	private String status;
	public Job() {}
	//for testing
	public Job(Integer id, String company, String role, String status) {
	    this.jobID = id;
	    this.company = company;
	    this.role = role;
	    this.status = status;
	}
	public  Integer getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
