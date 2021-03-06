package com.minjoo.demo.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UploadController {
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-",File.separator);
		
	}
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("uploadForm ::");
		
	}//end uploadForm
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		log.info("uploadFormAction::");
		
		String uploadFolder = "c://upload";
		for(MultipartFile multipartFile : uploadFile) {
			log.info("-----------------------------");
			log.info("uploadfilename:"+multipartFile.getOriginalFilename());
			log.info("uploadfilesize:"+multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.info(e.getMessage());
				
			}//end try 
		}//end for
		
	}//uploadFormPost
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("uploadAjax::");
		
	}
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
		
		log.info("uploadAjaxAction::");
		String uploadFolder = "c://upload";
		File uploadPath = new File(uploadFolder,getFolder());
		log.info("upload path :"+uploadPath);
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		for(MultipartFile multipartFile :uploadFile) {
			log.info("--------------------------for--");
			log.info("uploadFileName"+multipartFile.getOriginalFilename());
			log.info("uploadFileSize"+multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("//")+1);
			log.info("only file name: "+uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString()+"-"+uploadFileName;
			
			File saveFile = new File(uploadFolder, uploadFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.info(e.getMessage());
				
			}//end try 
			
			
		}//end for
	
		
		
		
	}//uploadAjaxAction

	
	
}//UploadController
