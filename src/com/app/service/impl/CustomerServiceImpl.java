package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.models.Customer;
import com.app.models.Item;
import com.app.models.Order;
import com.app.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;
	@Override
	public int saveCustomer(Customer cust) {
		return dao.saveCustomer(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
    dao.updateCustomer(cust);
	}

	@Override
	public void deleteCustomer(int custId) {
	dao.deleteCustomer(custId);
	}

	@Override
	public Customer getCustomerById(int custId) {
    return dao.getCustomerById(custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
	return dao.getAllCustomers();
	}
	
	@Override
	public Customer getCustomerByEmail(String email) {
		return dao.getCustomerByEmail(email);
	}
	public List<Item> getCustItemsById(int custId)
	{
	return dao.getCustItemsById(custId);
	}
	public List<Order> getCustOrdersById(int custId)
	{
		return dao.getCustOrdersById(custId);
	}
}
