package io.shubhajyoti.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.shubhajyoti.entities.Todo;
import io.shubhajyoti.interfaces.TodoServiceInterface;
import io.shubhajyoti.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TodoController
{
	@Autowired
	private TodoServiceInterface todoService;
	
	@RequestMapping("/todos")
	public ResponseEntity<List<Todo>> getAllTodos()
	{
		try
		{
			return new ResponseEntity<List<Todo>>(todoService.getAllTodos(), HttpStatus.OK);
		}
		catch (Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Unable to fetch todos!",e);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/todos/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable Long id)
	{
		try {
			return new ResponseEntity<Todo>(todoService.getTodoById(id), HttpStatus.OK);
		}
		catch (Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Todo id not found!",e);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/todos")
	public ResponseEntity<String> createTodo(@RequestBody Todo todo)
	{
		try {
			return new ResponseEntity<String>(todoService.createTodo(todo),HttpStatus.CREATED);
		}
		catch (Exception e)
		{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Failed to create the todo. Try again!",e);
		}
	}
	
	@RequestMapping(method=RequestMethod.PATCH,value="/todos/{id}")
	public ResponseEntity<String> updateTodo(@PathVariable Long id,@RequestBody Map<String,Object> changes)
	{
		try {
			return new ResponseEntity<String>(todoService.updateTodo(id,changes),HttpStatus.OK);
		}
		catch (Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Updation unsuccessful",e);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/todos/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable Long id)
	{
		try {
			return new ResponseEntity<String>(todoService.deleteTodo(id),HttpStatus.OK);
		}
		catch (Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Deletion unsuccessful!",e);
		}
	}

}
