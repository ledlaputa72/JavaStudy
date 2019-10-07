package com.mgr.controller.sawonprocess;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mgr.sawon.service.TelInfoService;
import com.mgr.sawon.vo.TelInfoVO;

@Controller
public class SawonController {
	//business logic
	@Resource(name="TelInfoService") //�̸����� ã�ư��� (����� ��Ȯ�ϴ�)  
	//@Autowired //type ��Ÿ�Ϸ� ã�ư��� 
	private TelInfoService telInfoServive; //
	//@Service("TelInfoService")���� ���� 
	
	
	@RequestMapping("/getAllTelinfo.do")
	//��𼱰� getAllTelinfo.do �̸��� ��û�� ������
	//@RequestMapping���� �´�. 
	//@RequestMapping �� �Ʒ� �޼ҵ�� ��û�� ó�����ٷ� 
	//�̶� Model��ü model1�� view �� ���޽� ��Ʈ�ѷ��� ������ data�� ���� �׷� ��ü 
	public String sawonGetAllTelinfo(TelInfoVO vo1, Model model1) throws ClassNotFoundException, SQLException {
		
		model1.addAttribute("mAllTelinfo", telInfoServive.getAllTelinfo(vo1));
		//request.setAttribute()...
		return "sawonGetAllTelinfo.jsp"; //view ��� 
	}
	
	
}
