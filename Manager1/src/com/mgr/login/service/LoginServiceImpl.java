package com.mgr.login.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.login.dao.LoginDAO;
import com.mgr.login.vo.LoginVO;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

	// ȸ�� ����
	@Override
	public void registerAccount(LoginVO vo1) throws SQLException {
		
		loginDAO.registerAccount(vo1);
		
	}

	// ȸ�� Ż��
	@Override
	public void deleteAccount(LoginVO vo1) throws SQLException {

		loginDAO.deleteAccount(vo1);
		
	}

	// �α���
	@Override
	public LoginVO login(LoginVO vo1) throws SQLException {

		return loginDAO.getInfo(vo1);
		
	}

	// �α��� üũ
	@Override
	public int loginCheck(String id, String pwd, HttpSession session) throws SQLException {

		return loginDAO.loginCheck(id, pwd, session);
	}

	// �� ���� ����
	@Override
	public void updateMyInfo(LoginVO vo1, HttpSession session) throws SQLException {
		
		loginDAO.updateMyInfo(vo1, session);
		
	}	

}
