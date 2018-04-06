package com.example.demo.service.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FileDao;
import com.example.demo.domain.File;
import com.example.demo.service.FileService;

@Service
public class FIleserviceImpl implements FileService {
	@Autowired
	private FileDao fileDao;
	private Logger log = Logger.getLogger(FIleserviceImpl.class);

	@Override
	public boolean addFile(File file) {
		int addnum = fileDao.addFile(file);
		System.out.println(file.toString());
		return addnum == 1 ? true : false;
	}

	@Override
	public boolean deleteFile(File file) {
		int delnum = fileDao.deleteFile(file);
		return delnum == 1 ? true : false;
	}

	@Override
	public boolean updateFile(File file) {
		int updatenum = fileDao.updateFile(file);
		return updatenum == 1 ? true : false;
	}

	@Override
	public File selectFileById(File file) {
		return fileDao.selectFileById(file);
	}

	@Override
	public List<File> getallFile() {
		List<File> llistfile = null;
		try {
			llistfile = fileDao.getallFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (File file : llistfile) {
			log.info(file);
		}
		return llistfile;
	}

	@Override
	public String getFileLocation(Integer ID) {
		String location = "";
		try {
			location = fileDao.getFileLocation(ID);
		} catch (Exception e) {
			log.info("获得文件路径失败");
			e.printStackTrace();
		}
		return location;
	}

}
