package com.basics.mapper;

import com.basics.DTO.UserRequestDTO;
import com.basics.DTO.UserResponseDTO;
import com.basics.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public static UserResponseDTO toResponseDto(User user) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setFirstname(user.getFirstname());
        responseDTO.setLastname(user.getLastname());
        responseDTO.setNickname(user.getNickname());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setDateOfBirth(user.getDateOfBirth());
        responseDTO.setSummary(user.getSummary());
        return responseDTO;
    }

    public static User requestToUser(UserRequestDTO requestDTO) {
        User user = new User();
        user.setFirstname(requestDTO.getFirstname());
        user.setLastname(requestDTO.getLastname());
        user.setNickname(requestDTO.getNickname());
        user.setEmail(requestDTO.getEmail());
        user.setDateOfBirth(requestDTO.getDateOfBirth());
        user.setSummary(requestDTO.getSummary());
        return user;
    }
}
