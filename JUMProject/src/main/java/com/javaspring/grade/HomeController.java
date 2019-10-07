package com.javaspring.grade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/kyesan", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) {
		
		String name = req.getParameter("name");
		String javaJumsoo = req.getParameter("javaJumsoo");
		String springJumsoo = req.getParameter("springJumsoo");
		
		if(name == "" || javaJumsoo == "" || springJumsoo == "" ) {		
			return "kajaError";
		}
		else {
			int javaJumsoo1 = Integer.parseInt(javaJumsoo);
			int springJumsoo1 = Integer.parseInt(springJumsoo);
			int total = 0;
			float avg = 0;
			
			//비즈니스 로직 
			total = javaJumsoo1 + springJumsoo1;
			avg = total/2;
			
			//
			model.addAttribute("mname", name);
			model.addAttribute("mjavaJumsoo", javaJumsoo);
			model.addAttribute("mspringJumsoo", springJumsoo);
			model.addAttribute("mtotal", total);
			model.addAttribute("mavg", avg);
			
			return "home";
		}
		
	}
	
}
