package com.example.demo.users.controller;

import com.example.demo.users.entity.LoginForm;
import com.example.demo.users.service.impl.JWTServiceImpl;
import com.example.demo.users.service.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping
public class ContentController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserDetailService userDetailService;

    @Autowired
    JWTServiceImpl jwtService;
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.email(), loginForm.password()
        ));
        if (authentication.isAuthenticated()) {
            String tok=jwtService.generateToken(userDetailService.loadUserByUsername(loginForm.email()));
            return tok ;
        } else {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }
}
