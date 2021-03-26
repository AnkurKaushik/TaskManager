package com.example.TaskManager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class AllTasks {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	private String taskName;
	
	private String startDate;
	
	private String endDate;
	
	private String description;
	
	private String taskEmail;
	
	private String severity;
	
	private String userName;

	public AllTasks() {}
	
	public AllTasks(String taskName, String startDate, String endDate, String description, String taskEmail, String severity, String userName)
	{
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.taskEmail = taskEmail;
		this.severity = severity;
		this.userName = userName;
	}
	
	@Override
    public String toString() {
    	return (id.toString() + " " + userName + " " + taskEmail + " " + startDate + " " + endDate + "\n" + description + "[" + severity + "]");
    }
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getTaskEmail() {
		return taskEmail;
	}

	public void setTaskEmail(String taskEmail) {
		this.taskEmail = taskEmail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
