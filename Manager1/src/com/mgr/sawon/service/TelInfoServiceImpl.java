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
	@Autowired : property, 생성자 ref 를 대신 사용하여 자동 DI
		-> 그러므로 setter, constructor 문장을 생략하게 만드는 것
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
