package com.app.dao;

import java.util.List;

import com.app.models.Item;

public interface IItemDao {

public int saveItem(Item item);
public void updateItem(Item item);
public void deleteItem (int itemId);
public Item getItemById(int itemId);
public List<Item> getAllItems();
}