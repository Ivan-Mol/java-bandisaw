package com.view.service;

import com.view.DTO.UserRequestDTO;
import com.view.DTO.UserResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserReactiveService {
    Mono<UserResponseDTO> sendUserRequest(String uri, UserRequestDTO userRequestDTO);

    Flux<UserResponseDTO> getAllUsers();

    void sendDeleteByIdRequest(String uri, Long id);

    Mono<UserResponseDTO> sendGetByIdRequest(String uri, Long id);

    Mono<UserResponseDTO> sendPostRequest(String url, UserRequestDTO userRequestDTO);
}
