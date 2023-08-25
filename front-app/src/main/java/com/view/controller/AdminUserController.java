package com.view.controller;

import com.view.DTO.UserRequestDTO;
import com.view.service.UserReactiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminUserController {
    private final UserReactiveService userReactiveService;

    @GetMapping("/admin/users")
    public String getAllUsersPage(Model model) {
        model.addAttribute("users", new ReactiveDataDriverContextVariable(userReactiveService.getUsers()));
        return "admin-user";
    }

    @PostMapping("/admin/users")
    public Mono<String> createUser(@ModelAttribute("user") UserRequestDTO userRequestDTO) {
        return userReactiveService.createUser(userRequestDTO)
                .thenReturn("redirect:/admin/users");
    }

    @GetMapping("/admin/users/new")
    public String getCreateUserPage(Model model) {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        model.addAttribute("user", userRequestDTO);
        return "admin-user-new";
    }

    @GetMapping("/admin/users/update/{id}")
    public Mono<String> getUpdateUserPage(@PathVariable Long id, Model model) {
        return userReactiveService.getUser(id)
                .map(dto -> model.addAttribute("user", dto))
                .thenReturn("admin-user-update");
    }

    @PostMapping("/admin/users/{id}")
    public Mono<String> updateUser(@PathVariable Long id,
                                   @ModelAttribute("user") UserRequestDTO userRequestDTO, Model model) {
        return userReactiveService.updateUser(id, userRequestDTO).thenReturn("redirect:/admin/users");

    }

    @PostMapping("/admin/users/del/{id}")
    public Mono<String> deleteUser(@PathVariable Long id, Model model) {
        return userReactiveService.deleteUser(id)
                .thenReturn("redirect:/admin/users");
    }
}
