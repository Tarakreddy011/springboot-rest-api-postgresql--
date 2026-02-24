package com.example.API.Service;

import com.example.API.Entity.UserInfo;
import com.example.API.Repository.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepo userInfoRepo;


    // CREATE UserInfo
    public UserInfo createUserInfo(UserInfo userInfo) {
        return userInfoRepo.save(userInfo);
    }

    // GET all
    public List<UserInfo> getAllUserInfo() {
        return userInfoRepo.findAll();
    }

    // GET by id
    public UserInfo getUserInfoById(Long id) {
        return userInfoRepo.findById(id).orElse(null);
    }

    // DELETE
    public void deleteUserInfo(Long id) {
        userInfoRepo.deleteById(id);
    }
    // update
    public void UpdateUserInfo(UserInfo userInfo) {
        userInfoRepo.save(userInfo);
    }

    public UserInfo assignPhotoToUser(Long userId, String photoUrl) {
        if (photoUrl == null || photoUrl.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "photoUrl is required");
        }

        UserInfo userInfo = userInfoRepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found for id: " + userId));

        userInfo.setPhotoUrl(photoUrl);
        return userInfoRepo.save(userInfo);
    }

}
