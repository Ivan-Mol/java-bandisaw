package com.view.service;

import com.view.DTO.ViewRequestDTO;

import java.util.List;

public interface ViewService {
    public List<ViewRequestDTO> getAllViews();

    public void saveView(ViewRequestDTO viewRequestDTO);

    public void deleteView(Long id);

    public ViewRequestDTO getById(Long id);

    public ViewRequestDTO updateView(Long id, ViewRequestDTO viewRequestDTO);
}
