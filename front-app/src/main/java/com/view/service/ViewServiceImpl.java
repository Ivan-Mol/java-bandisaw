package com.view.service;

import com.view.DTO.ViewRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {
    private final List<ViewRequestDTO> viewRequests = new ArrayList<>();
    private Long ID = 0L;

    {
        viewRequests.add(new ViewRequestDTO(
                ++ID,
                "Slayer",
                "Great show!",
                5,
                "BrutalAssault",
                "Trash metal",
                "Poland"));
        viewRequests.add(new ViewRequestDTO(
                ++ID,
                "Marduk",
                "Amazing show!",
                5,
                "BrutalAssault",
                "Black metal",
                "Poland"));
    }

    public List<ViewRequestDTO> getAllViews() {
        return viewRequests;
    }

    public void saveView(ViewRequestDTO viewRequestDTO) {
        viewRequestDTO.setId(++ID);
        viewRequests.add(viewRequestDTO);
    }

    public void deleteView(Long id) {
        ViewRequestDTO v = getById(id);
        viewRequests.remove(v);
    }

    public ViewRequestDTO getById(Long id) {
        for (ViewRequestDTO v : viewRequests) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public ViewRequestDTO updateView(Long id, ViewRequestDTO view) {

        ViewRequestDTO viewRequestDTO = getById(id);
        viewRequestDTO.setId(id);
        viewRequestDTO.setBand(view.getBand());
        viewRequestDTO.setAbout(view.getAbout());
        viewRequestDTO.setRating(view.getRating());
        viewRequestDTO.setShow(view.getShow());
        viewRequestDTO.setGenre(view.getGenre());
        viewRequestDTO.setLocation(view.getLocation());
        deleteView(id);
        viewRequests.add(viewRequestDTO);
        return view;
    }
}
