package com.codegym.repository;

import com.codegym.entity.AppRole;
import com.codegym.entity.AppUser;
import com.codegym.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
