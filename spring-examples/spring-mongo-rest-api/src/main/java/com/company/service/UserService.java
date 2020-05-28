package com.company.service;


import com.company.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity add(UserEntity userEntity);

    List<UserEntity> getAll();

}
