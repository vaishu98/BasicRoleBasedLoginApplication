package com.basic.rolebasedlogin.app.repository;

import com.basic.rolebasedlogin.app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
