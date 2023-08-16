package com.basics.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDTO {
    String id;
    String name;
    String email;
    LocalDate dateOfBirth;
}
