package com.main.service.impl;

import com.main.DTO.user.UserResponseDTO;
import com.main.repository.UserRepository;
import com.main.DTO.user.UserRequestDTO;
import com.main.mapper.UserMapper;
import com.main.model.User;
import com.main.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<UserResponseDTO> getAll() {
        return userRepository.
                findAll(Pageable.ofSize(20))
                .stream()
                .map(UserMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
