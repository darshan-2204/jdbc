package com.xworkz.series.service;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.series.constants.Education;
import com.xworkz.series.dao.CustomerDAO;
import com.xworkz.series.dao.CustomerDAOImpl;
import com.xworkz.series.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAO dao = new CustomerDAOImpl();

	@Override
	public int save(CustomerDTO dto) {
		boolean nameValid = false;
		boolean fromValid = false;
		boolean toValid = false;
		boolean addressValid = false;
		boolean marriedValid = false;
		boolean passportValid = false;
		boolean educationValid = false;
		if (dto != null) {
			System.out.println("dto is not null,will start validating");
			String name = dto.getName();
			if (name != null && !name.isEmpty() && name.length() >= 3 && name.length() <= 30) {
				System.out.println("name is valid");
				nameValid = true;
			} else {
				System.out.println("name is invalid");
				nameValid = false;
			}
			String from = dto.getName();
			if (from != null && !from.isEmpty() && from.length() >= 5 && from.length() <= 30) {
				System.out.println("from is valid");
				fromValid = true;
			} else {
				System.out.println("from is invalid");
				fromValid = false;
			}
			String to = dto.getTo();
			if (to != null && !to.isEmpty() && to.length() >= 3 && to.length() <= 30) {
				System.out.println("to is valid");
				toValid = true;
			} else {
				System.out.println("to is nvalid");
				toValid = false;
			}
			String address = dto.getAddress();
			if (address != null && !address.isEmpty() && address.length() >= 4 && address.length() <= 20) {
				System.out.println("to is valid");
				addressValid = true;
			} else {
				System.out.println("to is invalid");
				addressValid = false;
			}
			Boolean married = dto.isMarried();
			if (married != false) {
				System.out.println("to is valid");
				marriedValid = true;
			} else {
				System.out.println("to is invalid");
				marriedValid = false;
			}

			int passport = dto.getPassportNo();
			if (passport != 0 && passport >= 4 && passport <= 15) {
				System.out.println("to is valid");
				passportValid = true;
			} else {
				System.out.println("to is invalid");
				passportValid = false;
			}
			Education education = dto.getEducation();
			if (education != null) {
				System.out.println("to is valid");
				educationValid = true;
			} else {
				System.out.println("to is invalid");
				educationValid = false;
			}
			if (nameValid && fromValid && toValid && addressValid && marriedValid && passportValid && educationValid) {
				System.out.println("data is valid returning success");
				return 1;
			}
			System.out.println("data is invalid returning failed");

			return 0;
		}
		return 0;
	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		dao.saveAll(collection);

	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		return dao.findOne(predicate);
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		return dao.findAll();
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		return dao.findAll(predicate);
	}

	@Override
	public Collection<CustomerDTO> findAllSortNameDesc() {
		return dao.findAllSortNameDesc();
	}

	@Override
	public int total() {
		return dao.total();
	}
}
