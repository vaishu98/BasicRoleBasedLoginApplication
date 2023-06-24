package com.basic.rolebasedlogin.app.service;

import com.basic.rolebasedlogin.app.dto.UsersListDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface AdminService {
    public ResponseEntity<List<UsersListDTO>> adminHomepage();

}
