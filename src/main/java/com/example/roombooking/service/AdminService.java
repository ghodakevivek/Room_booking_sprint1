package com.example.roombooking.service;

import java.util.List;

import com.example.roombooking.entity.Admin;
import com.example.roombooking.model.AdminDTO;

public interface AdminService {

	public AdminDTO createAdmin(Admin admin);
	public List<AdminDTO> getAllAdmins();
	public AdminDTO getAdminById(int id);
	public AdminDTO updateAdmin(int id, Admin admin);
	public String deleteAdmin(int id);
	public AdminDTO getAdminById();
}
