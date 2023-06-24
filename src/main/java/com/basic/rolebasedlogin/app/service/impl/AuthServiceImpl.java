package com.basic.rolebasedlogin.app.service.impl;

import com.basic.rolebasedlogin.app.dto.AuthResponseDTO;
import com.basic.rolebasedlogin.app.dto.LoginDTO;
import com.basic.rolebasedlogin.app.dto.RegisterDTO;
import com.basic.rolebasedlogin.app.dto.RegisterResponseDTO;
import com.basic.rolebasedlogin.app.models.Role;
import com.basic.rolebasedlogin.app.models.User;
import com.basic.rolebasedlogin.app.repository.RoleRepository;
import com.basic.rolebasedlogin.app.repository.UserRepository;
import com.basic.rolebasedlogin.app.security.JWTGenerator;
import com.basic.rolebasedlogin.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }
    @Override
    public ResponseEntity<AuthResponseDTO> login(LoginDTO loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token,
                authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()).get(0)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RegisterResponseDTO> register(RegisterDTO registerDto) {
        RegisterResponseDTO registerResponseDTO = new RegisterResponseDTO(
                registerDto.getUsername(),
                registerDto.getPassword(),
                registerDto.getRole(),
                "Registration successful"
        );
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            registerResponseDTO.setStatus("Username already takes!");
            return new ResponseEntity<>(registerResponseDTO, HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
        Optional<Role> roles = roleRepository.findByName(registerDto.getRole());
        if(roles.isEmpty()){
            registerResponseDTO.setStatus("Role '"+registerDto.getRole()+"' not found");
            return new ResponseEntity<>(registerResponseDTO, HttpStatus.BAD_REQUEST);
        }
        Role role = roles.get();
        user.setRoles(Collections.singletonList(role));

        userRepository.save(user);

        return new ResponseEntity<>(registerResponseDTO, HttpStatus.OK);
    }
}
