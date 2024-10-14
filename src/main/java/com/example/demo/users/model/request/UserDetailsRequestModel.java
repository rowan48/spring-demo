package com.example.demo.users.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDetailsRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
