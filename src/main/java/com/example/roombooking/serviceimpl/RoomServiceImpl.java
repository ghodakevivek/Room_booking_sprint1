package com.example.roombooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roombooking.dao.RoomRepository;
import com.example.roombooking.entity.Room;
import com.example.roombooking.model.RoomDTO;
import com.example.roombooking.service.RoomService;
import com.example.roombooking.util.RoomConverter;
@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private RoomConverter roomConverter;
	
	
	// create room method
	@Override
	public RoomDTO createRoom(Room room)
	{
		Room r=roomRepository.save(room);
		return roomConverter.convertToRoomDTO(r);
	}
	
	
	// Retrieve all rooms
	@Override
	public List<RoomDTO> getAllRooms()
	{
		List<Room> room=roomRepository.findAll();
		
		//List of type DTO
		List<RoomDTO> dtoList=new ArrayList<>();
		for(Room r: room)
		{
			dtoList.add(roomConverter.convertToRoomDTO(r));
		}
		return dtoList;
	}
	
	
	// Retrieve room by id
	@Override
	public RoomDTO getRoomById(int id)
	{
		Room r=roomRepository.findByRoomId(id);
		return roomConverter.convertToRoomDTO(r);
		
	}
	
	
	// Update room by id
	@Override
	public RoomDTO updateRoom(int id, Room room)
	{
		Room r=roomRepository.findByRoomId(id);
		
		r.setRoomNumber(room.getRoomNumber());
		r.setRoomType(room.getRoomType());
		r.setRoomPrice(room.getRoomPrice());
		r.setRoomBeds(room.getRoomBeds());
		
		
		Room rm=roomRepository.save(r);
		return roomConverter.convertToRoomDTO(rm);
	}
	
	
	
	// Delete adminLogin by id
	@Override
	public String deleteRoom(int id)
	{
		roomRepository.deleteById(id);
		return "Room got deleted successfully";
	}
}
