package com.how2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.how2code.springdemo.entity.Customer;
import com.how2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowired customer service

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		return customerService.getCustomers();
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
		if (customerService.getCustomer(id) == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}

		return customerService.getCustomer(id);
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {

		customer.setId(0);
		customerService.saveCustomer(customer);

		return customer;
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {

		customerService.saveCustomer(customer);

		return customer;
	}

	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable Integer id) {

		if (customerService.getCustomer(id) == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);

		}

		customerService.deleteCustomer(id);

		return "Deleted customer id " + id;
	}

}
