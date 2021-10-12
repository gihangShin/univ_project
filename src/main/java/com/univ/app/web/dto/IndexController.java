package com.univ.app.web.dto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

//	private final 
	
	@RequestMapping(value = "/mainpage.do")
	public String index(Model model) {
		
		return "mainpage";
	}
	
	@RequestMapping(value="/chat.do")
	public String chat() {
		
		return "chat";
	}
	
}
