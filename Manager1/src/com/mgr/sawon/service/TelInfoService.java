package com.mgr.sawon.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mgr.sawon.vo.TelInfoVO;

// �������̽����� �޼ҵ�� ���� ����
// ������ child ���� ����
// jsp servlet ���� haeva() execute() ...
public interface TelInfoService {
	
	public ArrayList<TelInfoVO> getAllTelinfo(TelInfoVO vo1) throws SQLException;
	
	public TelInfoVO getTelinfo(TelInfoVO vo1) throws SQLException;
	
	public void updateTelinfo(TelInfoVO vo1) throws SQLException;
	
	public void insertTelinfo(TelInfoVO vo1) throws SQLException;
	
	public void deleteTelinfo(TelInfoVO vo1) throws SQLException;
	
}
