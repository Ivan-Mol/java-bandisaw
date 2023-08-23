package com.main.service.impl;

import com.main.repository.UserRepository;
import com.main.DTO.user.UserRequestDTO;
import com.main.mapper.UserMapper;
import com.main.model.User;
import com.main.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(UserRequestDTO requestDTO) {
        log.info("UserService.createUser, requestDTO: " + requestDTO);
        return userRepository.saveUnique(UserMapper.requestToUser(requestDTO));
    }

    @Override
    public User getUser(Long id) {
        log.info("UserService.getUser " + id);
        return userRepository.getByIdAndCheck(id);
    }

    @Override
    public User updateUser(Long userId, UserRequestDTO requestDTO) {
        log.info("UserService.update " + userId + "Request Body: " + requestDTO);
        User user = userRepository.getByIdAndCheck(userId);
        Optional.ofNullable(requestDTO.getNickname()).ifPresent(user::setNickname);
        Optional.ofNullable(requestDTO.getDateOfBirth()).ifPresent(user::setDateOfBirth);
        Optional.ofNullable(requestDTO.getEmail()).ifPresent(user::setEmail);
        return userRepository.saveUnique(user);
    }

    @Override
    public void deleteUser(Long id) {
        log.info("UserService.deleteUser " + id);
        userRepository.deleteById(id);
    }
}
