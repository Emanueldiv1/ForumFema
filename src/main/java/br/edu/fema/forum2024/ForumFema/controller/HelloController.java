package br.edu.fema.forum2024.ForumFema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	
	String mensagem = "<h2>Hello String Fema</h2><br> "
			+ "<i style='color:blue;'>Emanuel Rodrigues </i>";
	
	
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return mensagem;
		
	}
	

}
