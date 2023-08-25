package com.view.controller;

import com.view.DTO.ViewRequestDTO;
import com.view.service.ViewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j

public class AdminViewController {
    private final ViewService viewService;

    @GetMapping("/admin/views")
    public String getViews(Model model) {
        model.addAttribute("views", viewService.getAllViews());
        log.debug("GET /admin/views");
        return "admin-view";
    }

    @GetMapping("/admin/views/new")
    public String createView(Model model) {
        ViewRequestDTO viewRequestDTO = new ViewRequestDTO();
        model.addAttribute("view", viewRequestDTO);
        log.debug("GET /admin/views/new ");
        return "admin-view-new";
    }

    @PostMapping("/admin/views")
    public String saveView(@ModelAttribute("view") ViewRequestDTO viewRequestDTO) {
        log.debug("POST /admin/views ");
        viewService.saveView(viewRequestDTO);
        return "redirect:/admin/views";
    }

    @GetMapping("/admin/views/update/{id}")
    public String updateView(@PathVariable Long id, Model model) {
        model.addAttribute("view", viewService.getById(id));
        log.debug("GET /admin/views/update/ " + id);
        return "admin-view-update";
    }

    @PostMapping("/admin/views/{id}")
    public String updateView(@PathVariable Long id,
                             @ModelAttribute("view") ViewRequestDTO viewRequestDTO,
                             Model model) {
        viewService.updateView(id, viewRequestDTO);
        return "redirect:/admin/views";
    }

    //TODO Html is not support method: DELETE
    @PostMapping("/admin/views/del/{id}")
    public String deleteView(@PathVariable Long id, Model model) {
        viewService.deleteView(id);
        return "redirect:/admin/views";
    }
}