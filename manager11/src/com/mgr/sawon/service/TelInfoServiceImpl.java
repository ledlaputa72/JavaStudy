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
	//jsp servlet 에서 haeva() execute()...
	
	
	//@Autowired는 property, 또는 생성자 ref를 대신사용하여 자동 DI
	// 그러므로 setter, constructor 문장을 생략하게 만드는 것 
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
