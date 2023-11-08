package com.example.roombooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roombooking.dao.PermissionRepository;
import com.example.roombooking.entity.Permission;
import com.example.roombooking.model.PermissionDTO;
import com.example.roombooking.service.PermissionService;
import com.example.roombooking.util.PermissionConverter;
@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private PermissionConverter permissionConverter;
	
	
	// create permission method
	@Override
	public PermissionDTO createPermission(Permission permission)
	{
		Permission per=permissionRepository.save(permission);
		return permissionConverter.convertToPermissionDTO(per);
	}
	
	
	// Retrieve all permissions
	@Override
	public List<PermissionDTO> getAllPermissions()
	{
		List<Permission> permission=permissionRepository.findAll();
		
		//List of type DTO
		List<PermissionDTO> dtoList=new ArrayList<>();
		for(Permission per: permission)
		{
			dtoList.add(permissionConverter.convertToPermissionDTO(per));
		}
		return dtoList;
	}
	
	
	// Retrieve permission by id
	@Override
	public PermissionDTO getPermissionById(int id)
	{
		Permission per=permissionRepository.findByPermissionId(id);
		return permissionConverter.convertToPermissionDTO(per);
		
	}
	
	
	// Update permission by id
	@Override
	public PermissionDTO updatePermission(int id, Permission permission)
	{
		Permission per=permissionRepository.findByPermissionId(id);
		
		per.setRequestStatus(permission.getRequestStatus());
		
		Permission p=permissionRepository.save(per);
		return permissionConverter.convertToPermissionDTO(p);
		
	}
	
	
	// Delete permission by id
	@Override
	public String deletePermission(int id)
	{
		permissionRepository.deleteById(id);
		return "permission got deleted successfully";
	}
	
	
}
