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

import com.example.roombooking.dao.UserRepository;
import com.example.roombooking.entity.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	
	 @Autowired
	    private UserRepository userRepository;

	    @Test
	    public void testCreateUser() {
	    	 // Create and save an user
	        User user = new User();
	        user.setUserFirstName("Vivek");
	        user.setUserLastName("Ghodake");
	        user.setUserAadhar("123456789123");
	        user.setUserAge(25);
	        user.setUserCity("Mumbai");
	        user.setUserMobile("1234567890");
	        user.setUserEmail("vivek@gmail.com");
	        user.setUserUserName("vivekGhodake");
	        user.setUserPassword("vivek123");

	        User savedUser = userRepository.save(user);
	        assertNotNull(savedUser.getUserId());
	    }
	    
	    
	    
	    
	   
	    public void testGetAllUsers() {
	    	
	    	 // Clear the database to ensure a clean state
	        userRepository.deleteAll();
	    	
	        // Create and save multiple user entities
	        User user1 = new User(1,"Vivek", "Ghodake", "123456789123",25, "Mumbai", "1234567890", "vivek@gmail.com", "vivekGhodake", "vivek123" );
	        User user2 = new User(2,"suresh", "mishra", "357638268823", 25, "Pune", "5678392168", "suresh@gmail.com", "SureshMishra", "suresh123" );
	        User user3 = new User(3,"nikita", "sing", "2345786934567",25, "Jaypur", "3452679872", "nikita@gmail.com", "Nikitasing", "nikita123" );

	        userRepository.save(user1);
	        userRepository.save(user2);
	        userRepository.save(user3);

	        // Retrieve all users from the database
	        List<User> allUsers = userRepository.findAll();

	        // Assert that the list is not empty and contains the expected number of users
	        assertNotNull(allUsers);
	        assertEquals(3, allUsers.size());
	    }
	    
	    
	    
	    
	    
	    @Test
	    public void testGetUserById() {
	        // Create and save an user
	        User user = new User();
	        user.setUserFirstName("Vivek");
	        user.setUserLastName("Ghodake");
	        user.setUserAadhar("123456789123");
	        user.setUserAge(25);
	        user.setUserCity("Mumbai");
	        user.setUserMobile("1234567890");
	        user.setUserEmail("vivek@gmail.com");
	        user.setUserUserName("vivekGhodake");
	        user.setUserPassword("vivek123");

	        user = userRepository.save(user);

	        // Retrieve the user by ID
	        User retrievedUser = userRepository.findById(user.getUserId()).orElse(null);

	        // Assert that the retrieved user is not null and has the correct ID
	        assertNotNull(retrievedUser);
	        assertEquals(user.getUserId(), retrievedUser.getUserId());
	        assertEquals("Vivek", retrievedUser.getUserFirstName());
	        assertEquals("Ghodake", retrievedUser.getUserLastName());
	        assertEquals("123456789123", retrievedUser.getUserAadhar());
	        assertEquals(25, retrievedUser.getUserAge());
	        assertEquals("Mumbai", retrievedUser.getUserCity());
	        assertEquals("1234567890", retrievedUser.getUserMobile());
	        assertEquals("vivek@gmail.com", retrievedUser.getUserEmail());
	        assertEquals("vivekGhodake", retrievedUser.getUserUserName());
	        assertEquals("vivek123", retrievedUser.getUserPassword());
	    }
	
	    
	    
	    @Test
	    public void testUpdateUserById() {
	        // Create and save an user
	        User user = new User();
	        user.setUserFirstName("Vivek");
	        user.setUserLastName("Ghodake");
	        user.setUserAadhar("123456789123");
	        user.setUserAge(25);
	        user.setUserCity("Mumbai");
	        user.setUserMobile("1234567890");
	        user.setUserEmail("vivek@gmail.com");
	        user.setUserUserName("vivekGhodake");
	        user.setUserPassword("vivek123");

	        user = userRepository.save(user);

	        // Update the user's details
	        int userId = user.getUserId();
	        User updatedUser = userRepository.findById(userId).orElse(null);
	        assertNotNull(updatedUser);

	        // Modify the user's attributes
	        updatedUser.setUserFirstName("Vivek"); 
	        updatedUser.setUserLastName("Ghodake"); 
	        updatedUser.setUserAadhar("123456789123"); 
	        updatedUser.setUserAge(25);
	        updatedUser.setUserCity("Mumbai"); 
	        updatedUser.setUserMobile("1234567890"); 
	        updatedUser.setUserEmail("vivek@gmail.com"); 
	        updatedUser.setUserUserName("vivekGhodake"); 
	        updatedUser.setUserPassword("vivek123"); 

	        // Save the updated user
	        updatedUser = userRepository.save(updatedUser);

	        // Retrieve the updated user from the database
	        User retrievedUser = userRepository.findById(userId).orElse(null);
	        assertNotNull(retrievedUser);

	        // Assert that the attributes have been updated
	        assertEquals("Vivek", retrievedUser.getUserFirstName());
	        assertEquals("Ghodake", retrievedUser.getUserLastName());
	        assertEquals("123456789123", retrievedUser.getUserAadhar());
	        assertEquals(25, retrievedUser.getUserAge());
	        assertEquals("Mumbai", retrievedUser.getUserCity());
	        assertEquals("1234567890", retrievedUser.getUserMobile());
	        assertEquals("vivek@gmail.com", retrievedUser.getUserEmail());
	        assertEquals("vivekGhodake", retrievedUser.getUserUserName());
	        assertEquals("vivek123", retrievedUser.getUserPassword());
	    }


	    
	    
	    @Test
	    public void testDeleteUserById() {
	        // Create and save an user
	        User user = new User();
	        user.setUserFirstName("Vivek");
	        user.setUserLastName("Ghodake");
	        user.setUserAadhar("123456789123");
	        user.setUserAge(25);
	        user.setUserCity("Mumbai");
	        user.setUserMobile("1234567890");
	        user.setUserEmail("vivek@gmail.com");
	        user.setUserUserName("vivekGhodake");
	        user.setUserPassword("vivek123");

	        user = userRepository.save(user);

	        // Get the ID of the user to be deleted
	        int userId = user.getUserId();

	        // Delete the user by ID
	        userRepository.deleteById(userId);

	        // Try to retrieve the deleted user by ID, and it should be null
	        User deletedUser = userRepository.findById(userId).orElse(null);
	        assertNull(deletedUser);
	    }

	
	
	
}
