package com.example.roombooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.roombooking.entity.Room;
import com.example.roombooking.model.RoomDTO;
import com.example.roombooking.service.RoomService;
import com.example.roombooking.util.RoomConverter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomConverter roomConverter;
	
	
	
	
	// Method for creating the room
	@PostMapping("/createRoom")
	public ResponseEntity<RoomDTO> createRoom (@Valid @RequestBody RoomDTO roomDto)
	{
		final Room room=roomConverter.convertToRoomEntity(roomDto);
		return new ResponseEntity<RoomDTO>(roomService.createRoom(room), HttpStatus.CREATED);
	}
	
	
	
	// Method for retrieving all rooms
	@GetMapping("/getAllRooms")
	public List<RoomDTO> getAllRooms()
	{
		return roomService.getAllRooms();
	}
	
	
	// method for retrieving room using Id
	@GetMapping("/getRoomById/{id}")
	public RoomDTO getRoomById (@PathVariable int id)
	{
		return roomService.getRoomById(id);
	}
	
	//assign user to room
	@PostMapping("/room/assignUser/{userId}/{roomId}")
	public ResponseEntity<Room> assignUser(@PathVariable("userId") int userId,
	@PathVariable("roomId") int roomId)
	{
		return new ResponseEntity<Room>(roomService.assignUser(userId, roomId),
		HttpStatus.CREATED);
	}
	
	
	// Method for updating the room
	@PutMapping("/updateRoom/{id}")
	public RoomDTO updateRoom(@Valid @PathVariable int id, @RequestBody RoomDTO roomDto)
	{
		final Room room=roomConverter.convertToRoomEntity(roomDto);
		return roomService.updateRoom(id, room);
	}
	
	
	// Method for deleting the room using id
	@DeleteMapping("/deleteRoom/{id}")
	public String deleteRoom(@PathVariable int id)
	{
		return roomService.deleteRoom(id);
	}
}
