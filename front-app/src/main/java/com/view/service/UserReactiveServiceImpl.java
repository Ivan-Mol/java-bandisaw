package com.view.service;

import com.view.DTO.UserRequestDTO;
import com.view.DTO.UserResponseDTO;
import com.view.client.ReactiveWebClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserReactiveServiceImpl implements UserReactiveService {
    private final ReactiveWebClient reactiveWebClient;

    @Override
    public Mono<UserRequestDTO> sendUserRequest(UserRequestDTO userRequestDTO) {
        return reactiveWebClient.postUserRequestDto(userRequestDTO);
    }

    @Override
    public Flux<UserResponseDTO> getAllViews() {
        return reactiveWebClient.getAllUsers();
    }
}
