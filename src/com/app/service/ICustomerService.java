package com.app.service;

import java.util.List;

import com.app.models.Customer;
import com.app.models.Item;
import com.app.models.Order;

public interface ICustomerService {

	public int saveCustomer(Customer cust);
	public void updateCustomer(Customer cust);
	public void deleteCustomer (int custId);
	public Customer getCustomerById(int custId);
	public List<Customer> getAllCustomers();
	public Customer getCustomerByEmail(String email);
	public List<Item> getCustItemsById(int custId);
	public List<Order> getCustOrdersById(int custId);
}