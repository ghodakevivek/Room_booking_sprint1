package com.example.roombooking.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.roombooking.entity.Admin;
import com.example.roombooking.model.AdminDTO;
@Component
public class AdminConverter {

	public Admin convertToAdminEntity(AdminDTO adminDto)
	{
		Admin admin=new Admin();
		if(adminDto!=null)
		{
			BeanUtils.copyProperties(adminDto, admin);
		}
		return admin;
	}
	
	
	
	public AdminDTO convertToAdminDTO(Admin admin) {
		AdminDTO adminDto=new AdminDTO();
		if(admin!=null)
		{
			BeanUtils.copyProperties(admin, adminDto);
		}
		return adminDto;
	}
}
