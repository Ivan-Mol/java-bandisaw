package com.view.service;

import com.view.DTO.UserRequestDTO;
import com.view.DTO.UserResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserReactiveService {
    Mono<UserResponseDTO> createUser(UserRequestDTO userRequestDTO);

    Flux<UserResponseDTO> getUsers();

    Mono<Void> deleteUser(long id);

    Mono<UserResponseDTO> getUser(long id);
    public Mono<UserResponseDTO> updateUser(Long id, UserRequestDTO userRequestDTO);
}
