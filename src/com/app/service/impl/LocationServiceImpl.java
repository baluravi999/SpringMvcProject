package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.models.Location;
import com.app.service.ILocationService;

@Service
public class LocationServiceImpl implements ILocationService {
@Autowired
	private ILocationDao dao;
	@Override
	public int saveLocation(Location loc) {
		return dao.saveLocation(loc);
	}

	@Override
	public void updateLocation(Location loc) {
    dao.updateLocation(loc);
	}

	@Override
	public void deleteLocation(int locId) {
	dao.deleteLocation(locId);
	}

	@Override
	public Location getLocationById(int locId) {
    return dao.getLocById(locId);
	}

	@Override
	public List<Location> getAllLocations() {
	return dao.getAllLocations();
	}
	public List<Object[]> getLocTypeAndCount()
	{
		return dao.getLocTypeAndCount();
	}
}