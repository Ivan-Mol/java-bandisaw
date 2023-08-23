package com.main.controller;

import com.main.DTO.user.UserRequestDTO;
import com.main.DTO.user.UserResponseDTO;
import com.main.mapper.UserMapper;
import com.main.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO requestDTO) {
        log.debug("POST /users/ BODY: " + requestDTO.toString());
        return UserMapper.toResponseDto(userService.createUser(requestDTO));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO getUserById(@PathVariable(value = "id") Long id) {
        log.debug("GET /users/id=" + id);

        return UserMapper.toResponseDto(userService.getUser(id));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO updateUser(@PathVariable(value = "id") Long id,
                                      @RequestBody UserRequestDTO requestDTO) {
        log.debug("PATCH /user/id=" + id);
        return UserMapper.toResponseDto(userService.updateUser(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(value = "id") Long id) {
        log.debug("DELETE /user/id=" + id);
        userService.deleteUser(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDTO> getAllUsers(){
        log.debug("GET /user/");
        return userService.getAll();
    }

}
