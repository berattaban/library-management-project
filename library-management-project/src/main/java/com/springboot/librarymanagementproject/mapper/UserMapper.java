package com.springboot.librarymanagementproject.mapper;

import com.springboot.librarymanagementproject.dto.request.UserCreateRequest;
import com.springboot.librarymanagementproject.dto.response.UserResponse;
import com.springboot.librarymanagementproject.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse mapToResponse(User user);
    User mapToEntity(UserCreateRequest request);
    List<UserResponse> mapToResponseList(List<User> users);
}
