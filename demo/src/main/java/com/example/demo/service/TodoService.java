package com.example.demo.service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Todo criar (Todo todo){
      return repository.save(todo);
    }

    public Todo lerUm(Long id){
        return repository.findById(id).get();
    }

    public List<Todo> lerTodos(){
       return repository.findAll();
    }

    public Todo atualizar(Todo todo){
        if(Objects.isNull(todo.getId()))return null;
        return repository.save(todo);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

}
