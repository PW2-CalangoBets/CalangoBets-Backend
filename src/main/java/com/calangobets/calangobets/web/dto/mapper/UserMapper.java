package com.calangobets.calangobets.web.dto.mapper;

import com.calangobets.calangobets.entity.User;
import com.calangobets.calangobets.web.dto.UserCreateDto;
import com.calangobets.calangobets.web.dto.UserResponseDto;
import com.calangobets.calangobets.web.dto.user.RegisterDto;
import org.modelmapper.ModelMapper;

public class UserMapper {
    public static User toUser(RegisterDto userDto){
        return new ModelMapper().map(userDto, User.class);
    }

    public static UserResponseDto toDto(User user){
        return new ModelMapper().map(user, UserResponseDto.class);
    }
}
