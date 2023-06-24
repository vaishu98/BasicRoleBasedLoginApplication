package com.basic.rolebasedlogin.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterResponseDTO {
    private String username;
    private String password;
    private String role;
    private String status;
}
