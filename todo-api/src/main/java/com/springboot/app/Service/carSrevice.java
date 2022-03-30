package com.springboot.app.Service;


import com.springboot.app.Entity.Car;
import com.springboot.app.ExceptionsHandler.ConfilcError;
import com.springboot.app.ExceptionsHandler.NotfoundEx;
import com.springboot.app.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.NoSuchElementException;

@Service
public class carSrevice {

    @Autowired
    CarRepo carRepo;

    public boolean addCar(Car car){
        System.out.println("befor");

        if(carRepo.findByName(car.getName())!= null){
            System.out.println("asdsad");
            throw new ConfilcError(String.format("car with same name exitsts"));
        }
        carRepo.save(car);
        return true;
    }

    public Car getCarById(int id ){
        Car output=new Car();
        try {
            output = carRepo.findById(id).get();
        } catch (NoSuchElementException ex ) {
           throw  new NotfoundEx(String.format("this id has now car stored "));
        }
        return output;
    }
}
