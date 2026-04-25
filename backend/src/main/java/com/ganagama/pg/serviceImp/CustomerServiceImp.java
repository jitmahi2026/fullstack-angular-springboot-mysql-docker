package com.ganagama.pg.serviceImp;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ganagama.pg.domain.CustomerDTO;
import com.ganagama.pg.model.Customer;
import com.ganagama.pg.repository.CustomerRepo;
import com.ganagama.pg.service.CustomerService;


@Component
public class CustomerServiceImp implements CustomerService{
	/*
	 * @Lazy
	 * 
	 * @Autowired private CustomerService customerService;
	 */
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Customer customerForm(CustomerDTO customerDto) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setName(customerDto.getName());
		customer.setEmailID(customerDto.getEmailID());
		customer.setMobileNo(customerDto.getMobileNo());
		customer.setJoiningDate(customerDto.getJoiningDate());
		customer.setAdvancePayment(customerDto.getAdvancePayment());
		customer.setAddress(customerDto.getAddress());
		customer.setGender(customerDto.getGender());
		customer.setRoomType(customerDto.getRoomType());
		customer.setMonthlyPkg(customerDto.getMonthlyPkg());
		customer.setPgNo(customerDto.getPgNo());
		customer.setRoomNo(customerDto.getRoomNo());
		customer.setAddharCard(customerDto.getAddharCard());
		return customerRepo.save(customer);
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		return (List<Customer>) customerRepo.findAll();
	}



}
