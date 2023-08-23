package com.main.DTO.view;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ViewResponseDTO {
    private Long id;
    private Long authorId;
    private String band;
    private String about;
    private Byte rating;
    private String show;
    private String genre;
    private String location;
    private LocalDate showDate;
}