package com.main.mapper;

import com.main.DTO.view.ViewRequestDTO;
import com.main.DTO.view.ViewResponseDTO;
import com.main.model.View;

public class ViewMapper {
    public static ViewResponseDTO toResponseDTO(View view) {
        ViewResponseDTO sawResponse = new ViewResponseDTO();
        sawResponse.setId(view.getId());
        sawResponse.setBand(view.getBand());
        sawResponse.setGenre(view.getGenre());
        sawResponse.setAbout(view.getAbout());
        sawResponse.setRating(view.getRating());
        sawResponse.setShow(view.getShow());
        sawResponse.setShowDate(view.getShowDate());
        sawResponse.setLocation(view.getLocation());
        sawResponse.setAuthorId(view.getAuthor().getId());
        return sawResponse;
    }

    public static View toSaw(ViewRequestDTO viewRequest) {
        View view = new View();
        view.setAbout(viewRequest.getAbout());
        view.setBand(viewRequest.getBand());
        view.setGenre(viewRequest.getGenre());
        view.setRating(viewRequest.getRating());
        view.setLocation(viewRequest.getLocation());
        view.setShow(viewRequest.getShow());
        view.setShowDate(viewRequest.getShowDate());
        return view;
    }
}