package io.shubhajyoti.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import io.shubhajyoti.entities.Todo;
import io.shubhajyoti.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController
{
	@Autowired
	private TodoService todoService;
	
	@RequestMapping("/todos")
	public ResponseEntity<List<Todo>> getAllTodos()
	{
		return todoService.getAllTodos();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/todos/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable String id)
	{
		return todoService.getTodoById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/todos")
	public ResponseEntity<String> createTodo(@RequestBody Todo todo)
	{
		String createdAt;
		
		createdAt = new Date().toString();
		
		Todo todoWithDate = new Todo(
				new String(UUID.randomUUID().toString().replaceAll("-","")),//generates a UUID for db key
				todo.getTitle(),
				todo.getDescription(),
				todo.getIsCompleted(),
				createdAt);

		return todoService.createTodo(todoWithDate);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/todos/{id}")
	public ResponseEntity<String> updateTodo(@PathVariable String id,@RequestBody Todo todo)
	{
		return todoService.updateTodo(id, todo);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/todos/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable String id)
	{
		return todoService.deleteTodo(id);
	}

}
