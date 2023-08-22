package com.view.service;

import com.view.DTO.UserRequestDTO;
import reactor.core.publisher.Mono;

public interface UserReactiveService {
    Mono<UserRequestDTO> sendUserRequest(UserRequestDTO userRequestDTO);
}
