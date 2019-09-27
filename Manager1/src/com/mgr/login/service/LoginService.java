package com.mgr.login.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.mgr.login.vo.LoginVO;

public interface LoginService {
	
	// 회원 가입
	public void registerAccount(LoginVO vo1) throws SQLException;
	
	// 회원 탈퇴
	public void deleteAccount(LoginVO vo1) throws SQLException;
	
	// 로그인
	public LoginVO login(LoginVO vo1) throws SQLException;

	// 로그인 체크
	public int loginCheck(String id, String pwd, HttpSession session) throws SQLException;
	
	// 내 정보 수정
	public void updateMyInfo(LoginVO vo1, HttpSession session) throws SQLException;
	
}
