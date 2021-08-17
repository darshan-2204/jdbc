package com.xworkz.series.tester;

import java.util.Arrays;
import java.util.Collection;

import java.util.Optional;

import com.xworkz.series.constants.Education;
import com.xworkz.series.dao.CustomerDAO;
import com.xworkz.series.dao.CustomerDAOImpl;
import com.xworkz.series.dto.CustomerDTO;
import com.xworkz.series.service.CustomerService;
import com.xworkz.series.service.CustomerServiceImpl;

public class CustomerTester {

	public static void main(String[] args) {
		CustomerDTO dto = new CustomerDTO("Darshan", "Bangalore", "mysore", "3rd main vijayaanagar bangalore", false,
				1234567890, Education.BE);
			CustomerDTO dto1 = new CustomerDTO("sachin", "davanagere", "Bangalore", "2nd main davanagere", true,
					1458903900, Education.BTECH);
			CustomerDTO dto2 = new CustomerDTO("Sunil", "Shimoga", "Bangalore", "33th main RR nagar Bangalore", true,
					1575567889, Education.MCOM);
			CustomerDTO dto3 = new CustomerDTO("Mridula", "Mangalore", "banaglore", "8th main Indiranagar bangalore", false,
					1345446444, Education.MEDICAL);
			CustomerDTO dto4 = new CustomerDTO("Aish", "Hassan", "Tumakuru", "4th main road  road Hassan", false,
					1759696969, Education.BE);
			
			/*CustomerDAO dao = new CustomerDAOImpl();
			dao.save(dto);
			dao.save(dto1);
			dao.save(dto2);
			dao.save(dto3);
			dao.save(dto4);*/
			
			
			CustomerService serv = new CustomerServiceImpl();
			serv.save(dto);
			serv.save(dto1);
			serv.save(dto2);
			serv.save(dto3);
			serv.save(dto4);

			Collection<CustomerDTO> coll = Arrays.asList(dto, dto1, dto2, dto3, dto4);
			serv.saveAll(coll);
			coll.forEach(f->System.out.println(f));
			
			System.out.println("_____________________________________________________________________");
			
			Optional<CustomerDTO> findOne = serv.findOne(a -> a.getName().equalsIgnoreCase("darshan"));
			if (findOne.isPresent()) {
				CustomerDTO name = findOne.get();
				System.out.println(name);
			}

			System.out.println("_____________________________________________________________________");
			
			Collection<CustomerDTO> findAll = serv.findAll();
			findAll.forEach(e -> System.out.println(e));
			
			System.out.println("_____________________________________________________________________");
			
			
			Collection<CustomerDTO> findall = serv.findAll(b -> b.getAddress().equalsIgnoreCase("bangalore"));
			findall.forEach(r -> System.out.println(r));
			
			System.out.println("_____________________________________________________________________");
			
			
			Collection<CustomerDTO> nameDesc = serv.findAllSortNameDesc();
			nameDesc.forEach(d-> System.out.println(d));
			
			System.out.println("_____________________________________________________________________");
			
			
			int total = serv.total();
			System.out.println(total);
			

		}
	}


