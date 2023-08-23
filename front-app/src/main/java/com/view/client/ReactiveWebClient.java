package com.view.client;

import com.view.DTO.UserRequestDTO;

import com.view.DTO.UserResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class ReactiveWebClient {
    String apiUri = "http://localhost:8081";
    private final WebClient webClient;

    public ReactiveWebClient() {
        this.webClient = WebClient.builder()
                .baseUrl(apiUri)
                //.defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
    public Mono<UserRequestDTO> postUserRequestDto(UserRequestDTO userRequestDTO){
        return webClient.post()
                .uri("/users")
                .bodyValue(userRequestDTO)
                .retrieve()
                .bodyToMono(UserRequestDTO.class);
    }

    public Flux<UserResponseDTO>  getAllUsers() {
        return webClient.get().uri("/users")
                .retrieve().bodyToFlux(UserResponseDTO.class);
    }
}
