package BUS;

import java.util.ArrayList;

import DAO.ServiceDAO;
import DTO.ServiceDTO;

public class ServiceBUS {
	ServiceDAO service = new ServiceDAO();
	
	public ArrayList<ServiceDTO> getAllServices(){
		return service.getAllServices();
	}
	
	public ArrayList<ServiceDTO> mostOrder(String from, String to) {
		return service.mostOrder(from, to);
	}

	public String addService(ServiceDTO Service) {
		if (service.hasServiceID(Service.getServiceId()))
			return "Mã Dịch Vụ tồn tại";
		
		if (service.hasName(Service.getName()))
			return "Tên Dịch Vụ đã tồn tại";
		
		if (service.addService(Service))
			return "Thêm thành công";
		
		return "Thêm thất bại";	
	}
	
	public String editService(ServiceDTO Service) {
		if (!service.hasServiceID(Service.getServiceId()))
			return "Mã Dịch Vụ không tồn tại";
		
		if (service.hasName(Service.getName()))
			return "Tên Dịch Vụ đã tồn tại";
		
		if (service.editService(Service))
			return "Chỉnh sửa thành công";
		
		return "Chỉnh sửa thất bại";
	}
	
	public String deleteService(ServiceDTO Service) {
		if (!service.hasServiceID(Service.getServiceId()))
			return "Mã Dịch Vụ không tồn tại";
		
		if (service.deleteService(Service))
			return "Xóa thành công";
		
		return "Xóa thất bại";
	}
        
    
	public String searchService(ServiceDTO Service) {
		if (!service.hasServiceID(Service.getServiceId()))
			return "Mã Dịch Vụ không tồn tại";
	
		if (service.searchService(Service))
			return "thành công";
	
		return "Không tìm thấy Mã Dịch Vụ";
	}
	
}
