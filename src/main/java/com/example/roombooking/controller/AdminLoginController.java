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

import com.example.roombooking.entity.AdminLogin;
import com.example.roombooking.model.AdminLoginDTO;
import com.example.roombooking.service.AdminLoginService;
import com.example.roombooking.util.AdminLoginConverter;

@RestController
@RequestMapping("/api/adminLogin")
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLoginService;
	
	@Autowired
	private AdminLoginConverter adminLoginConverter;
	
	
	// Method for creating the adminLogins
	@PostMapping("/create")
	public ResponseEntity <AdminLoginDTO> createAdminLogin (@Valid @RequestBody AdminLoginDTO adminLoginDto)
	{
		final AdminLogin adminLogin=adminLoginConverter.convertToAdminLoginEntity(adminLoginDto);
		return new ResponseEntity<AdminLoginDTO>(adminLoginService.createAdminLogin(adminLogin), HttpStatus.CREATED);
	}
	
	
	// Method for retrieving all adminLogins
	@GetMapping("/getAll")
	public List<AdminLoginDTO> getAllAdminLogins()
	{
		return adminLoginService.getAllAdminLogins();
	}
	
	
	// method for retrieving adminLogin using Id
	@GetMapping("/get/{id}")
	public AdminLoginDTO getAdminLoginById(@PathVariable int id)
	{
		return adminLoginService.getAdminLoginById();
	}
	
	
	// Method for updating the adminLogin
	@PutMapping("/update/{id}")
	public AdminLoginDTO updateAdminLogin(@Valid @PathVariable int id, @RequestBody AdminLoginDTO adminLoginDto)
	{
		final AdminLogin adminLogin=adminLoginConverter.convertToAdminLoginEntity(adminLoginDto);
		return adminLoginService.updateAdminLogin(id, adminLogin);
				
	}
	
	
	// Method for deleting the adminLogin using id
	@DeleteMapping("/delete/{id}")
	public String deleteAdminLogin(@PathVariable int id)
	{
		return adminLoginService.deleteAdminLogin(id);
	}
}
