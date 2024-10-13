package com.example.demo.users.controller;

import com.example.demo.shared.dto.UserDto;
import com.example.demo.users.model.request.UserDetailsRequestModel;
import com.example.demo.users.model.response.UserRest;
import com.example.demo.users.service.UserService;
import org.hibernate.internal.build.AllowNonPortable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private  UserService userService;
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserRest>addUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel) {
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userDetailsRequestModel, userDto);
        return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.OK);


    }
}
