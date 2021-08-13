package com.wingstech.resturant.tester;



import java.util.Collection;

import com.wingstech.resturant.constant.RestaurantType;
import com.wingstech.resturant.dao.RestaurantDAO;
import com.wingstech.resturant.dao.RestaurantDAOImpl;
import com.wingstech.resturant.dto.RestaurantDTO;

public class RestaurantTester {
	
	public static void main(String[] args) {
		RestaurantDTO dto = new RestaurantDTO(5,"Dwaraka", "Ashok Circle", "PavBhaji", true, RestaurantType.FAST_FOOD);
		RestaurantDTO dto1 = new RestaurantDTO(2,"Ayodhya", "Vijayanagar", "Dosa", false, RestaurantType.FAMILY);
		RestaurantDTO dto2 = new RestaurantDTO(3,"Resto", "MG Road", "KajuKari", true,RestaurantType.FAMILY);

		RestaurantDAO dao = new RestaurantDAOImpl();
		dao.save(dto);
		dao.save(dto1);
		dao.save(dto2);

		System.out.println(dao.findByName("Ayodhya"));

		Collection<RestaurantDTO> collection = dao.findByType(RestaurantType.FAMILY);
		collection.forEach(ref -> System.out.println(ref));

		System.out.println(dao.updateTypeByName(RestaurantType.FAST_FOOD, "Dwaraka"));

		System.out.println(dao.deleteByTypeAndName(RestaurantType.FAMILY, "Ayodhya"));
	}
}
