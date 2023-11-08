package com.example.roombooking.service;

import java.util.List;

import com.example.roombooking.entity.Room;
import com.example.roombooking.model.RoomDTO;

public interface RoomService {

	public RoomDTO createRoom(Room room);
	public List<RoomDTO> getAllRooms();
	public RoomDTO getRoomById(int id);
	public RoomDTO updateRoom(int id, Room room);
	public String deleteRoom(int id);

}
