package com.somya.resfulwebservices.todo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos=new ArrayList<>();
	private static int idCounter=0;
	
	static {
		todos.add(new Todo(++idCounter,"somya","Angular Project",new Date(),false));
		todos.add(new Todo(++idCounter,"somya","Drone Project",new Date(),false));
		todos.add(new Todo(++idCounter,"somya","Travel to singapore",new Date(),false));
	}
	public List<Todo> getAll()
	{
		return todos;
	}
	
	public Todo deleteById(long id)
	{
		Todo todo=findById(id);
		if(todo==null)
			return null;
		else {
		todos.remove(todo);
		return todo;
		}
	}

	private Todo findById(long id) {
		for( Todo todo:todos)
		{
			if(id==todo.getId())
				return todo;
		}
		return null;
	}
}
