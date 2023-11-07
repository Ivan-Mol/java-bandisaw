package com.main.DTO.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequestDTO {
    @NotBlank(message = "Name is too short or too long")
    @Size(min = 2, max = 70)
    private String name;
    @NotBlank(message = "Nickname is too short or too long")
    @Size(min = 3, max = 40)
    String nickname;
    @Email(message = "email is not correct")
    String email;
    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDate birthdate;
    @Size(max = 512)
    String about;
}
