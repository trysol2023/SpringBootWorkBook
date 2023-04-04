package com.sb.workbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todolist")
public class Users {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;
	 @Column(name = "userName", nullable = false)
    private String userName;
	 @Column(name = "description", nullable = false)
    private String description;
	 @Column(name = "dueDate",nullable = false)
    private String dueDate;
	 @Column(name = "status", nullable = false)
    private String status;
    
    public Users() {
    }
    
	public Users(long id, String username, String description, String dueDate, String status) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

}
