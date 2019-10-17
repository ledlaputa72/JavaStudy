package com.mgr.sawon.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.sawon.dao.TelInfoDAO;
import com.mgr.sawon.vo.TelInfoVO;

@Service("TelInfoService")
public class TelInfoServiceImpl implements TelInfoService {
	
/*
	@Autowired : property, ������ ref �� ��� ����Ͽ� �ڵ� DI
		-> �׷��Ƿ� setter, constructor ������ �����ϰ� ����� ��
 */

	@Autowired
	private TelInfoDAO telinfoDAO;

	@Override
	public ArrayList<TelInfoVO> getAllTelinfo(TelInfoVO vo1) throws SQLException {
		
		return telinfoDAO.getAllTelinfo(vo1);
		
	}

	@Override
	public TelInfoVO getTelinfo(TelInfoVO vo1) throws SQLException {
		
		return telinfoDAO.getTelinfo(vo1);
		
	}

	@Override
	public void updateTelinfo(TelInfoVO vo1) throws SQLException {
		
		telinfoDAO.updateTelinfo(vo1);
		
	}

	@Override
	public void insertTelinfo(TelInfoVO vo1) throws SQLException {
		
		telinfoDAO.insertTelinfo(vo1);
		
	}

	@Override
	public void deleteTelinfo(TelInfoVO vo1) throws SQLException {
		
		telinfoDAO.deleteTelinfo(vo1);
		
	}

}
