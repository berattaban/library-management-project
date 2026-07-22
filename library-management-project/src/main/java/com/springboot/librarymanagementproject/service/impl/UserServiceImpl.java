package com.springboot.librarymanagementproject.service.impl;

import com.springboot.librarymanagementproject.dto.request.UserCreateRequest;
import com.springboot.librarymanagementproject.dto.response.UserResponse;
import com.springboot.librarymanagementproject.entity.User;
import com.springboot.librarymanagementproject.mapper.UserMapper;
import com.springboot.librarymanagementproject.repository.UserRepository;
import com.springboot.librarymanagementproject.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserCreateRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .role(request.getRole())
                .address(request.getAddress())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .phoneNumber(savedUser.getPhoneNumber())
                .role(savedUser.getRole())
                .address(savedUser.getAddress())
                .build();
    }

    @Override
    public List<UserResponse> findAll() {
        return userMapper.mapToResponseList(userRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
