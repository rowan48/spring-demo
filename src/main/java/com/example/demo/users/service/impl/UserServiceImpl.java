package com.example.demo.users.service.impl;

import com.example.demo.shared.dto.UserDto;
import com.example.demo.shared.utils;
import com.example.demo.users.entity.Users;
import com.example.demo.users.model.response.UserRest;
import com.example.demo.users.repository.UserEntityRepository;
import com.example.demo.users.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserEntityRepository userEntityRepository;
    @Autowired
    utils utils;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserRest addUser(UserDto userDto) {
        Users user = new Users();
       BeanUtils.copyProperties(userDto,user);
        String userIdGenerated=utils.generateUserId(30);
       user.setUserId(userIdGenerated);
        user.setRole(userDto.getRole());
       user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntityRepository.save(user);
        UserRest savedUserDto=new UserRest();
        BeanUtils.copyProperties(user,savedUserDto);
        return savedUserDto;
    }

    @Override
    public List<UserRest> findUsersByEmailContains(int page, int limit) {
        Pageable pageableRequest = PageRequest.of(page, limit);
     Page<Users> userPage=userEntityRepository.findAll( pageableRequest);
     if(userPage.hasContent()){
         List<Users> users = userPage.getContent();
         List<UserRest> userRests = new ArrayList<>();
         for (Users user : users) {
             UserRest savedUserDto=new UserRest();

             BeanUtils.copyProperties(user,savedUserDto);
             userRests.add(savedUserDto);
         }
         return userRests;
     }


        return null;
    }
}
