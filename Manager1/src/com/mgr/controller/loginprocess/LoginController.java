package com.mgr.controller.loginprocess;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mgr.login.service.LoginService;
import com.mgr.login.vo.LoginVO;

@Controller
public class LoginController {
	
	@Resource(name="LoginService")
	private LoginService loginService;
	
	// 회원 가입
	@RequestMapping("/signUp.do")
	public String registerAccount(LoginVO vo1, Model model1) throws SQLException {
		
		loginService.registerAccount(vo1);
		
		return "loginForm.jsp";
		
	}
	
	// 회원 탈퇴
	@RequestMapping("/deleteAccount.do")
	public String deleteAccount(LoginVO vo1, Model model1) throws SQLException {
			
		loginService.deleteAccount(vo1);
			
		return "loginForm.jsp";
			
	}
	
	// 로그인 체크
	@RequestMapping("/loginCheck.do")
	public String loginCheck(String id, String pwd, HttpSession session) throws SQLException {
		
		int status = loginService.loginCheck(id, pwd, session);
		
		if (status == 1)
			return "login.do";
		
		else
			return "loginForm.jsp";
		
	}
	
	// 로그인
	@RequestMapping("/login.do")
	public String login(LoginVO vo1, Model model1) throws SQLException {
		
		model1.addAttribute("mLogin", loginService.login(vo1));
		
		return "main.jsp";
		
	}
	
	// 로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		
		session.removeAttribute("sid");
		session.invalidate();
		
		return "loginForm.jsp";
		
	}
	
	// 내 정보 보기
	@RequestMapping("/myPage.do")
	public String getMyInfo(LoginVO vo1, Model model1) throws SQLException {
		
		model1.addAttribute("mMyInfo", loginService.login(vo1));
		
		return "myPage.jsp";
		
	}
	
	// 내 정보 수정
	@RequestMapping("/updateMyPage.do")
	public String updateMyInfo(LoginVO vo1, Model model1, HttpSession session) throws SQLException {
		
		loginService.updateMyInfo(vo1, session);
		
		return "loginCheck.do";
		
	}

}
