package com.example.roombooking.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.roombooking.entity.AdminLogin;
import com.example.roombooking.model.AdminLoginDTO;
@Component
public class AdminLoginConverter {
	
	//Convert from DTO to entity
	
	public AdminLogin convertToAdminLoginEntity(AdminLoginDTO adminLoginDto)
	{
		AdminLogin adminLogin=new AdminLogin();
		if(adminLoginDto!=null)
		{
			BeanUtils.copyProperties(adminLoginDto, adminLogin);
		}
		return adminLogin;
	}
	
	
	// Convert Entity to DTO
//	public AdminLoginDTO convertTOAdminLoginDTO(AdminLogin adminLogin)
//	{
//		AdminLoginDTO adminLoginDto=new AdminLoginDTO();
//		if(adminLogin!=null)
//		{
//			BeanUtils.copyProperties(adminLogin, adminLoginDto);
//		}
//		return adminLoginDto;
//	}


	public AdminLoginDTO convertToAdminLoginDTO(AdminLogin aLogin) {
		AdminLoginDTO adminLoginDto=new AdminLoginDTO();
		if(aLogin!=null)
		{
			BeanUtils.copyProperties(aLogin, adminLoginDto);
		}
		return adminLoginDto;
	}
}
