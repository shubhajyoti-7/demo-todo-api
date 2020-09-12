package io.shubhajyoti.todo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;




@Entity
public class Todo {
	
	@Id
	private String todoId;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String description;
	@Column(nullable=false)
	private Boolean isCompleted;
	@Column(nullable=false)
	private String createdAt;
	
	public Todo()
	{
		
	}
	public Todo(String todoId,String title,String description,Boolean isCompleted,String createdAt)
	{
		this.todoId = todoId;
		this.title = title;
		this.description = description;
		this.isCompleted = isCompleted;
		this.createdAt=createdAt;
	}
	public String getTodoId() {
		return todoId;
	}
	
	public void setTodoId(String todoId) {
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
