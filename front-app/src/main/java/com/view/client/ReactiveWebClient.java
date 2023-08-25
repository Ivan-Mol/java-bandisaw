package com.view.client;

import com.view.DTO.UserRequestDTO;
import com.view.DTO.UserResponseDTO;
import com.view.service.UserReactiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ReactiveWebClient implements UserReactiveService {

    private static final String USERS_URI = "/users";
    private final WebClient webClient;

    public ReactiveWebClient() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8081")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<UserResponseDTO> createUser(UserRequestDTO userRequestDTO) {
        return webClient
                .post()
                .uri(USERS_URI)
                .bodyValue(userRequestDTO)
                .retrieve()
                .bodyToMono(UserResponseDTO.class);
    }

    public Flux<UserResponseDTO> getUsers() {
        return webClient
                .get()
                .uri(USERS_URI)
                .retrieve()
                .bodyToFlux(UserResponseDTO.class);
    }

    public Mono<Void> deleteUser(long id) {
        return webClient.delete()
                .uri(USERS_URI + "/" + id)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<UserResponseDTO> updateUser(Long id,UserRequestDTO userRequestDTO) {
        return webClient
                .patch()
                .uri(USERS_URI+"/"+id)
                .bodyValue(userRequestDTO)
                .retrieve()
                .bodyToMono(UserResponseDTO.class);
    }

    public Mono<UserResponseDTO> getUser(long id) {
        return webClient.get()
                .uri(USERS_URI + "/" + id)
                .retrieve()
                .bodyToMono(UserResponseDTO.class);
    }
}
