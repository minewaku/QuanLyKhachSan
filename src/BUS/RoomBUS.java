package BUS;

import java.util.ArrayList;

import DAO.RoomDAO;
import DTO.RoomDTO;

public class RoomBUS {
	RoomDAO room = new RoomDAO();
	
	public ArrayList<RoomDTO> getAllRooms(){
		return room.getAllRooms();
	}
	
	public ArrayList<RoomDTO> getAllEmptyRooms(){
		return room.getAllEmptyRooms();
	}
	
	public ArrayList<RoomDTO> getAllFullRooms(){
		return room.getAllFullRooms();
	}

	public String addRoom(RoomDTO Room) {
		if (room.hasRoomId(Room.getRoomId()))
			return "Mã Phòng tồn tại";
		
		if (room.addRoom(Room))
			return "Thêm thành công";
		
		return "Thêm thất bại";	
	}
	
	public String editRoom(RoomDTO Room) {
		if (!room.hasRoomId(Room.getRoomId()))
			return "Mã Phòng không tồn tại";
		
		if (room.editRoom(Room))
			return "Chỉnh sửa thành công";
		
		return "Chỉnh sửa thất bại";
	}
	
	public String deleteRoom(RoomDTO Room) {
		if (!room.hasRoomId(Room.getRoomId()))
			return "Mã Phòng không tồn tại";
		
		if (room.deleteRoom(Room))
			return "Xóa thành công";
		
		return "Xóa thất bại";
	}
        
        public String searchRoom(RoomDTO Room) {
		if (!room.hasRoomId(Room.getRoomId()))
			return "Mã Phòng không tồn tại";
		
		if (room.searchRoom(Room))
			return "thành công";
		
		return "Không tìm thấy Mã Phòng";
	}
		
}
