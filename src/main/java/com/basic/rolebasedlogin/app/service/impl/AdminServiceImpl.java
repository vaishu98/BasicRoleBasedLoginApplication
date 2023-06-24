package com.basic.rolebasedlogin.app.service.impl;

import com.basic.rolebasedlogin.app.dto.UsersListDTO;
import com.basic.rolebasedlogin.app.models.User;
import com.basic.rolebasedlogin.app.repository.UserRepository;
import com.basic.rolebasedlogin.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<List<UsersListDTO>> adminHomepage() {
        List<User> users = userRepository.findAll();
        List<UsersListDTO> re = new ArrayList<>();
        for (User user : users) {
            UsersListDTO u = new UsersListDTO(
                    user.getUsername(),
                    user.getRoles().get(0).getName()
            );
            re.add(u);
        }
        System.out.println(users);
        System.out.println(re);
        return new ResponseEntity<>(re, HttpStatus.OK);
    }
}
