package com.company.service;

import com.company.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getUsers(String search);

    UserEntity add(UserEntity userEntity);

    List<UserEntity> getByCustomQuery(String search);
}
