package project.crm.service;

import java.util.List;

import project.crm.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomerById(int id);

	void deleteCustomerById(int id);

}
