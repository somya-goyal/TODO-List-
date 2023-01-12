package com.somya.resfulwebservices.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {
	
	@Autowired
	private TodoHardcodedService todoService;

	@GetMapping("/users/{user}/todos")
	public List<Todo> getAllTodos(@PathVariable String user) {
		return todoService.getAll();
	}
	@DeleteMapping("/users/{user}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String user,@PathVariable Long id)
	{
		Todo todo = todoService.deleteById(id);
		if(todo!=null)
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();
	}
}
