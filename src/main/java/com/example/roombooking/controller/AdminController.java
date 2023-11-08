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

import com.example.roombooking.entity.Admin;
import com.example.roombooking.model.AdminDTO;
import com.example.roombooking.service.AdminService;
import com.example.roombooking.util.AdminConverter;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminConverter adminConverter;
	
	
	// Method for creating the admin
	@PostMapping("/create")
	public ResponseEntity <AdminDTO> createAdmin (@Valid @RequestBody AdminDTO adminDto)
	{
		final Admin admin=adminConverter.convertToAdminEntity(adminDto);
		return new ResponseEntity<AdminDTO>(adminService.createAdmin(admin), HttpStatus.CREATED);
		
	}
	
	
	// Method for retrieving all admins
	@GetMapping("/getAll")
	public List<AdminDTO> getAllAdmins()
	{
		return adminService.getAllAdmins();
	}
	
	
	// method for retrieving admin using Id
	@GetMapping("/get/{id}")
	public AdminDTO getAdminById(@PathVariable int id)
	{
		return adminService.getAdminById();
	}
	
	
	// Method for updating the admin
	@PutMapping("/update/{id}")
	public AdminDTO updateAdmin(@Valid @PathVariable int id, @RequestBody AdminDTO adminDto)
	{
		final Admin admin=adminConverter.convertToAdminEntity(adminDto);
		return adminService.updateAdmin(id, admin);
				
	}
	
	
	// Method for deleting the admin using id
	@DeleteMapping("/delete/{id}")
	public String deleteAdmin(@PathVariable int id)
	{
		return adminService.deleteAdmin(id);
	}
}
