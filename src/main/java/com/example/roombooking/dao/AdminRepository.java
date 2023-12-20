package com.example.roombooking.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.roombooking.entity.Admin;
import com.example.roombooking.entity.User;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByAdminId(int adminId);
	Admin findByAdminEmail(String adminEmail);
	Optional<Admin> findByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);
}
