package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDocumentDao;
import com.app.models.Document;
import com.app.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {

@Autowired
IDocumentDao dao;
	@Override
	public int saveDocument(Document doc) {
		
		return dao.saveDocument(doc);
	}

	@Override
	public List<Object[]> getFileIdAndName() {
		List<Object[]> list=dao.getFileIdAndName();
		return list;
	}

	public Document getDocumentById(int docId)
	{
		return dao.getDocumentById(docId);
	}
}