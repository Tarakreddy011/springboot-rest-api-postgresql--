package com.example.API.Controller;

import com.example.API.DTO.UserPhotoUrlDto;
import com.example.API.Entity.UserInfo;
import com.example.API.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    // CREATE
    @PostMapping
    public UserInfo createUser(@RequestBody UserInfo userInfo) {
        return userInfoService.createUserInfo(userInfo);
    }

    // GET ALL
    @GetMapping
    public List<UserInfo> getAllUsers() {
        return userInfoService.getAllUserInfo();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public UserInfo getUser(@PathVariable Long id) {
        return userInfoService.getUserInfoById(id);
    }

    // ASSIGN PHOTO URL TO USER
    @PutMapping("/{id}/photo")
    public UserInfo assignPhotoToUser(@PathVariable Long id, @RequestBody UserPhotoUrlDto userPhotoDto) {
        return userInfoService.assignPhotoToUser(id, userPhotoDto.getPhotoUrl());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userInfoService.deleteUserInfo(id);
    }
}
