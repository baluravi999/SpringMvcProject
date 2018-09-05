package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.models.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {

@Autowired
private HibernateTemplate ht;
	
	@Override
	public int saveVendor(Vendor ven) {
		int venId = (Integer)ht.save(ven);
		return venId;
	}

	@Override
	public void updateVendor(Vendor ven) {
	ht.update(ven);
	}

	@Override
	public void deleteVendor(int venId) {
	Vendor ven=new Vendor();
	ven.setVenId(venId);
	ht.delete(ven);
	}

	@Override
	public Vendor getVendorById(int venId) {
    Vendor ven=(Vendor) ht.get(Vendor.class,venId);
    return ven;
	}

	@Override
	public List<Vendor> getAllVendors() {
	List<Vendor> venList =ht.loadAll(Vendor.class);
		return venList;
	}
	public List<Object[]> getVenTypeAndCount()
	{
		String hql="select venType,count(venType) from com.app.models.Vendor group by venType";
		List<Object[]> data=ht.find(hql);
		return data;
	}
}