package com.view.client;

import com.view.DTO.UserRequestDTO;
import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.Collections;
import java.util.UUID;

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
    public Mono<UserRequestDTO> sendUserRequestDto(UserRequestDTO userRequestDTO){
        return webClient.post()
                .uri("/users")
                .bodyValue(userRequestDTO)
                .retrieve()
                .bodyToMono(UserRequestDTO.class);
    }
}
