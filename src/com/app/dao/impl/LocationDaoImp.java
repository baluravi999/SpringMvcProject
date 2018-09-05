package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.models.Location;

@Repository
public class LocationDaoImp implements ILocationDao {

@Autowired
private HibernateTemplate ht;
	
	@Override
	public int saveLocation(Location loc) {
		int locId = (Integer)ht.save(loc);
		return locId;
	}

	@Override
	public void updateLocation(Location loc) {
	ht.update(loc);
	}

	@Override
	public void deleteLocation(int locId) {
	Location loc=new Location();
	loc.setLocId(locId);
	ht.delete(loc);
	}

	@Override
	public Location getLocById(int locId) {
    Location loc=(Location) ht.get(Location.class,locId);
    return loc;
	}

	@Override
	public List<Location> getAllLocations() {
	List<Location> locList =ht.loadAll(Location.class);
		return locList;
	}
	public List<Object[]> getLocTypeAndCount()
	{
		String hql="select locType,count(locType) from com.app.models.Location group by locType";
		List<Object[]> data=ht.find(hql);
		return data;
	}
}