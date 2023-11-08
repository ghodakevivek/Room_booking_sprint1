package com.example.roombooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.roombooking.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByAdminId(int adminId);
}
