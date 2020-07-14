package project.crm.dao;

import java.util.List;

import project.crm.entity.Customer;

public interface CustomerDao {

	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomerById(int id);

	void deleteCustomerById(int id);
}
