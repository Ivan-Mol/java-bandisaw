package com.main.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String nickname;
    private String email;
    private LocalDate dateOfBirth;
    private String summary;
}
