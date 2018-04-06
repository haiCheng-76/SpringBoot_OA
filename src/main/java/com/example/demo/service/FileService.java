package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.File;

public interface FileService {
	boolean addFile(File file);

	boolean deleteFile(File file);

	boolean updateFile(File file);

	File selectFileById(File file);

	List<File> getallFile();
	
	String getFileLocation(Integer ID);
}
