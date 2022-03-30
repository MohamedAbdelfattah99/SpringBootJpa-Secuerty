package com.springboot.app.Service;

import com.springboot.app.Entity.Todo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {
    private List<Todo>list= Arrays.asList(new Todo(1,"Mohamed","abdelfattah"),
            new Todo(2,"Ahmed","moo"));

    public List<Todo> getList() {
        return list;
    }

    public void setList(List<Todo> list) {
        this.list = list;
    }

    public Todo getById(int id) {
        for (int i=0;i<this.list.size();i++){
            if(this.list.get(i).getId()==id){
                return this.list.get(i);
            }
        }
        return  null;
    }
    public  boolean saveTodo(Todo todo){
        this.list=Arrays.asList(todo);
            return true;

       // return false;
    }
}
