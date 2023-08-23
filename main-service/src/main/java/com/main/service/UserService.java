package com.main.service;

import com.main.DTO.user.UserRequestDTO;
import com.main.DTO.user.UserResponseDTO;
import com.main.model.User;
import reactor.core.publisher.Flux;

import java.util.List;

public interface UserService {
    User createUser(UserRequestDTO requestDTO);

    User getUser(Long id);

    User updateUser(Long userId, UserRequestDTO requestDTO);

    void deleteUser(Long id);
    List<UserResponseDTO> getAll();
}
