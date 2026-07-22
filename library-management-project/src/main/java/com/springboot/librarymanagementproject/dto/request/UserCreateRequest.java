package com.springboot.librarymanagementproject.dto.request;

import com.springboot.librarymanagementproject.entity.Address;
import com.springboot.librarymanagementproject.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserCreateRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private List<Address> address;
}
