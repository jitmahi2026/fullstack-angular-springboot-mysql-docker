package com.ganagama.pg.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ganagama.pg.config.AppConfig;
import com.ganagama.pg.domain.CustomerDTO;
import com.ganagama.pg.model.Customer;
import com.ganagama.pg.service.CustomerService;

@RestController
@RequestMapping("/customer")
//@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AppConfig appConfig;
	
	//customer/v1/customerform
	@PostMapping(path = "/v1/customerform", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> saveCustomerForm(@ModelAttribute CustomerDTO customerDto, @RequestParam("aadharCard") MultipartFile aadharCard)throws Exception{
		 
		Customer responce = null;
		
		try {

			if (!aadharCard.isEmpty()) {

			    String displayFileName = aadharCard.getOriginalFilename();

			    String displayExtension = "";

			    if (displayFileName.lastIndexOf(".") != -1
			            && displayFileName.lastIndexOf(".") != 0) {

			        displayExtension =
			                displayFileName.substring(displayFileName.lastIndexOf(".") + 1);
			    }

			    displayFileName =
			            RandomStringUtils.randomAlphanumeric(15) + "." + displayExtension;

			    // SAVE FILE NAME
			    customerDto.setAddharCard(displayFileName);

			    FileCopyUtils.copy(
			            aadharCard.getBytes(),
			            new File(appConfig.getImageFilePath(), displayFileName)
			    );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
		responce = customerService.customerForm(customerDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(responce);
		
	}
	
	  @GetMapping("/debug-files")
	    public List<String> debugFiles() {

	        File folder = new File("/app/uploads/");

	        File[] files = folder.listFiles();

	        List<String> names = new ArrayList<>();

	        if (files != null) {

	            for (File file : files) {
	                names.add(file.getName());
	            }
	        }

	        return names;
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
