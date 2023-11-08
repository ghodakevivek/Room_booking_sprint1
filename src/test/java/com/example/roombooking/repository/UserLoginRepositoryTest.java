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

import com.example.roombooking.dao.UserLoginRepository;
import com.example.roombooking.entity.UserLogin;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginRepositoryTest {

	
	 @Autowired
	    private UserLoginRepository userLoginRepository;

	    @Test
	    public void testCreateUserLogin() {
	    	 // Create and save an userLogin
	        UserLogin userLogin = new UserLogin();
	        userLogin.setUserUserName("userLogin1");
	        userLogin.setUserPassword("password1");
	       
	        UserLogin savedUserLogin = userLoginRepository.save(userLogin);
	        assertNotNull(savedUserLogin.getUserLoginId());
	    }
	    
	    
	    
	    
	    @Test
	    public void testGetAllUserLogins() {
	    	
	    	 // Clear the database to ensure a clean state
	        userLoginRepository.deleteAll();
	    	
	        // Create and save multiple userLogin entities
	        UserLogin userLogin1 = new UserLogin(1,"userLogin1", "password1");
	        UserLogin userLogin2 = new UserLogin(2,"userLogin1", "password1");
	        UserLogin userLogin3 = new UserLogin(3,"userLogin1", "password1");

	        userLoginRepository.save(userLogin1);
	        userLoginRepository.save(userLogin2);
	        userLoginRepository.save(userLogin3);

	        // Retrieve all userLogins from the database
	        List<UserLogin> allUserLogins = userLoginRepository.findAll();

	        // Assert that the list is not empty and contains the expected number of userLogins
	        assertNotNull(allUserLogins);
	        assertEquals(3, allUserLogins.size());
	    }
	    
	    
	    
	    
	    
	    @Test
	    public void testGetUserLoginById() {
	        // Create and save an userLogin
	        UserLogin userLogin = new UserLogin();
	        userLogin.setUserUserName("userLogin1");
	        userLogin.setUserPassword("password1");

	        userLogin = userLoginRepository.save(userLogin);

	        // Retrieve the userLogin by ID
	        UserLogin retrievedUserLogin = userLoginRepository.findById(userLogin.getUserLoginId()).orElse(null);

	        // Assert that the retrieved userLogin is not null and has the correct ID
	        assertNotNull(retrievedUserLogin);
	        assertEquals(userLogin.getUserLoginId(), retrievedUserLogin.getUserLoginId());
	        assertEquals("userLogin1", retrievedUserLogin.getUserUserName());
	        assertEquals("password1", retrievedUserLogin.getUserPassword());
	      
	    }
	
	    
	    
	    @Test
	    public void testUpdateUserLoginById() {
	        // Create and save an userLogin
	        UserLogin userLogin = new UserLogin();
	        userLogin.setUserUserName("userLogin1");
	        userLogin.setUserPassword("password1");

	        userLogin = userLoginRepository.save(userLogin);

	        // Update the userLogin's details
	        int userLoginId = userLogin.getUserLoginId();
	        UserLogin updatedUserLogin = userLoginRepository.findById(userLoginId).orElse(null);
	        assertNotNull(updatedUserLogin);

	        // Modify the userLogin's attributes
	        updatedUserLogin.setUserUserName("newUserLogin1"); 
	        updatedUserLogin.setUserPassword("newPassword1"); 
	      
	        // Save the updated userLogin
	        updatedUserLogin = userLoginRepository.save(updatedUserLogin);

	        // Retrieve the updated userLogin from the database
	        UserLogin retrievedUserLogin = userLoginRepository.findById(userLoginId).orElse(null);
	        assertNotNull(retrievedUserLogin);

	        // Assert that the attributes have been updated
	        assertEquals("newUserLogin1", retrievedUserLogin.getUserUserName());
	        assertEquals("newPassword1", retrievedUserLogin.getUserPassword());
	       
	    }


	    
	    
	    @Test
	    public void testDeleteUserLoginById() {
	        // Create and save an userLogin
	        UserLogin userLogin = new UserLogin();
	        userLogin.setUserUserName("userLogin1");
	        userLogin.setUserPassword("password1");

	        userLogin = userLoginRepository.save(userLogin);

	        // Get the ID of the userLogin to be deleted
	        int userLoginId = userLogin.getUserLoginId();

	        // Delete the userLogin by ID
	        userLoginRepository.deleteById(userLoginId);

	        // Try to retrieve the deleted userLogin by ID, and it should be null
	        UserLogin deletedUserLogin = userLoginRepository.findById(userLoginId).orElse(null);
	        assertNull(deletedUserLogin);
	    }

	
}
