package com.cn.lon.service.impl;

import java.util.List;

import com.cn.lon.dao.impl.FilesDao;
import com.cn.lon.entity.Files;
import com.cn.lon.service.IFilesService;

public class FilesService implements IFilesService {

	private FilesDao filesDao=new FilesDao();
	
	@Override
	public void addFiles(Files files) {
		filesDao.addFiles(files);

	}

	@Override
	public void deleteFiles(String title) {
		filesDao.deleteFiles(title);

	}

	@Override
	public List<Files> getAll() {
		return filesDao.getAll();
	}

	@Override
	public Files findByTitle(String title) {
		return filesDao.findByTitle(title);
	}

	
}
