package com.view.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewRequestDTO {
    private Long id;
    private String band;
    private String about;
    private Integer rating;
    private String show;
    private String genre;
    private String location;
}