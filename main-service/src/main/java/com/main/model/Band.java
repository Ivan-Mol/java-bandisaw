package com.main.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Band {
    private Long id;
    private String name;
    private String genre;
    private String country;
}
