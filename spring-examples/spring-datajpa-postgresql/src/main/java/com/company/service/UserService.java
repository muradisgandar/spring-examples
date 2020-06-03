package com.company.service;

import com.company.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDTO save(UserDTO userDTO);

    void delete(Long id);

    List<UserDTO> getAll();

    Page<UserDTO> getAll(Pageable pageable);
}
