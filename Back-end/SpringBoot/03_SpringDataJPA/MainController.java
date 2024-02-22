package com.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jpa.model.vo.Member;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(@SessionAttribute(required = false) Member member) {
		return "main";
	}
}
