package com.view.controller;

import com.view.DTO.ViewRequestDTO;
import com.view.service.ViewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ViewController {
    private final ViewService viewService;

    @GetMapping("/views")
    public String getViews(Model model) {
        model.addAttribute("views", viewService.getAllViews());
        return "views";
    }

    @GetMapping("/views/new")
    public String createView(Model model) {
        ViewRequestDTO viewRequestDTO = new ViewRequestDTO();
        model.addAttribute("view", viewRequestDTO);
        return "create_view";

    }

    @PostMapping("/views")
    public String saveView(@ModelAttribute("view") ViewRequestDTO viewRequestDTO) {
        viewService.saveView(viewRequestDTO);
        return "redirect:/views";
    }

    @GetMapping("/views/edit/{id}")
    public String editView(@PathVariable Long id, Model model) {
        model.addAttribute("view", viewService.getById(id));
        return "edit_view";
    }

    @PostMapping("/views/{id}")
    public String updateView(@PathVariable Long id,
                             @ModelAttribute("view") ViewRequestDTO viewRequestDTO,
                             Model model) {

        viewService.updateView(id, viewRequestDTO);
        return "redirect:/views";
    }

    @DeleteMapping("/views/{id}")
    public String deleteView(@PathVariable Long id) {
        viewService.deleteView(id);
        return "redirect:/views";
    }
}