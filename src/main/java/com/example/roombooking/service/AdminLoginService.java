package com.example.roombooking.service;

import java.util.List;

import com.example.roombooking.entity.AdminLogin;
import com.example.roombooking.model.AdminLoginDTO;

public interface AdminLoginService {

	public AdminLoginDTO createAdminLogin(AdminLogin adminLogin);
	public List<AdminLoginDTO> getAllAdminLogins();
	public AdminLoginDTO getAdminLoginById(int id);
	public AdminLoginDTO updateAdminLogin(int id, AdminLogin adminLogin);
	public String deleteAdminLogin(int id);
	public AdminLoginDTO getAdminLoginById();
	

}
