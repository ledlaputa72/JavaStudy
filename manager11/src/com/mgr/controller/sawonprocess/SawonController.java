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
	@Resource(name="TelInfoService") //이름으로 찾아가기 (대상이 명확하다)  
	//@Autowired //type 스타일로 찾아가기 
	private TelInfoService telInfoServive; //
	//@Service("TelInfoService")에서 쓴거 
	
	
	@RequestMapping("/getAllTelinfo.do")
	//어디선가 getAllTelinfo.do 이름의 요청이 들어오면
	//@RequestMapping에게 온다. 
	//@RequestMapping 는 아래 메소드로 요청을 처리해줄래 
	//이때 Model객체 model1은 view 로 전달시 컨트롤러가 생성한 data를 담을 그룻 객체 
	public String sawonGetAllTelinfo(TelInfoVO vo1, Model model1) throws ClassNotFoundException, SQLException {
		
		model1.addAttribute("mAllTelinfo", telInfoServive.getAllTelinfo(vo1));
		//request.setAttribute()...
		return "sawonGetAllTelinfo.jsp"; //view 경로 
	}
	
	
}
