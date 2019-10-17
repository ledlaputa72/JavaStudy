package com.mgr.sawon.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mgr.sawon.vo.TelInfoVO;

public interface TelInfoService {
	// jsp servlet ���� haeva() execute()...

	//�������̽����� �޼ҵ�� ���� ����/������ child���� ����
	public ArrayList<TelInfoVO> getAllTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
	
	public TelInfoVO getTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
	
	public void updateTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
	
	public void insertTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
	
	public void deleteTelinfo(TelInfoVO vo1) throws ClassNotFoundException, SQLException;
	
}
