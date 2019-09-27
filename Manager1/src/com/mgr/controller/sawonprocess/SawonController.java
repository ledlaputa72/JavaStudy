package com.mgr.controller.sawonprocess;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mgr.sawon.service.TelInfoService;
import com.mgr.sawon.vo.TelInfoVO;

// @Controller : spring 에게 controller 파일임을 알려주고, controller bean 객체를 자동으로 만들어준다.
@Controller
public class SawonController {

	// 이름으로 객체를 찾으며, 객체가 넘어올 때 xml 에서 선언하지 않고도 넘어온다.
	@Resource(name="TelInfoService")
	private TelInfoService telInfoService;
	
	// 사원 전체 목록 보여주는 메소드
	// @RequestMapping : 아래 메소드로 요청을 처리해달라는 뜻
	// 이 때 Model 객체 model1 은 view 로 전달 시 컨트롤러가 생성한 data 를 담을 객체
	// getAllTelinfo.do 요청이 들어오면 이 쪽으로 넘어온다.
	@RequestMapping("/getAllTelinfo.do")
	public String sawonGetAllTelinfo(TelInfoVO vo1, Model model1) throws SQLException {
		
		// request.setAttribute() 와 동일
		// mAllTelinfo 이름으로 받아온 객체를 저장
		model1.addAttribute("mAllTelinfo", telInfoService.getAllTelinfo(vo1));
		
		return "sawonGetAllTelinfo.jsp";
		
	}
	
	// 사원 한 명 정보 보여주는 메소드
	@RequestMapping("/getTelinfo.do")
	public String sawonGetTelinfo(TelInfoVO vo1, Model model1) throws SQLException {
		
		// 가져갈 데이터 저장
		model1.addAttribute("mTelinfo", telInfoService.getTelinfo(vo1));
		
		// view 담당
		return "sawonGetTelinfo.jsp";
		
	}
	
	// 사원 정보 수정하는 메소드
	@RequestMapping("/updateTelinfo.do")
	public String sawonUpdate(TelInfoVO vo1, Model model1) throws SQLException {
		
		telInfoService.updateTelinfo(vo1);
		
		return "getAllTelinfo.do";
		
	}
	
	// 사원 정보 삭제하는 메소드
	@RequestMapping("/deleteTelinfo.do")
	public String sawonDelete(TelInfoVO vo1, Model model1) throws SQLException {
		
		telInfoService.deleteTelinfo(vo1);
		
		return "getAllTelinfo.do";
		
	}
	
	@RequestMapping("/insertTelinfo.do")
	public String sawonInsert(TelInfoVO vo1, Model model1) throws SQLException {
		
		telInfoService.insertTelinfo(vo1);
		
		return "getAllTelinfo.do";
		
	}
	
}
