package com.example.API.Repository;

import com.example.API.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, Long> {
    Login findByUsername(String username);

}
