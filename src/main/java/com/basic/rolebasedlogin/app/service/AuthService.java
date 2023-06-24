package com.basic.rolebasedlogin.app.service;

import com.basic.rolebasedlogin.app.dto.AuthResponseDTO;
import com.basic.rolebasedlogin.app.dto.LoginDTO;
import com.basic.rolebasedlogin.app.dto.RegisterDTO;
import com.basic.rolebasedlogin.app.dto.RegisterResponseDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    public ResponseEntity<AuthResponseDTO> login(LoginDTO loginDto);
    public ResponseEntity<RegisterResponseDTO> register(RegisterDTO registerDto);

}
