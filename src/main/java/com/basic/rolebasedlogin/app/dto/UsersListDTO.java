package com.basic.rolebasedlogin.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UsersListDTO {
    private String username;
    private String role;
}
