package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.File;

@Mapper
public interface FileDao {
	int addFile(File file);

	int deleteFile(File file);

	int updateFile(File file);

	File selectFileById(File file);

	List<File> getallFile();

	String getFileLocation(Integer ID);
}
