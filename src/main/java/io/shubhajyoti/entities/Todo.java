package io.shubhajyoti.entities;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long todoId;

	@Column(nullable=false)
	private String title;

	@Column(nullable=false)
	private String description;

	@Column(nullable=false)
	private Boolean isCompleted;

	@CreationTimestamp
	@Column(nullable=false)
	private Date createdAt;
	
	public Todo()
	{
		
	}
	public Todo(String title,String description,Boolean isCompleted)
	{
		this.title = title;
		this.description = description;
		this.isCompleted = isCompleted;
	}
	public Long getTodoId() {
		return todoId;
	}

	public void setTodoId(Long todoId) {
		this.todoId = todoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
