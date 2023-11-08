package com.example.roombooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roombooking.dao.AdminRepository;
import com.example.roombooking.entity.Admin;
import com.example.roombooking.model.AdminDTO;
import com.example.roombooking.service.AdminService;
import com.example.roombooking.util.AdminConverter;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AdminConverter adminConverter;
	
	
	// create admin method
	@Override
	public AdminDTO createAdmin(Admin admin)
	{
		Admin ad=adminRepository.save(admin);
		return adminConverter.convertToAdminDTO(ad);
	}
	
	
	// Retrieve all admin
	@Override
	public List<AdminDTO> getAllAdmins(){
		List<Admin> admin=adminRepository.findAll();
		
		//list of type DTO
		List<AdminDTO> dtoList=new ArrayList<>();
		for(Admin a: admin)
		{
			dtoList.add(adminConverter.convertToAdminDTO(a));
		}
		return dtoList;
	}
	
	
	// Retrieve admin by id
	@Override
	public AdminDTO getAdminById(int id) {
		Admin a=adminRepository.findByAdminId(id);
		return adminConverter.convertToAdminDTO(a);
	}
	
	
	// Update adminLogin by id
	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		Admin a=adminRepository.findByAdminId(id);
		
		a.setAdminEmail(admin.getAdminEmail());
		a.setAdminUserName(admin.getAdminUserName());
		a.setAdminPassword(admin.getAdminPassword());
		
		
		Admin ad=adminRepository.save(a);
		return adminConverter.convertToAdminDTO(ad);
	}
	
	
	// Delete adminLogin by id
	@Override
	public String deleteAdmin(int id) {
		adminRepository.deleteById(id);
		return "Admin got deleted successFully";
	}


	@Override
	public AdminDTO getAdminById() {
		// TODO Auto-generated method stub
		return null;
	}

}
