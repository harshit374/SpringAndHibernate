package project.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.crm.entity.Customer;
import project.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomer = customerService.getCustomers();
		theModel.addAttribute("customers",theCustomer);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String customerFormForUpdate(@RequestParam("customerId") int id,Model theModel) {
		Customer theCustomer = customerService.getCustomerById(id);
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String customerFormForDelete(@RequestParam("customerId") int id) {
		customerService.deleteCustomerById(id);
		return "redirect:/customer/list";
	}
	
}
