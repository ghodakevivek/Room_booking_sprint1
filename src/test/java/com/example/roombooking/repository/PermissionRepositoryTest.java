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

import com.example.roombooking.dao.PermissionRepository;
import com.example.roombooking.entity.Permission;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionRepositoryTest {

	 @Autowired
	    private PermissionRepository permissionRepository;

	    @Test
	    public void testCreatePermission() {
	    	 // Create and save an permission
	        Permission permission = new Permission();
	        permission.setRequestStatus("Accept");

	        Permission savedPermission = permissionRepository.save(permission);
	        assertNotNull(savedPermission.getPermissionId());
	    }
	    
	    
	    
	    
	    @Test
	    public void testGetAllPermissions() {
	    	
	    	 // Clear the database to ensure a clean state
	        permissionRepository.deleteAll();
	    	
	        // Create and save multiple permission entities
	        Permission permission1 = new Permission(1,"Accept", null);
	        Permission permission2 = new Permission(2,"Accept", null);
	        Permission permission3 = new Permission(3,"Accept", null);

	        permissionRepository.save(permission1);
	        permissionRepository.save(permission2);
	        permissionRepository.save(permission3);

	        // Retrieve all permissions from the database
	        List<Permission> allPermissions = permissionRepository.findAll();

	        // Assert that the list is not empty and contains the expected number of permissions
	        assertNotNull(allPermissions);
	        assertEquals(3, allPermissions.size());
	    }
	    
	    
	    
	    
	    
	    @Test
	    public void testGetPermissionById() {
	        // Create and save an permission
	        Permission permission = new Permission();
	        permission.setRequestStatus("Accept");
	        permission.setAdmin(null);

	        permission = permissionRepository.save(permission);

	        // Retrieve the permission by ID
	        Permission retrievedPermission = permissionRepository.findById(permission.getPermissionId()).orElse(null);

	        // Assert that the retrieved permission is not null and has the correct ID
	        assertNotNull(retrievedPermission);
	        assertEquals(permission.getPermissionId(), retrievedPermission.getPermissionId());
	        assertEquals("Accept", retrievedPermission.getRequestStatus());
	       
	    }
	
	    
	    
	    @Test
	    public void testUpdatePermissionById() {
	        // Create and save an permission
	        Permission permission = new Permission();
	        permission.setRequestStatus("Accept");
	        permission.setAdmin(null);

	        permission = permissionRepository.save(permission);

	        // Update the permission's details
	        int permissionId = permission.getPermissionId();
	        Permission updatedPermission = permissionRepository.findById(permissionId).orElse(null);
	        assertNotNull(updatedPermission);

	        // Modify the permission's attributes
	        updatedPermission.setRequestStatus("Accept"); 
	       

	        // Save the updated permission
	        updatedPermission = permissionRepository.save(updatedPermission);

	        // Retrieve the updated permission from the database
	        Permission retrievedPermission = permissionRepository.findById(permissionId).orElse(null);
	        assertNotNull(retrievedPermission);

	        // Assert that the attributes have been updated
	        assertEquals("Accept", retrievedPermission.getRequestStatus());
	      
	    
	    }


	    
	    
	    @Test
	    public void testDeletePermissionById() {
	        // Create and save an permission
	        Permission permission = new Permission();
	        permission.setRequestStatus("Accept");
	        permission.setAdmin(null);

	        permission = permissionRepository.save(permission);

	        // Get the ID of the permission to be deleted
	        int permissionId = permission.getPermissionId();

	        // Delete the permission by ID
	        permissionRepository.deleteById(permissionId);

	        // Try to retrieve the deleted permission by ID, and it should be null
	        Permission deletedPermission = permissionRepository.findById(permissionId).orElse(null);
	        assertNull(deletedPermission);
	    }

	
	
	
}
