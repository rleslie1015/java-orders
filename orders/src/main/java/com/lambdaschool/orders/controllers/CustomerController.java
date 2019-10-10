package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired()
	private CustomerService customerService;

	@GetMapping(value="/orders",
				produces = {"application/json"})
	public ResponseEntity<?> getAllCustomers()
	{
		List<Customer> myList = customerService.findAll();
		return new ResponseEntity<>(myList, HttpStatus.OK);
	}

	//	POST /customer/new - Adds a new customer including any  new orders
	@PostMapping(value = "/new",
				consumes = {"application/json"})
	public ResponseEntity<?> addNewCustomer(@Valid
	                                        @RequestBody Customer newCustomer)
	{
		customerService.save(newCustomer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	//PUT /customer/update/{custcode} - Updates the customer based off of custcode. Does not have to do anything with Orders!
	@PutMapping(value = "/update/{custcode}",
				consumes = {"application/json"})
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer,
	                                        @PathVariable long custcode)
	{
		customerService.update(customer, custcode);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@DeleteMapping("/delete/{custcode}")
	public ResponseEntity<?> deleteCustomer(@PathVariable long custcode)
	{
		customerService.delete(custcode);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
