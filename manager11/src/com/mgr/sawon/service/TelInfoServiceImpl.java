package com.mgr.sawon.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.sawon.dao.TelInfoDAO;
import com.mgr.sawon.vo.TelInfoVO;

//@Repository
@Service("TelInfoService")
public class TelInfoServiceImpl  implements TelInfoService {
	//jsp servlet ���� haeva() execute()...
	
	
	//@Autowired�� property, �Ǵ� ������ ref�� ��Ż���Ͽ� �ڵ� DI
	// �׷��Ƿ� setter, constructor ������ �����ϰ� ����� �� 
	@Autowired
	private TelInfoDAO  telinfoDAO;
	
	public ArrayList<TelInfoVO> getAllTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException {
		return telinfoDAO.getAllTellinfo(vo1);
	}

	public TelInfoVO getTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException {
		return telinfoDAO.getTelinfo(vo1);
	}

	public void updateTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException {
		telinfoDAO.updateTelinfo(vo1);
	}

	public void insertTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException {
		telinfoDAO.insertTelinfo(vo1);
	}

	public void deleteTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException {
		telinfoDAO.deleteTelinfo(vo1);
	}
	
}
