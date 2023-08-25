package com.main.service.impl;

import com.main.repository.UserRepository;
import com.main.DTO.view.ViewRequestDTO;
import com.main.exception.ValidationException;
import com.main.mapper.ViewMapper;
import com.main.model.User;
import com.main.model.View;
import com.main.repository.ViewRepository;
import com.main.service.ViewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ViewServiceImpl implements ViewService {
    private final ViewRepository viewRepository;
    private final UserRepository userRepository;

    @Override
    public View createViewByUser(Long userId, ViewRequestDTO viewRequestDTO) {
        User user = userRepository.getByIdAndCheck(userId);
        View view = ViewMapper.toSaw(viewRequestDTO);
        view.setAuthor(user);
        return viewRepository.save(view);
    }

    @Override
    public View getViewByUser(Long userId, Long id) {
        userRepository.getByIdAndCheck(userId);
        return viewRepository.getByIdAndCheck(id);
    }

    @Override
    public View updateViewByAuthor(Long userId, Long sawId, ViewRequestDTO viewRequestDTO) {
        View view = viewRepository.findByIdAndAuthorId(sawId, userId);
        if (view != null) {
            view.update(viewRequestDTO);
            return viewRepository.save(view);
        } else {
            throw new ValidationException("Can not find saw with this id: " + sawId + " and user id: " + userId);
        }
    }

    @Override
    public void deleteViewByAuthor(Long userId, Long sawId) {
        User user = userRepository.getByIdAndCheck(userId);
        View view = viewRepository.getByIdAndCheck(sawId);
        if (user.getId().equals(view.getAuthor().getId())) {
            viewRepository.deleteById(sawId);
        } else {
            throw new ValidationException("User is not View's owner");
        }
    }
}