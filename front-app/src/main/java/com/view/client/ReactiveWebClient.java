package com.view.client;

import com.view.DTO.UserRequestDTO;
import com.view.DTO.UserResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ReactiveWebClient {
    private final String MAIN_API_URI = "http://localhost:8081";
    private final WebClient webClient;

    public ReactiveWebClient() {
        this.webClient = WebClient.builder()
                .baseUrl(MAIN_API_URI)
                //.defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<UserResponseDTO> postUserRequestDto(String uri, UserRequestDTO userRequestDTO) {
        System.out.println(userRequestDTO);
        return webClient
                .post()
                .uri(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(userRequestDTO)
                .retrieve()
                .bodyToMono(UserResponseDTO.class);
    }

    public Flux<UserResponseDTO> getAllUsers() {
        return webClient
                .get()
                .uri("/users")
                .retrieve().bodyToFlux(UserResponseDTO.class);
    }

    public void sendDeleteByIdRequest(String uri, Long id) {
        System.out.println("delete request with " + uri + " and Id " + id);
        webClient.delete()
                .uri("/users/" + id)
                .retrieve().bodyToMono(Void.class).subscribe();
    }

    public Mono<UserResponseDTO> sendGetByIdRequest(String uri, Long id) {
        System.out.println("get request with " + uri + " and Id " + id);
        return webClient.get()
                .uri("/users")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(UserResponseDTO.class);
    }
}
