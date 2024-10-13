package com.example.demo.users.service;

import com.example.demo.shared.dto.UserDto;
import com.example.demo.users.entity.UserEntity;
import com.example.demo.users.model.response.UserRest;

public interface UserService {
    public UserRest addUser(UserDto userDto);
}
