package com.mgr.controller.sawonprocess;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mgr.sawon.service.TelInfoService;
import com.mgr.sawon.vo.TelInfoVO;

// @Controller : spring ���� controller �������� �˷��ְ�, controller bean ��ü�� �ڵ����� ������ش�.
@Controller
public class SawonController {

	// �̸����� ��ü�� ã����, ��ü�� �Ѿ�� �� xml ���� �������� �ʰ� �Ѿ�´�.
	@Resource(name="TelInfoService")
	private TelInfoService telInfoService;
	
	// ��� ��ü ��� �����ִ� �޼ҵ�
	// @RequestMapping : �Ʒ� �޼ҵ�� ��û�� ó���ش޶�� ��
	// �� �� Model ��ü model1 �� view �� ���� �� ��Ʈ�ѷ��� ������ data �� ���� ��ü
	// getAllTelinfo.do ��û�� ������ �� ������ �Ѿ�´�.
	@RequestMapping("/getAllTelinfo.do")
	public String sawonGetAllTelinfo(TelInfoVO vo1, Model model1) throws SQLException {
		
		// request.setAttribute() �� ����
		// mAllTelinfo �̸����� �޾ƿ� ��ü�� ����
		model1.addAttribute("mAllTelinfo", telInfoService.getAllTelinfo(vo1));
		
		return "sawonGetAllTelinfo.jsp";
		
	}
	
	// ��� �� �� ���� �����ִ� �޼ҵ�
	@RequestMapping("/getTelinfo.do")
	public String sawonGetTelinfo(TelInfoVO vo1, Model model1) throws SQLException {
		
		// ������ ������ ����
		model1.addAttribute("mTelinfo", telInfoService.getTelinfo(vo1));
		
		// view ���
		return "sawonGetTelinfo.jsp";
		
	}
	
	// ��� ���� �����ϴ� �޼ҵ�
	@RequestMapping("/updateTelinfo.do")
	public String sawonUpdate(TelInfoVO vo1, Model model1) throws SQLException {
		
		telInfoService.updateTelinfo(vo1);
		
		return "getAllTelinfo.do";
		
	}
	
	// ��� ���� �����ϴ� �޼ҵ�
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
