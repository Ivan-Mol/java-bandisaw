package com.view.controller;

import com.view.DTO.UserRequestDTO;
import com.view.service.UserReactiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final UserReactiveService userReactiveService;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("userRequestDTO", new UserRequestDTO());
        return "index";
    }

    @PostMapping(value = "/")
    public Mono<String> postUserData(Model model, @ModelAttribute UserRequestDTO userRequestDTO) {
        log.info("request: {}", userRequestDTO);
        return userReactiveService.sendUserRequest(userRequestDTO)
                .doOnNext(u -> log.info("response: {}", u))
                .doOnError(e -> log.error("error: {}", e.getMessage()))
                .onErrorReturn(new UserRequestDTO())
                .map(any -> "index");
    }
}