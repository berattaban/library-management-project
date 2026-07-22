package com.springboot.librarymanagementproject.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.springboot.librarymanagementproject.entity.Address;
import com.springboot.librarymanagementproject.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonPropertyOrder({"id","firstName","lastName","username","email","password","phoneNumber","role","address"})
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private List<Address> address;
}
