package com.ganagama.pg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganagama.pg.domain.CustomerDTO;
import com.ganagama.pg.model.Customer;
import com.ganagama.pg.service.CustomerService;

@RestController
@RequestMapping("/customer")
//@CrossOrigin(origins = "http://localhost:4300")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	//customer/v1/customerform
	@PostMapping(path = "/v1/customerform", produces = "application/json")
	public ResponseEntity<Customer> saveCustomerForm(@RequestBody CustomerDTO customerDto)throws Exception{
		 
		Customer responce = null;
		 
		responce = customerService.customerForm(customerDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(responce);
		
	}
	
	@GetMapping(path = "/v1/allcustomer", produces = "application/json")
	public ResponseEntity<List<Customer>> getAllCustomers() {

		List<Customer> response = null;

		try {
			response = customerService.getAllCustomers();

			if (response == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			//LOGGER.error("Calling : CampController ,Method : getAllStars ,Exception" + e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
