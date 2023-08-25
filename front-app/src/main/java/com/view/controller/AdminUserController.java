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

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminUserController {

    private final UserReactiveService userReactiveService;

    @GetMapping("/admin/users")
    public String getAllUsersPage(Model model) {
        model.addAttribute("users", new ReactiveDataDriverContextVariable(userReactiveService.getAllUsers()));
        return "admin-user";
    }

    @PostMapping("/admin/users")
    public String postUser(@ModelAttribute("user") UserRequestDTO userRequestDTO) {
        log.debug("POST /admin/users ");
        userReactiveService.sendPostRequest("/users", userRequestDTO);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/new")
    public String getCreateUserPage(Model model) {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        model.addAttribute("user", userRequestDTO);
        log.debug("GET /admin/users/new ");
        return "admin-user-new";
    }

    @GetMapping("/admin/users/update/{id}")
    public String getUpdateUserPage(@PathVariable Long id, Model model) {
        model.addAttribute("view", userReactiveService.sendGetByIdRequest("/users", id));
        log.debug("GET /admin/users/update/ " + id);
        return "admin-user-update";
    }

    @PostMapping("/admin/users/del/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        System.out.println("delete");
        userReactiveService.sendDeleteByIdRequest("/users", id);
        return "redirect:/admin/users";
    }
}
