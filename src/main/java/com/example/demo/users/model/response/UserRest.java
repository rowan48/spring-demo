package com.example.demo.users.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRest {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
