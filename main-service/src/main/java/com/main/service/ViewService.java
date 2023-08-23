package com.main.service;

import com.main.DTO.view.ViewRequestDTO;
import com.main.model.View;

public interface ViewService {
    View getViewByUser(Long userId, Long id);

    View createViewByUser(Long userId, ViewRequestDTO viewRequest);

    void deleteViewByAuthor(Long userId, Long viewId);

    View updateViewByAuthor(Long userId, Long viewId, ViewRequestDTO viewRequest);

}