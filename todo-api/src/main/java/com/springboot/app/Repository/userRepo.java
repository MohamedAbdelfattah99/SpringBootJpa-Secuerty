package com.springboot.app.Repository;

import com.springboot.app.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<AppUser, Integer> {

    AppUser findByEmail(String email);
}