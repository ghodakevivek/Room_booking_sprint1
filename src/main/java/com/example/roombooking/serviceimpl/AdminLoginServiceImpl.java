package com.example.roombooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roombooking.dao.AdminLoginRepository;
import com.example.roombooking.entity.AdminLogin;
import com.example.roombooking.model.AdminLoginDTO;
import com.example.roombooking.service.AdminLoginService;
import com.example.roombooking.util.AdminLoginConverter;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	@Autowired
	private AdminLoginRepository adminLoginRepository;
	
	@Autowired
	private AdminLoginConverter adminLoginConverter;
	
	
	// create adminLogin method
	@Override
	public AdminLoginDTO createAdminLogin(AdminLogin adminLogin) 
	{
		AdminLogin aLogin=adminLoginRepository.save(adminLogin);
		return adminLoginConverter.convertToAdminLoginDTO(aLogin);
	}
	
	
	// Retrieve all adminLogins
	@Override
	public List<AdminLoginDTO> getAllAdminLogins(){
		List<AdminLogin> adminLogin=adminLoginRepository.findAll();
		
		//list of type DTO
		List<AdminLoginDTO> dtoList=new ArrayList<>();
		for(AdminLogin al: adminLogin)
		{
			dtoList.add(adminLoginConverter.convertToAdminLoginDTO(al));
		}
		return dtoList;
	}
	
	
	// Retrieve adminLogin by id
	@Override
	public AdminLoginDTO getAdminLoginById(int id) {
		AdminLogin al=adminLoginRepository.findByAdminLoginId(id);
		return adminLoginConverter.convertToAdminLoginDTO(al);
	}
	
	
	// Update adminLogin by id
	@Override
	public AdminLoginDTO updateAdminLogin(int id, AdminLogin adminLogin) {
		AdminLogin al=adminLoginRepository.findByAdminLoginId(id);
		
		al.setAdminUserName(adminLogin.getAdminUserName());
		al.setAdminPassword(adminLogin.getAdminPassword());
		
		AdminLogin aLogin=adminLoginRepository.save(al);
		return adminLoginConverter.convertToAdminLoginDTO(aLogin);
	}
	
	
	// Delete adminLogin by id
	@Override
	public String deleteAdminLogin(int id) {
		adminLoginRepository.deleteById(id);
		return "AdminLogin got deleted successFully";
	}


	@Override
	public AdminLoginDTO getAdminLoginById() {
		// TODO Auto-generated method stub
		return null;
	}
}

