package com.basic.rolebasedlogin.app.controllers;


import com.basic.rolebasedlogin.app.dto.UsersListDTO;
import com.basic.rolebasedlogin.app.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    public AdminController(AdminServiceImpl adminServiceImpl){
        this.adminServiceImpl=adminServiceImpl;
    }

    @GetMapping("/homepage")
    public ResponseEntity<List<UsersListDTO>> adminHomepage(){
        return this.adminServiceImpl.adminHomepage();
    }
}
