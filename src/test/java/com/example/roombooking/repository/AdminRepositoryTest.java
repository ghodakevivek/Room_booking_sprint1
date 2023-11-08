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

import com.example.roombooking.dao.AdminRepository;
import com.example.roombooking.entity.Admin;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRepositoryTest {

	
	 @Autowired
	    private AdminRepository adminRepository;

	    @Test
	    public void testCreateAdmin() {
	    	 // Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdminUserName("admin1");
	        admin.setAdminPassword("password1");
	        admin.setAdminEmail("admin1@example.com");

	        Admin savedAdmin = adminRepository.save(admin);
	        assertNotNull(savedAdmin.getAdminId());
	    }
	    
	    
	    
	    
	    @Test
	    public void testGetAllAdmins() {
	    	
	    	 // Clear the database to ensure a clean state
	        adminRepository.deleteAll();
	    	
	        // Create and save multiple admin entities
	        Admin admin1 = new Admin(1,"admin1", "password1", "admin1@example.com");
	        Admin admin2 = new Admin(2,"admin2", "password2", "admin2@example.com");
	        Admin admin3 = new Admin(3,"admin3", "password3", "admin3@example.com");

	        adminRepository.save(admin1);
	        adminRepository.save(admin2);
	        adminRepository.save(admin3);

	        // Retrieve all admins from the database
	        List<Admin> allAdmins = adminRepository.findAll();

	        // Assert that the list is not empty and contains the expected number of admins
	        assertNotNull(allAdmins);
	        assertEquals(3, allAdmins.size());
	    }
	    
	    
	    
	    
	    
	    @Test
	    public void testGetAdminById() {
	        // Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdminUserName("admin3");
	        admin.setAdminPassword("password3");
	        admin.setAdminEmail("admin5@example.com");

	        admin = adminRepository.save(admin);

	        // Retrieve the admin by ID
	        Admin retrievedAdmin = adminRepository.findById(admin.getAdminId()).orElse(null);

	        // Assert that the retrieved admin is not null and has the correct ID
	        assertNotNull(retrievedAdmin);
	        assertEquals(admin.getAdminId(), retrievedAdmin.getAdminId());
	        assertEquals("admin3", retrievedAdmin.getAdminUserName());
	        assertEquals("password3", retrievedAdmin.getAdminPassword());
	        assertEquals("admin5@example.com", retrievedAdmin.getAdminEmail());
	    }
	
	    
	    
	    @Test
	    public void testUpdateAdminById() {
	        // Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdminUserName("admin1");
	        admin.setAdminPassword("password1");
	        admin.setAdminEmail("admin1@example.com");

	        admin = adminRepository.save(admin);

	        // Update the admin's details
	        int adminId = admin.getAdminId();
	        Admin updatedAdmin = adminRepository.findById(adminId).orElse(null);
	        assertNotNull(updatedAdmin);

	        // Modify the admin's attributes
	        updatedAdmin.setAdminUserName("newAdmin1"); // Update username
	        updatedAdmin.setAdminPassword("newPassword1"); // Update password
	        updatedAdmin.setAdminEmail("newAdmin1@example.com"); // Update email

	        // Save the updated admin
	        updatedAdmin = adminRepository.save(updatedAdmin);

	        // Retrieve the updated admin from the database
	        Admin retrievedAdmin = adminRepository.findById(adminId).orElse(null);
	        assertNotNull(retrievedAdmin);

	        // Assert that the attributes have been updated
	        assertEquals("newAdmin1", retrievedAdmin.getAdminUserName());
	        assertEquals("newPassword1", retrievedAdmin.getAdminPassword());
	        assertEquals("newAdmin1@example.com", retrievedAdmin.getAdminEmail());
	    }


	    
	    
	    @Test
	    public void testDeleteAdminById() {
	        // Create and save an admin
	        Admin admin = new Admin();
	        admin.setAdminUserName("admin2");
	        admin.setAdminPassword("password2");
	        admin.setAdminEmail("admin2@example.com");

	        admin = adminRepository.save(admin);

	        // Get the ID of the admin to be deleted
	        int adminId = admin.getAdminId();

	        // Delete the admin by ID
	        adminRepository.deleteById(adminId);

	        // Try to retrieve the deleted admin by ID, and it should be null
	        Admin deletedAdmin = adminRepository.findById(adminId).orElse(null);
	        assertNull(deletedAdmin);
	    }

	
	
}
