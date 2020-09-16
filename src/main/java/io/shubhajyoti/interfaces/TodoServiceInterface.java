package io.shubhajyoti.interfaces;

import io.shubhajyoti.entities.Todo;

import java.util.List;

public interface TodoServiceInterface {

    public List<Todo> getAllTodos();

    public Todo getTodoById(Long id);

    public String createTodo(Todo todo);

    public String updateTodo(Long id,Todo todo);

    public String deleteTodo(Long id);
}
