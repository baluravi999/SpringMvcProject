package com.app.service;

import java.util.List;
import com.app.models.Document;

public interface IDocumentService {

	public int saveDocument(Document doc);
	public List<Object[]> getFileIdAndName();
	public Document getDocumentById(int docId);
}