package com.view.controller;

import com.view.service.UserReactiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminUserController {

    private final UserReactiveService userReactiveService;

    @GetMapping("/admin/user")
    public String getAllUsers(Model model) {
        model.addAttribute("users", new ReactiveDataDriverContextVariable(userReactiveService.getAllViews()));
        return "admin-user";
    }
}
