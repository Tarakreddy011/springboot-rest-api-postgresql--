package com.example.API.Controller;

import com.example.API.DTO.LoginUserDto;
import com.example.API.Entity.Login;
import com.example.API.Service.Unserviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class LoginUserController {

    @Autowired
    private Unserviceable loginuserservice;

    // CREATE
    @PostMapping
    public Login createUser(@RequestBody LoginUserDto dto) {
        return loginuserservice.createUser(dto);
    }

    // READ ALL
    @GetMapping
    public List<Login> getAllUsers() {
        return loginuserservice.getAllUsers();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Login getUserById(@PathVariable Long id) {
        return loginuserservice.getUserById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Login updateUser(@PathVariable Long id,
                            @RequestBody LoginUserDto dto) {
        return loginuserservice.updateUser(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return loginuserservice.deleteUser(id);
    }
}