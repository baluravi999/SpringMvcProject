package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.models.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter arg2, HttpServletRequest arg3, HttpServletResponse arg4)
			throws Exception {
		
		List<Vendor> venList=(List<Vendor>) map.get("venList");
		
		//create element
		Paragraph p=new Paragraph("Welcome to Vendor Data..."); 

		//create element
		PdfPTable table=new PdfPTable(7);
		table.addCell("ID");
		table.addCell("CODE");
		table.addCell("NAME");
		table.addCell("TYPE");
		table.addCell("EMAIL");
		table.addCell("CONTACT");
		table.addCell("ADDRESS");
		
		//adding data to table
		//1 object=1 row in table
		for(Vendor ven:venList){
			table.addCell(""+ven.getVenId());
			table.addCell(ven.getVenName());
			table.addCell(ven.getVenType());
			table.addCell(ven.getVenCode());
			table.addCell(ven.getVenEmail());
			table.addCell(ven.getVenContact());
			table.addCell(ven.getVenAddr());
		}
		
		
		//add element to DOCUMENT
		doc.add(p);
		doc.add(table);		
	}

}