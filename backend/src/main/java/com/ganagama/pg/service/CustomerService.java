package com.ganagama.pg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ganagama.pg.domain.CustomerDTO;
import com.ganagama.pg.model.Customer;

@Service
public interface CustomerService {

	public Customer customerForm(CustomerDTO customerDto);

	public List<Customer> getAllCustomers();
	
}
