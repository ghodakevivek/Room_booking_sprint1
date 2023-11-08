package com.example.roombooking.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.roombooking.entity.Room;
import com.example.roombooking.model.RoomDTO;
@Component
public class RoomConverter {

	public Room convertToRoomEntity(RoomDTO roomDto) {
		Room room=new Room();
		if(roomDto!=null)
		{
			BeanUtils.copyProperties(roomDto, room);
		}
		return room;
	}

	public RoomDTO convertToRoomDTO(Room r) {
		RoomDTO roomDto=new RoomDTO();
		if(r!=null)
		{
			BeanUtils.copyProperties(r, roomDto);
		}
		return roomDto;
	}

}
