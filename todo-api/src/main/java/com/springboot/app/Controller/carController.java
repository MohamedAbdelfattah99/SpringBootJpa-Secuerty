package com.springboot.app.Controller;

import com.springboot.app.Entity.Car;
import com.springboot.app.Service.carSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/todo/car")
public class carController {
    @Autowired
        carSrevice carService;


    @PostMapping("")
    public ResponseEntity<String> addCar(@Valid @RequestBody Car car ){

        carService.addCar(car);



        return  new ResponseEntity<>("car add sucssfuly", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable  int id ){
        return  new ResponseEntity<>(carService.getCarById(id),HttpStatus.ACCEPTED);
    }
}
