package com.main.mapper;

import com.main.DTO.user.UserRequestDTO;
import com.main.DTO.user.UserResponseDTO;
import com.main.model.User;
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
        responseDTO.setBirthdate(user.getBirthdate());
        responseDTO.setAbout(user.getAbout());
        return responseDTO;
    }

    public static User requestToUser(UserRequestDTO requestDTO) {
        User user = new User();
        user.setFirstname(requestDTO.getFirstname());
        user.setLastname(requestDTO.getLastname());
        user.setNickname(requestDTO.getNickname());
        user.setEmail(requestDTO.getEmail());
        user.setBirthdate(requestDTO.getBirthdate());
        user.setAbout(requestDTO.getAbout());
        return user;
    }
}
