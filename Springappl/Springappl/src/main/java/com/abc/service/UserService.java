package com.abc.service;

import com.abc.model.UserDtls;
import com.abc.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDtls saveData(UserDtls userDtls){

        return userRepo.save(userDtls);

    }

    public List<UserDtls> listAll(String query) {
        if (query != null) {
            return userRepo.searchUserDetails(query);
        }
        return userRepo.findAll();
    }


    public List<UserDtls> findAllUserWithDetails() {
        return userRepo.findAll();
    }

    public UserDtls findUserById(int udId) {
        return userRepo.findById(udId).orElse(null);
    }

}
