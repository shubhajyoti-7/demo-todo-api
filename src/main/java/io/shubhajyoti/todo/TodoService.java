package io.shubhajyoti.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public ResponseEntity<List<Todo>> getAllTodos()
	{
		try
		{
			List<Todo> todoList = new ArrayList<Todo>();
			todoRepository.findAll().forEach(elem -> todoList.add(elem));
			return new ResponseEntity<List<Todo>>(todoList,HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Unable to fetch todos!",e);
		}
	}
	
	public ResponseEntity<Todo> getTodoById(String id)
	{
		try
		{
			return new ResponseEntity<Todo>(todoRepository.findById(id).get(),HttpStatus.OK);//if empty get() throws a NoSuchElementExcpetion
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Todo id not found!",e);
		}
	}
	
	public ResponseEntity<String> createTodo(Todo todo)
	{
		try
		{
			todoRepository.save(todo);
			return new ResponseEntity<String>("Todo saved!",HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Failed to create the todo. Try again!",e);
		}
	}
	
	public ResponseEntity<String> updateTodo(String id,Todo todo)
	{
		try
		{

			getTodoById(id); // Check whether the id exists in the db
			todo.setTodoId(id);
			todo.setCreatedAt(new Date().toString());
			todoRepository.save(todo);//Updates by overwriting the existing entry with the same id(Key)
			return new ResponseEntity<String>("Todo updated!",HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Updation unsuccessful",e);
		}
	}
	
	public ResponseEntity<String> deleteTodo(String id)
	{
		try
		{
			todoRepository.deleteById(id);
			return new ResponseEntity<String>("Todo deleted!",HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Deletion unsuccessful!",e);
		}
	}
	
}


