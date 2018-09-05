package com.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.IItemDao;
import com.app.models.Item;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {
	@Autowired
	private IItemDao dao;
	@Override
	public int saveItem(Item item) {
		return dao.saveItem(item);
	}

	@Override
	public void updateItem(Item item) {
    dao.updateItem(item);
	}

	@Override
	public void deleteItem(int itemId) {
	dao.deleteItem(itemId);
	}

	@Override
	public Item getItemById(int itemId) {
    return dao.getItemById(itemId);
	}

	@Override
	public List<Item> getAllItems() {
	return dao.getAllItems();
	}
}