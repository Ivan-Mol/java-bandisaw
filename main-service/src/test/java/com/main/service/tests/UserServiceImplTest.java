package com.main.service.tests;

import com.main.DTO.user.UserRequestDTO;
import com.main.exception.ValidationException;
import com.main.model.User;
import com.main.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImplTest {
    private final UserServiceImpl userService;
    private UserRequestDTO correctRequestDto;

    @BeforeEach
    public void beforeEach() {
        correctRequestDto = new UserRequestDTO();
        correctRequestDto.setNickname("testName");
        correctRequestDto.setEmail("test@test.mail.com");
        correctRequestDto.setBirthdate(LocalDate.now().minusYears(22));
    }

    @Test
    public void create() {
        User createdUser = userService.createUser(correctRequestDto);
        Assertions.assertNotNull(createdUser.getId());
        userService.deleteUser(createdUser.getId());
    }

    @Test
    public void createWithIncorrectMail() {
        User createdUser = userService.createUser(correctRequestDto);
        Assertions.assertThrows(ValidationException.class, () -> {
            userService.createUser(correctRequestDto);
        });
        userService.deleteUser(createdUser.getId());
    }
}