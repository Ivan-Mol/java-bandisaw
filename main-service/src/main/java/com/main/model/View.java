package com.main.model;

import com.main.DTO.view.ViewRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "Saws")
public class View {
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    User author;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String band;
    private String about;
    private Byte rating;
    private String show;
    private String genre;
    private String location;
    @Column(name = "show_date")
    private LocalDate showDate;

    public void update(ViewRequestDTO viewRequest) {
        this.band = viewRequest.getBand();
        this.about = viewRequest.getAbout();
        this.rating = viewRequest.getRating();
        this.show = viewRequest.getShow();
        this.genre = viewRequest.getGenre();
        this.location = viewRequest.getLocation();
        this.showDate = viewRequest.getShowDate();
    }
}