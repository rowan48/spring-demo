package com.example.demo.users.service;

import com.example.demo.shared.dto.UserDto;
import com.example.demo.users.model.response.UserRest;

import java.util.List;

public interface UserService {
    public UserRest addUser(UserDto userDto);
    public List<UserRest> findUsersByEmailContains(int page, int limit);
}
