package com.mgr.login.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.mgr.login.vo.LoginVO;

public interface LoginService {
	
	// ȸ�� ����
	public void registerAccount(LoginVO vo1) throws SQLException;
	
	// ȸ�� Ż��
	public void deleteAccount(LoginVO vo1) throws SQLException;
	
	// �α���
	public LoginVO login(LoginVO vo1) throws SQLException;

	// �α��� üũ
	public int loginCheck(String id, String pwd, HttpSession session) throws SQLException;
	
	// �� ���� ����
	public void updateMyInfo(LoginVO vo1, HttpSession session) throws SQLException;
	
}
