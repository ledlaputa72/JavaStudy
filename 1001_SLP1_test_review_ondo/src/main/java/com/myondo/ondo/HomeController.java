package com.myondo.ondo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/kyesan", method = RequestMethod.GET)
	public String kaja(Model model, HttpServletRequest req) {
		
		String irum = req.getParameter("irum");
		
		int condo = Integer.parseInt(req.getParameter("condo")); 
		int hondo = (int) (condo * 1.8) + 32; 
		
		model.addAttribute("mirum", irum);
		model.addAttribute("mhondo", hondo);
		
		if (irum == "")
			return "error";
	
		else
		return "home";
		
	}
	
}
