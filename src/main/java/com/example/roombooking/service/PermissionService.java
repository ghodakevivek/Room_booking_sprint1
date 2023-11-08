package com.example.roombooking.service;

import java.util.List;

import com.example.roombooking.entity.Permission;
import com.example.roombooking.model.PermissionDTO;

public interface PermissionService {

	public PermissionDTO createPermission(Permission permission);
	public List<PermissionDTO> getAllPermissions();
	public PermissionDTO getPermissionById(int id);
	public PermissionDTO updatePermission(int id, Permission permission);
	public String deletePermission(int id);

}
