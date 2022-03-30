package com.springboot.app.Controller;

import com.springboot.app.Entity.Todo;
import com.springboot.app.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping(value ={ "/",""})
    public List<Todo> getTods(){

        return todoService.getList() ;
    }
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable int id){
        return todoService.getById(id);
    }
    @PostMapping(value = {"","/"})
    public Todo saveTodo(@Valid @RequestBody Todo todo){
            if (todoService.saveTodo(todo)){
                return todo;
            }
        return  null;
    }
}
