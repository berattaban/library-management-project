package com.springboot.librarymanagementproject.service;

import com.springboot.librarymanagementproject.dto.request.UserCreateRequest;
import com.springboot.librarymanagementproject.dto.response.UserResponse;

import java.util.List;

public interface IUserService {

    UserResponse createUser(UserCreateRequest request);
    List<UserResponse> findAll();
    void deleteById(Long id);
}
