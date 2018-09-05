package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.models.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao {
	
	@Autowired
	private HibernateTemplate ht;
	@Override
	public int saveDocument(Document doc) {
		return (Integer)ht.save(doc);
	}

	@Override
	public List<Object[]> getFileIdAndName() {

		String hql="select fileId,fileName from com.app.models.Document";
		//Document.getClass().getName();
		List<Object[]> list=ht.find(hql);
		return list;
	}
	public Document getDocumentById(int docId)
	{
		return ht.get(Document.class,docId);
	}
}