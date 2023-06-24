package com.basic.rolebasedlogin.app.dto;

import lombok.Data;

@Data
public class AuthResponseDTO {
    private String accessToken;
    private String tokenType = "Bearer ";
    private String role;

    public AuthResponseDTO(String accessToken, String role) {
        this.accessToken = accessToken;
        this.role=role;
    }
}
