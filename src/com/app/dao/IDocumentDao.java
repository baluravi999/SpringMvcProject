package com.app.dao;

import java.util.List;
import com.app.models.Document;

public interface IDocumentDao {

public int saveDocument(Document doc);
public List<Object[]> getFileIdAndName();
public Document getDocumentById(int docId);
}