package com.view.DTO;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
public class UserResponseDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String nickname;
    private String email;
    private String about;
    private LocalDate birthdate;

    public Long getId() {
        return id;
    }
}
