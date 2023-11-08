package com.example.roombooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.roombooking.entity.Permission;
import com.example.roombooking.model.PermissionDTO;
import com.example.roombooking.service.PermissionService;
import com.example.roombooking.util.PermissionConverter;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private PermissionConverter permissionConverter;
	
	
	// Method for creating the permission
	@PostMapping("/create")
	public ResponseEntity<PermissionDTO> createPermission (@Valid @RequestBody PermissionDTO permissionDto)
	{
		final Permission permission=permissionConverter.convertToPermissionEntity(permissionDto);
		return new ResponseEntity<PermissionDTO>(permissionService.createPermission(permission), HttpStatus.CREATED);
	}
	
	
	// Method for retrieving all permissions
	@GetMapping("/getAll")
	public List<PermissionDTO> getAllPermissions()
	{
		return permissionService.getAllPermissions();
	}
	
	
	// method for retrieving permission using Id
	@GetMapping("/get/{id}")
	public PermissionDTO getPermissionById (@PathVariable int id)
	{
		return permissionService.getPermissionById(id);
	}
	
	
	// Method for updating the permission
	@PutMapping("/update/{id}")
	public PermissionDTO updatePermission(@Valid @PathVariable int id, @RequestBody PermissionDTO permissionDto)
	{
		final Permission permission=permissionConverter.convertToPermissionEntity(permissionDto);
		return permissionService.updatePermission(id, permission);
	}
	
	
	// Method for deleting the permission using id
	@DeleteMapping("delete/{id}")
	public String deletePermission(@PathVariable int id)
	{
		return permissionService.deletePermission(id);
	}

}
