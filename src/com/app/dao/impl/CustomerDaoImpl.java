package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.models.Customer;
import com.app.models.Item;
import com.app.models.Order;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	
	@Autowired
	private HibernateTemplate ht;
	
		@Override
		public int saveCustomer(Customer cust) {
			int custId = (Integer)ht.save(cust);
			return custId;
		}

		@Override
		public void updateCustomer(Customer cust) {
		ht.update(cust);
		}

		@Override
		public void deleteCustomer(int custId) {
		Customer cust=new Customer();
		cust.setCustId(custId);
		ht.delete(cust);
		}

		@Override
		public Customer getCustomerById(int custId) {
	    Customer cust=(Customer) ht.get(Customer.class,custId);
	    return cust;
		}

		@Override
		public List<Customer> getAllCustomers() {
		List<Customer> custList =ht.loadAll(Customer.class);
			return custList;
		}
		@Override
		public Customer getCustomerByEmail(String email) {
			Customer cust=null;
			String hql="from com.app.models.Customer where custEmail=?";
			List<Customer> list=ht.find(hql, email);
			
			if(list!=null && list.size()>0){
				cust=list.get(0);
			}
			
			return cust;
		}

		public List<Item> getCustItemsById(int custId)
		{
			String hql="from com.app.models.Item where custId=?";
			List <Item> items=ht.find(hql,custId);
			return items;
		}
		
		public List<Order> getCustOrdersById(int custId)
		{
			String hql="from com.app.models.Order where custId=?";
			List <Order> orders=ht.find(hql,custId);
			return orders;		
		}
}