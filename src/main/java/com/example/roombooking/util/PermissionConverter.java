package com.example.roombooking.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.roombooking.entity.Permission;
import com.example.roombooking.model.PermissionDTO;
@Component
public class PermissionConverter {

	public Permission convertToPermissionEntity(PermissionDTO permissionDto) {
		Permission permission=new Permission();
		if(permissionDto!=null)
		{
			BeanUtils.copyProperties(permissionDto, permission);
		}
		return permission;
	
	}

	public PermissionDTO convertToPermissionDTO(Permission per) 
	{
		PermissionDTO permissionDto=new PermissionDTO();
		if(per!=null)
		{
			BeanUtils.copyProperties(per, permissionDto);
		}
		return permissionDto;
	}

}
