package com.basics.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequestDTO {
    @NotBlank(message = "name is too short or too long")
    @Size(min = 3, max = 30)
    String name;
    @Email(message = "email is not correct")
    String email;
    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDate dateOfBirth;
}
