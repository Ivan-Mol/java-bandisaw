package com.main.service;

import com.main.DTO.UserRequestDTO;
import com.main.model.User;

public interface UserService {
    User createUser(UserRequestDTO requestDTO);

    User getUser(Long id);

    User updateUser(Long userId, UserRequestDTO requestDTO);

    void deleteUser(Long id);
}
