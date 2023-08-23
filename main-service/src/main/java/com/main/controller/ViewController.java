package com.main.controller;

import com.main.DTO.view.ViewRequestDTO;
import com.main.DTO.view.ViewResponseDTO;
import com.main.mapper.ViewMapper;
import com.main.service.ViewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/saws")
@Slf4j
public class ViewController {
    private final ViewService viewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViewResponseDTO createView(@RequestParam(name = "userId") Long userId,
                                     @RequestBody @Valid ViewRequestDTO viewRequest) {
        log.debug("POST /saws/ BODY: " + viewRequest.toString() + " by user with id: " + userId);
        return ViewMapper.toResponseDTO(viewService.createViewByUser(userId, viewRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ViewResponseDTO getViewByUser(@RequestParam(name = "userId") Long userId,
                                       @PathVariable(name = "id") Long id) {
        log.debug("GET /saws/ by id: " + id);
        return ViewMapper.toResponseDTO(viewService.getViewByUser(userId, id));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ViewResponseDTO updateViewByAuthor(@RequestParam(name = "userId") Long userId,
                                            @PathVariable(name = "id") Long viewId,
                                            @RequestBody ViewRequestDTO viewRequest) {
        log.debug("PATCH /saws/ with id " + viewId + " BODY: " + viewRequest.toString() + " by user with id: " + userId);
        return ViewMapper.toResponseDTO(viewService.updateViewByAuthor(userId, viewId, viewRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSawByAuthor(@RequestParam(name = "userId") Long userId,
                                  @PathVariable(value = "id") Long viewId) {
        log.debug("DELETE /saws/id=" + viewId + " by user Id" + userId);
        viewService.deleteViewByAuthor(userId, viewId);
    }
}