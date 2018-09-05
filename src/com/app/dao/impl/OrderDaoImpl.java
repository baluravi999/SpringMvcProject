package com.app.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.app.dao.IOrderDao;
import com.app.models.Order;

@Repository
public class OrderDaoImpl implements IOrderDao {

	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveOrder(Order order) {
		int ordId=(Integer)ht.save(order);
		return ordId;
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Order getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllorders() {
		// TODO Auto-generated method stub
		return null;
	}

}
