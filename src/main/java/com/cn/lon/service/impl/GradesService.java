package com.cn.lon.service.impl;

import com.cn.lon.dao.IGradesDao;
import com.cn.lon.dao.impl.GradesDao;
import com.cn.lon.entity.Grades;
import com.cn.lon.service.IGradesService;

public class GradesService implements IGradesService {

	//实例service
	private IGradesDao gradesDao=new GradesDao();
	
	@Override
	public void addGrades(Grades grades) {
		gradesDao.addGrades(grades);
	}

	@Override
	public void updateGrades(Grades grades) {
		gradesDao.updateGrades(grades);
	}

	@Override
	public Grades findById(String stuid, String gradingtype, String gradingManId) {
		
		return gradesDao.findById(stuid, gradingtype, gradingManId);
	}

	@Override
	public Grades findAverageGrades(String stuid, String gradingtype) {
		
		return gradesDao.findAverageGrades(stuid, gradingtype);
	}

}
