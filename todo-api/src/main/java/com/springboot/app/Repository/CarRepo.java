package com.springboot.app.Repository;

import com.springboot.app.Entity.Car;
import com.springboot.app.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface  CarRepo extends JpaRepository<Car, Integer>{

    Car findByName(String name);
}
