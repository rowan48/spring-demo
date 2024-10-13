package com.example.demo.users.service.impl;

import com.example.demo.shared.dto.UserDto;
import com.example.demo.shared.utils;
import com.example.demo.users.entity.UserEntity;
import com.example.demo.users.model.response.UserRest;
import com.example.demo.users.repository.UserEntityRepository;
import com.example.demo.users.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserEntityRepository userEntityRepository;
    utils utils;

    UserServiceImpl(UserEntityRepository userEntityRepository, utils utils){
        this.userEntityRepository = userEntityRepository;
        this.utils = utils;
    }
    @Override
    public UserRest addUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto,userEntity);
        String userIdGenerated=utils.generateUserId(30);
        userEntity.setUserId(userIdGenerated);
        userEntity.setEncryptedPassword("encryptedPassword");
        userEntityRepository.save(userEntity);
        UserRest savedUserDto=new UserRest();
        BeanUtils.copyProperties(userEntity,savedUserDto);
        return savedUserDto;
    }
}
