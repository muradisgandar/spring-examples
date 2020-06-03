package com.company.service.impl;

import com.company.dto.UserDTO;
import com.company.mapper.UserMapper;
import com.company.model.AddressEnum;
import com.company.model.entity.AddressEntity;
import com.company.model.entity.UserEntity;
import com.company.repository.AddressRepository;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public UserDTO save(UserDTO userDTO) {
        Objects.requireNonNull(userDTO.getName(), "Must not be null");
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setSurname(userDTO.getSurname());

        UserEntity userEntityDb = userRepository.save(userEntity);

        List<AddressEntity> list = new ArrayList<>();

        userDTO.getAddressDTOS().forEach(item -> {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setAddressEnum(AddressEnum.ANOTHER);
            addressEntity.setIsActive(true);
            addressEntity.setUserEntity(userEntityDb);
            list.add(addressEntity);
        });

        addressRepository.saveAll(list);

        userDTO.setId(userEntityDb.getId());

        return userDTO;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDTO> getAll() {

        return UserMapper.INSTANCE.entityListToDtoList(userRepository.findAll());
    }

    @Override
    public Page<UserDTO> getAll(Pageable pageable) {
        return null;
    }
}
