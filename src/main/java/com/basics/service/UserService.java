package com.basics.service;

import com.basics.DTO.UserRequestDTO;
import com.basics.model.User;

public interface UserService {
    User createUser(UserRequestDTO requestDTO);

    User getUser(Long id);

    User updateUser(Long userId, UserRequestDTO requestDTO);

    void deleteUser(Long id);
}
