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
    public Mono<UserResponseDTO> sendUserRequest(String uri, UserRequestDTO userRequestDTO) {
        return reactiveWebClient.postUserRequestDto(uri, userRequestDTO);
    }

    @Override
    public Flux<UserResponseDTO> getAllUsers() {
        return reactiveWebClient.getAllUsers();
    }

    @Override
    public void sendDeleteByIdRequest(String uri, Long id) {
        reactiveWebClient.sendDeleteByIdRequest(uri, id);
    }

    @Override
    public Mono<UserResponseDTO> sendGetByIdRequest(String uri, Long id) {
        return reactiveWebClient.sendGetByIdRequest(uri, id);
    }

    @Override
    public Mono<UserResponseDTO> sendPostRequest(String url, UserRequestDTO userRequestDTO) {
        return reactiveWebClient.postUserRequestDto(url, userRequestDTO);
    }
}
