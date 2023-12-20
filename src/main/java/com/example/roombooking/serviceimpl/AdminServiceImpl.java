package com.example.roombooking.serviceimpl;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.roombooking.config.LoginMesage;
import com.example.roombooking.dao.AdminRepository;
import com.example.roombooking.entity.Admin;
import com.example.roombooking.model.ALoginDTO;
import com.example.roombooking.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	
	@Autowired
    private PasswordEncoder passwordEncoder;


	
	
	// Login
	 @Override
	    public LoginMesage  loginAdmin(ALoginDTO loginDTO) {
	        String msg = "";
	        Admin admin1 = adminRepository.findByAdminEmail(loginDTO.getAdminEmail());
	        if (admin1 != null) {
	            String adminPassword = loginDTO.getAdminPassword();
	            String encodedPassword = admin1.getAdminPassword();
//	            Boolean isPwdRight = passwordEncoder.matches(adminPassword, encodedPassword);
	            Boolean isPwdRight = adminPassword.equals(encodedPassword);
	            System.out.println(isPwdRight);
	            if (isPwdRight) 
	            {
	                Optional<Admin> admin = adminRepository.findByAdminEmailAndAdminPassword
	                		(loginDTO.getAdminEmail(), encodedPassword);
//	                System.out.println(adminPassword);
//	                System.out.println(encodedPassword);
//	                System.out.println(admin1.getAdminEmail());
	                
	                if (admin.isPresent()) {
	                    return new LoginMesage("Login Success", true);
	                } 
	                else 
	                {
	                    return new LoginMesage("Login Failed", false);
	                }
	            }
	            else 
	            {
	            	 System.out.println(adminPassword);
		                System.out.println(encodedPassword);
		                System.out.println(admin1.getAdminEmail());
	                return new LoginMesage("password Not Match", false);
	            }
	        }
	        else
	        {
	            return new LoginMesage("Email not exits", false);
	        }
	    }



	
}
