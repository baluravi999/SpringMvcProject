package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.models.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class LocationPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter arg2, HttpServletRequest arg3, HttpServletResponse arg4)
			throws Exception {
		
		List<Location> locList=(List<Location>) map.get("locList");
		
		//create element
		Paragraph p=new Paragraph("Welcome to Location Data..."); 

		//create element
		PdfPTable table=new PdfPTable(4);
		table.addCell("ID");
		table.addCell("CODE");
		table.addCell("NAME");
		table.addCell("TYPE");
		
		//adding data to table
		//1 object=1 row in table
		for(Location loc:locList){
			table.addCell(""+loc.getLocId());
			table.addCell(loc.getLocName());
			table.addCell(loc.getLocType());
			table.addCell(loc.getLocCode());
		}
		
		
		//add element to DOCUMENT
		doc.add(p);
		doc.add(table);		
	}

}