package BUS;
import java.util.ArrayList;

import DAO.StaffDAO;
import DTO.CustomerDTO;
import DTO.StaffDTO;

public class StaffBUS {
	StaffDAO staff = new StaffDAO();
	
	public ArrayList<StaffDTO> getAllStaffs(){
		return staff.getAllStaffs();
	}

	public String addStaff(StaffDTO Staff) {
		if (staff.hasStaffID(Staff.getId()))
			return "Mã Nhân Viên tồn tại";
		
		if (staff.hasPhoneForAdd(Staff.getPhone()))
			return "Số điện thoại đã tồn tại";
		
		if (staff.checkValidPhone(Staff.getPhone()))
			return "Số điện thoại không hợp lệ";
		
		if (staff.checkIfDateIsValid(Staff.getBirthday()))
			return "Ngày không hợp lệ (MM/dd/yyyy)";
		
		if (staff.addStaff(Staff))
			return "Thêm thành công";
		
		return "Thêm thất bại";	
	}
	
	public String editStaff(StaffDTO Staff) {
		if (!staff.hasStaffID(Staff.getId()))
			return "Mã Nhân Viên không tồn tại";
		
		if (staff.hasPhoneForEdit(Staff.getPhone(), Staff.getId()))
			return "Số điện thoại đã tồn tại";
		
		if (staff.checkValidPhone(Staff.getPhone()))
			return "Số điện thoại không hợp lệ";
		
		if (!staff.checkIfDateIsValid(Staff.getBirthday()))
			return "Ngày không hợp lệ (MM/dd/yyyy)";
		
		if (staff.editStaff(Staff))
			return "Chỉnh sửa thành công";
		
		return "Chỉnh sửa thất bại";
	}
	
	public String deleteStaff(StaffDTO Staff) {
		if (!staff.hasStaffID(Staff.getId()))
			return "Mã Nhân Viên không tồn tại";
		
		if (staff.deleteStaff(Staff))
			return "Xóa thành công";
		
		return "Xóa thất bại";
	}
	
	public String login(int id, String password) {
		if (!staff.login(id, password))
			return "Sai mật khẩu hoặc id";
		
		return "Đăng nhập thành công";
	}
	
	public StaffDTO loginUser(StaffDTO Staff) {
		return staff.loginUser(Staff.getId(), Staff.getPassword());
	}
	
        public String searchStaff(StaffDTO Staff) {
            if (!staff.hasStaffID(Staff.getId()))
			return "Mã Nhân Viên không tồn tại";
		
		if (staff.deleteStaff(Staff))
			return "thành công";
		
		return "Không tìm thấy Mã Khách Hàng";
        }
}
