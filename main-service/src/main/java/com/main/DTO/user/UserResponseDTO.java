package com.main.DTO.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String nickname;
    private String email;
    private LocalDate birthdate;
    private String about;
}
