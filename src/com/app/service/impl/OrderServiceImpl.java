package com.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.IOrderDao;
import com.app.models.Order;
import com.app.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

@Autowired
private IOrderDao dao;
	
	@Override
	public int saveOrder(Order order) {
		return dao.saveOrder(order);
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