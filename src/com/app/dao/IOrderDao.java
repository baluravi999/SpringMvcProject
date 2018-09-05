package com.app.dao;

import java.util.List;
import com.app.models.Order;

public interface IOrderDao {

	public int saveOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder (int orderId);
	public Order getOrderById(int orderId);
	public List<Order> getAllorders();
}