package com.example.demo.users.controller;

import com.example.demo.shared.dto.UserDto;
import com.example.demo.users.model.request.UserDetailsRequestModel;
import com.example.demo.users.model.response.UserRest;
import com.example.demo.users.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TestSecController {
    @Autowired
    private UserService userService;
    @GetMapping("/home")
    public String handleWelcome() {
        return "Welcome to home!";
    }

    @GetMapping("/admin/home")
  //  @PreAuthorize("hasRole()")
    public String handleAdminHome() {
        return "Welcome to ADMIN home!";
    }

    @GetMapping("/user/home")
    public String handleUserHome() {
        return "Welcome to USER home!";
    }
    @GetMapping("/myUsers")
    public ResponseEntity<List<UserRest>>findUsersByEmailContains(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                  @RequestParam(value = "limit", defaultValue = "2") int limit) {

        return new ResponseEntity<>(userService.findUsersByEmailContains(page,limit), HttpStatus.OK);


    }

}
