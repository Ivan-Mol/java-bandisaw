package com.basics.mapper;

import com.basics.DTO.UserRequestDTO;
import com.basics.DTO.UserResponseDTO;
import com.basics.model.User;
import com.basics.utils.HashingTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public static UserResponseDTO toResponseDto(User user) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(HashingTool.encode(user.getId()));
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setDateOfBirth(user.getDateOfBirth());
        return responseDTO;
    }

    public static User requestToUser(UserRequestDTO requestDTO) {
        User user = new User();
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        user.setDateOfBirth(requestDTO.getDateOfBirth());
        return user;
    }
}
