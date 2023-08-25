package com.view.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter
@Getter
public class UserRequestDTO {
    private String firstname;
    private String lastname;
    private String nickname;
    private String email;
    private String about;
    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDate birthdate;
}
