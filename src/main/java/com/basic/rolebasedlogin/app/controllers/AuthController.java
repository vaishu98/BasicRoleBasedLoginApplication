package com.basic.rolebasedlogin.app.controllers;

import com.basic.rolebasedlogin.app.dto.AuthResponseDTO;
import com.basic.rolebasedlogin.app.dto.LoginDTO;
import com.basic.rolebasedlogin.app.dto.RegisterDTO;
import com.basic.rolebasedlogin.app.dto.RegisterResponseDTO;
import com.basic.rolebasedlogin.app.models.Role;
import com.basic.rolebasedlogin.app.models.User;
import com.basic.rolebasedlogin.app.repository.RoleRepository;
import com.basic.rolebasedlogin.app.repository.UserRepository;
import com.basic.rolebasedlogin.app.security.JWTGenerator;
import com.basic.rolebasedlogin.app.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    AuthServiceImpl authServiceImpl;

    public AuthController(AuthServiceImpl authServiceImpl){
        this.authServiceImpl=authServiceImpl;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDto){
        return authServiceImpl.login(loginDto);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterDTO registerDto) {
        return authServiceImpl.register(registerDto);
    }
}
