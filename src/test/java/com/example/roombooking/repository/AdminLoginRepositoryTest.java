package com.example.roombooking.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.roombooking.dao.AdminLoginRepository;
import com.example.roombooking.entity.AdminLogin;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminLoginRepositoryTest {

	
	 @Autowired
	    private AdminLoginRepository adminLoginRepository;

	    @Test
	    public void testCreateAdminLogin() {
	    	 // Create and save an adminLogin
	        AdminLogin adminLogin = new AdminLogin();
	        adminLogin.setAdminUserName("adminLogin1");
	        adminLogin.setAdminPassword("password1");
	       
	        AdminLogin savedAdminLogin = adminLoginRepository.save(adminLogin);
	        assertNotNull(savedAdminLogin.getAdminLoginId());
	    }
	    
	    
	    
	    
	    @Test
	    public void testGetAllAdminLogins() {
	    	
	    	 // Clear the database to ensure a clean state
	        adminLoginRepository.deleteAll();
	    	
	        // Create and save multiple adminLogin entities
	        AdminLogin adminLogin1 = new AdminLogin(1,"adminLogin1", "password1");
	        AdminLogin adminLogin2 = new AdminLogin(2,"adminLogin1", "password1");
	        AdminLogin adminLogin3 = new AdminLogin(3,"adminLogin1", "password1");

	        adminLoginRepository.save(adminLogin1);
	        adminLoginRepository.save(adminLogin2);
	        adminLoginRepository.save(adminLogin3);

	        // Retrieve all adminLogins from the database
	        List<AdminLogin> allAdminLogins = adminLoginRepository.findAll();

	        // Assert that the list is not empty and contains the expected number of adminLogins
	        assertNotNull(allAdminLogins);
	        assertEquals(3, allAdminLogins.size());
	    }
	    
	    
	    
	    
	    
	    @Test
	    public void testGetAdminLoginById() {
	        // Create and save an adminLogin
	        AdminLogin adminLogin = new AdminLogin();
	        adminLogin.setAdminUserName("adminLogin1");
	        adminLogin.setAdminPassword("password1");

	        adminLogin = adminLoginRepository.save(adminLogin);

	        // Retrieve the adminLogin by ID
	        AdminLogin retrievedAdminLogin = adminLoginRepository.findById(adminLogin.getAdminLoginId()).orElse(null);

	        // Assert that the retrieved adminLogin is not null and has the correct ID
	        assertNotNull(retrievedAdminLogin);
	        assertEquals(adminLogin.getAdminLoginId(), retrievedAdminLogin.getAdminLoginId());
	        assertEquals("adminLogin1", retrievedAdminLogin.getAdminUserName());
	        assertEquals("password1", retrievedAdminLogin.getAdminPassword());
	      
	    }
	
	    
	    
	    @Test
	    public void testUpdateAdminLoginById() {
	        // Create and save an adminLogin
	        AdminLogin adminLogin = new AdminLogin();
	        adminLogin.setAdminUserName("adminLogin1");
	        adminLogin.setAdminPassword("password1");

	        adminLogin = adminLoginRepository.save(adminLogin);

	        // Update the adminLogin's details
	        int adminLoginId = adminLogin.getAdminLoginId();
	        AdminLogin updatedAdminLogin = adminLoginRepository.findById(adminLoginId).orElse(null);
	        assertNotNull(updatedAdminLogin);

	        // Modify the adminLogin's attributes
	        updatedAdminLogin.setAdminUserName("newAdminLogin1"); 
	        updatedAdminLogin.setAdminPassword("newPassword1"); 
	      
	        // Save the updated adminLogin
	        updatedAdminLogin = adminLoginRepository.save(updatedAdminLogin);

	        // Retrieve the updated adminLogin from the database
	        AdminLogin retrievedAdminLogin = adminLoginRepository.findById(adminLoginId).orElse(null);
	        assertNotNull(retrievedAdminLogin);

	        // Assert that the attributes have been updated
	        assertEquals("newAdminLogin1", retrievedAdminLogin.getAdminUserName());
	        assertEquals("newPassword1", retrievedAdminLogin.getAdminPassword());
	       
	    }


	    
	    
	    @Test
	    public void testDeleteAdminLoginById() {
	        // Create and save an adminLogin
	        AdminLogin adminLogin = new AdminLogin();
	        adminLogin.setAdminUserName("adminLogin1");
	        adminLogin.setAdminPassword("password1");

	        adminLogin = adminLoginRepository.save(adminLogin);

	        // Get the ID of the adminLogin to be deleted
	        int adminLoginId = adminLogin.getAdminLoginId();

	        // Delete the adminLogin by ID
	        adminLoginRepository.deleteById(adminLoginId);

	        // Try to retrieve the deleted adminLogin by ID, and it should be null
	        AdminLogin deletedAdminLogin = adminLoginRepository.findById(adminLoginId).orElse(null);
	        assertNull(deletedAdminLogin);
	    }

	
	
}
