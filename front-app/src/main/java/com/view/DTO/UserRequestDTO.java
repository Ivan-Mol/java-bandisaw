package com.view.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequestDTO {
    private String firstname;
    private String lastname;
    String nickname;
    String email;
    String about;
    @JsonFormat(pattern = "yyyy.MM.dd")
    LocalDate birthdate;

}
