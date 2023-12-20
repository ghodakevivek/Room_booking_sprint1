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

import com.example.roombooking.dao.RoomRepository;
import com.example.roombooking.entity.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomRepositoryTest {

	 @Autowired
	    private RoomRepository roomRepository;

	    @Test
	    public void testCreateRoom() {
	    	 // Create and save an room
	        Room room = new Room();
	        room.setRoomNumber("G20");
	        room.setRoomType("Delux");
	        room.setRoomPrice(2000);
	        room.setRoomBeds(2);
	        room.setUser(null);;

	        Room savedRoom = roomRepository.save(room);
	        assertNotNull(savedRoom.getRoomId());
	    }
	    
	    
	    
	    
	    @Test
	    public void testGetAllRooms() {
	    	
	    	 // Clear the database to ensure a clean state
	        roomRepository.deleteAll();
	    	
	        // Create and save multiple room entities
	        Room room1 = new Room(1,"G20", "Delux", 2000, 2, null,null);
	        Room room2 = new Room(2,"G20", "Delux", 2000, 2, null, null);
	        Room room3 = new Room(3,"G20", "Delux", 2000, 2, null, null);

	        roomRepository.save(room1);
	        roomRepository.save(room2);
	        roomRepository.save(room3);

	        // Retrieve all rooms from the database
	        List<Room> allRooms = roomRepository.findAll();

	        // Assert that the list is not empty and contains the expected number of rooms
	        assertNotNull(allRooms);
	        assertEquals(3, allRooms.size());
	    }
	    
	    
	    
	    
	    
	    @Test
	    public void testGetRoomById() {
	        // Create and save an room
	        Room room = new Room();
	        room.setRoomNumber("G20");
	        room.setRoomType("Delux");
	        room.setRoomPrice(2000);
	        room.setRoomBeds(2);

	        room = roomRepository.save(room);

	        // Retrieve the room by ID
	        Room retrievedRoom = roomRepository.findById(room.getRoomId()).orElse(null);

	        // Assert that the retrieved room is not null and has the correct ID
	        assertNotNull(retrievedRoom);
	        assertEquals(room.getRoomId(), retrievedRoom.getRoomId());
	        assertEquals("G20", retrievedRoom.getRoomNumber());
	        assertEquals("Delux", retrievedRoom.getRoomType());
	        assertEquals(2000, retrievedRoom.getRoomPrice());
	        assertEquals(2, retrievedRoom.getRoomBeds());
	    }
	
	    
	    
	    @Test
	    public void testUpdateRoomById() {
	        // Create and save an room
	        Room room = new Room();
	        room.setRoomNumber("G20");
	        room.setRoomType("Delux");
	        room.setRoomPrice(2000);
	        room.setRoomBeds(2);

	        room = roomRepository.save(room);

	        // Update the room's details
	        int roomId = room.getRoomId();
	        Room updatedRoom = roomRepository.findById(roomId).orElse(null);
	        assertNotNull(updatedRoom);

	        // Modify the room's attributes
	        updatedRoom.setRoomNumber("G20"); 
	        updatedRoom.setRoomType("Delux"); 
	        updatedRoom.setRoomPrice(2000); 
	        updatedRoom.setRoomBeds(2);

	        // Save the updated room
	        updatedRoom = roomRepository.save(updatedRoom);

	        // Retrieve the updated room from the database
	        Room retrievedRoom = roomRepository.findById(roomId).orElse(null);
	        assertNotNull(retrievedRoom);

	        // Assert that the attributes have been updated
	        assertEquals("G20", retrievedRoom.getRoomNumber());
	        assertEquals("Delux", retrievedRoom.getRoomType());
	        assertEquals(2000, retrievedRoom.getRoomPrice());
	        assertEquals(2, retrievedRoom.getRoomBeds());
	    }


	    
	    
	    @Test
	    public void testDeleteRoomById() {
	        // Create and save an room
	        Room room = new Room();
	        room.setRoomNumber("G20");
	        room.setRoomType("Delux");
	        room.setRoomPrice(2000);
	        room.setRoomBeds(2);
	        
	        
	        room = roomRepository.save(room);

	        // Get the ID of the room to be deleted
	        int roomId = room.getRoomId();

	        // Delete the room by ID
	        roomRepository.deleteById(roomId);

	        // Try to retrieve the deleted room by ID, and it should be null
	        Room deletedRoom = roomRepository.findById(roomId).orElse(null);
	        assertNull(deletedRoom);
	    }

	
}
