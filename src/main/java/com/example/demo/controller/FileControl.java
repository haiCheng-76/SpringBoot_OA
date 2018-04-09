package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.demo.domain.File;
import com.example.demo.service.FileService;

@RestController
@RequestMapping("/fileControl")
public class FileControl {
	@Autowired
	private FileService fileservice;
	private Logger log = Logger.getLogger(FileControl.class);

	@PostMapping()
	public String addFile(@RequestParam(value = "file") CommonsMultipartFile uploadFile, HttpServletRequest request,
			@RequestParam(value = "uploader") Integer uploader) {
		log.info("文件：" + uploadFile + "uploader:" + uploader);
		File f = new File();
		String filename = uploadFile.getOriginalFilename();
		String path = request.getSession().getServletContext().getRealPath("uploadfile");
		if (request instanceof MultipartHttpServletRequest) {
			String filepath = path + java.io.File.separator + filename;
			f.setFile_location(filepath);
			f.setFilename(filename);
			f.setFilesize(uploadFile.getSize());
			f.setEmployee_id(uploader);
			log.info("文件路径：" + path);
			log.info("名字" + uploadFile.getOriginalFilename());
			log.info(uploadFile.getSize());
			java.io.File file = new java.io.File(path, filename);
			if (!file.exists()) {
				file.mkdirs();
			}
			try {
				uploadFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
				return "ERROR";
			} catch (IOException e) {
				e.printStackTrace();
				return "ERROR";
			}
			boolean isadded = fileservice.addFile(f);
			if (isadded) {
				return "SUCCESS";
			}
			return "ERROR";
		}
		return "ERROR";
	}

	@GetMapping()
	public List<File> getAllFile() {
		List<File> listFile = null;
		try {
			listFile = fileservice.getallFile();
		} catch (Exception e) {
			log.info("请求获取所有文件时，出现异常，请稍后重试");
			e.printStackTrace();
		}
		return listFile;
	}

	@GetMapping("{ID}")
	public File getFileById(@PathVariable("ID") Integer ID) {
		File file = new File();
		file.setFileid(ID);
		File f = fileservice.selectFileById(file);
		return f;
	}

	@DeleteMapping("{ID}")
	public String deleteFile(@PathVariable("ID") Integer ID) {
		boolean isdelete = false;
		String location = "";
		try {
			location = fileservice.getFileLocation(ID);
		} catch (Exception e) {
			log.info("请求文件路径时出现异常，请稍后重试");
			e.printStackTrace();
		}
		java.io.File f = null;
		try {
			f = new java.io.File(location);
		} catch (Exception e) {
			log.info("删除文件时出现错误");
			e.printStackTrace();
		}
		if (f.exists() && f.isFile()) {
			isdelete = f.delete();
		}
		File file = new File();
		file.setFileid(ID);
		boolean isdeleteFile = fileservice.deleteFile(file);
		if (isdelete && isdeleteFile) {
			return "SUCCESS";
		}
		return "ERROR";
	}
}
