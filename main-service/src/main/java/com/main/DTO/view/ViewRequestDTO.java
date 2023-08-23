package com.main.DTO.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViewRequestDTO {
    @NotBlank
    @Size(min = 1, max = 50)
    private String band;
    @Size(min = 1, max = 512)
    private String about;
    @Min(1)
    @Max(5)
    private Byte rating;
    @Size(min = 5, max = 50)
    private String show;
    private String genre;
    private String location;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate showDate;
}