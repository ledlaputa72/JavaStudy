package com.mgr.sawon.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mgr.sawon.vo.TelInfoVO;

public interface TelInfoService {
	// jsp servlet 에서 haeva() execute()...

	//인터페이스에서 메소드는 선언만 가능/구현은 child에서 구현
	public ArrayList<TelInfoVO> getAllTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
	
	public TelInfoVO getTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
	
	public void updateTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
	
	public void insertTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
	
	public void deleteTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
	
}
