package com.abc.controller;

import com.abc.model.UserDtls;
import com.abc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/singup")
     public String registerForm(@Valid @RequestBody UserDtls userDtls)
    {
        userService.saveData(userDtls);
        return "data save Successfully";
    }

    public ResponseEntity<UserDtls> saveData(@Valid @RequestBody UserDtls userDtls){
        log.info("#################TRYING TO SAVE DATA FOR EMPLOYEE: "+userDtls.getFirstName());
        userService.saveData(userDtls);
        return new ResponseEntity<>(userDtls, HttpStatus.CREATED);
    }


    @RequestMapping("/search")
    public List<UserDtls> search(UserDtls userDtls, @Param("query") String query) {
        List<UserDtls> listUsers = userService.listAll(query);
        return listUsers;
    }

    @GetMapping("/get/")
    public List<UserDtls> fetchAllUserWithDetails(){

        return userService.findAllUserWithDetails();
    }

    @GetMapping("/get/{udId}")
    public UserDtls fetchUserById(@PathVariable("udId") int udId){

        return userService.findUserById(udId);
    }

}
