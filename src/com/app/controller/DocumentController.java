package com.app.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.app.models.Document;
import com.app.service.IDocumentService;

@Controller
public class DocumentController {

	@Autowired	
	private IDocumentService service;

	@RequestMapping("/regDocs")
	public String showPage(ModelMap map)
	{
		List<Object[]> list=service.getFileIdAndName();
		map.addAttribute("list",list);
		return "Document";
	}
	@RequestMapping(value="/uploadDoc",method=RequestMethod.POST)
	public String uploadDoc(@RequestParam("fileId")int fileId,@RequestParam("fileOb")CommonsMultipartFile cmf){

		if(cmf!=null){
			Document doc=new Document();
			doc.setFileId(fileId);
			doc.setFileName(cmf.getOriginalFilename());
			doc.setFileData(cmf.getBytes());
			service.saveDocument(doc);
		}
		return "redirect:regDocs";
	}
	@RequestMapping("downloadDoc")
	public String downloadDoc(@RequestParam("docId")int fileId,HttpServletResponse res)
	{
    Document doc=service.getDocumentById(fileId);
    String fname=doc.getFileName();
    byte[] fdata=doc.getFileData();
    res.addHeader("Content-Disposition","attachment;filename="+fname);
    try {
		FileCopyUtils.copy(fdata,res.getOutputStream());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return "redirect:regDocs";
	}
}