package com.company.service.impl;

import com.company.dao.UserRepository;
import com.company.entity.UserEntity;
import com.company.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getUsers(String search)
    {
        return userRepository.findByNameLikeOrSurnameLike(search,search);
    }

    @Override
    public UserEntity add(UserEntity userEntity) {
        System.out.println("burdayam");
        UserEntity userEntity1 = userRepository.save(userEntity);
        System.out.println(userEntity1.getId());
        return userEntity1;
    }

    @Override
    public List<UserEntity> getByCustomQuery(String search) {
        System.out.println("burdayam");
        return userRepository.getByCustomQuery(search);
    }
}
