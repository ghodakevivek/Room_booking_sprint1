package com.example.roombooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.roombooking.entity.AdminLogin;
@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, Integer>{

	AdminLogin findByAdminLoginId(int adminLoginId);
}
