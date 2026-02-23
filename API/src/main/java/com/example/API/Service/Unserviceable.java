package com.example.API.Service;

import com.example.API.DTO.LoginUserDto;
import com.example.API.Entity.Login;
import com.example.API.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Unserviceable {

    @Autowired
    private LoginRepo loginRepo;

    // CREATE user
    public Login createUser(LoginUserDto dto) {
        Login user = new Login();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());

        return loginRepo.save(user);
    }

    // READ all users
    public List<Login> getAllUsers() {
        return loginRepo.findAll();
    }

    // READ user by id
    public Login getUserById(Long id) {
        Optional<Login> user = loginRepo.findById(id);
        return user.orElse(null);
    }

    // UPDATE user
    public Login updateUser(Long id, LoginUserDto dto) {
        Optional<Login> optionalUser = loginRepo.findById(id);

        if(optionalUser.isPresent()) {
            Login user = optionalUser.get();
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword());
            user.setEmail(dto.getEmail());

            return loginRepo.save(user);
        }
        return null;
    }

    // DELETE user
    public String deleteUser(Long id) {
        loginRepo.deleteById(id);
        return "User deleted successfully";
    }
}