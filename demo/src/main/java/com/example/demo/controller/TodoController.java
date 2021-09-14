package com.example.demo.controller;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(path = "todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping
    public ResponseEntity inserir(@RequestBody Todo todo){
        return ok(service.criar(todo));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity lerUm(@PathVariable Long id ){
       return ok(service.lerUm(id));
    }
    @GetMapping
    public  ResponseEntity lerTodos(){
        return ok(service.lerTodos());
    }
    @PutMapping
    public ResponseEntity atualizar(@RequestBody Todo todo){
        return ok(service.atualizar(todo));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        service.deletar(id);
        return ok("Success");
    }
}
