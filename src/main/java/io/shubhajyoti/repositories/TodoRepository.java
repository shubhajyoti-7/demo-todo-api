package io.shubhajyoti.repositories;

import io.shubhajyoti.entities.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, String> {

}
