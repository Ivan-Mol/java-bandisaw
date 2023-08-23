package com.view.service;

import com.view.DTO.UserRequestDTO;
import com.view.DTO.UserResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserReactiveService {
    Mono<UserRequestDTO> sendUserRequest(UserRequestDTO userRequestDTO);

    Flux<UserResponseDTO> getAllViews();
}
