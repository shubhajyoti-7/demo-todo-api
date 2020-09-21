package io.shubhajyoti.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.shubhajyoti.entities.Todo;
import io.shubhajyoti.interfaces.TodoServiceInterface;
import io.shubhajyoti.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TodoService implements TodoServiceInterface {
	
	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<Todo> getAllTodos()
	{
		try
		{
			List<Todo> todoList = new ArrayList<Todo>();
			todoRepository.findAll().forEach(elem -> todoList.add(elem));
			return todoList;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public Todo getTodoById(Long id)
	{
		try
		{
			return todoRepository.findById(id).get();//if empty get() throws a NoSuchElementExcpetion
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public String createTodo(Todo todo)
	{
		try
		{
			todoRepository.save(todo);
			return "Todo saved";
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public String updateTodo(Long id, Map<String,Object> changes)
	{
		try
		{
			Todo todo = getTodoById(id);
			changes.forEach((change,value)->{
				switch (change)
				{
					case "title":
						todo.setTitle((String)value);
						break;
					case "description":
						todo.setDescription((String)value);
						break;
					case "isCompleted":
						todo.setIsCompleted((Boolean)value);
						break;
					default:
						throw new IllegalStateException();
				}
			});

			todoRepository.save(todo);
			return "Todo updated!";
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public String deleteTodo(Long id)
	{
		try
		{
			todoRepository.deleteById(id);
			return "Todo deleted!";
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
}


