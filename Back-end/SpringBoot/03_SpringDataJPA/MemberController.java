package com.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpa.model.vo.Member;
import com.jpa.model.vo.MemberForm;
import com.jpa.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping(value = {"/index", "/"})
	public String index() {
		return "member/index";
	}
	
	@PostMapping("/login")
	public String login(Model model, String memberId, String password, HttpSession session) {
		Optional<Member> m = service.login(memberId, password);
		
		if(m.isPresent()) {
			model.addAttribute("loginMsg", "로그인에 성공하였습니다.");
			session.setAttribute("member", m.get());
		} else {
			model.addAttribute("loginMsg", "로그인에 실패하였습니다.");
		}
		return "member/index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/index";
	}
	
	@GetMapping("/allList")
	public String allList(Model model) {
		List<Member> list = service.findAll();
		long count = service.count();
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		return "member/memberList";
	}
	
	@GetMapping("/search")
	public String search(Model model, int mno) {
		Optional<Member> member = service.findByMno(mno);
		
		if(member.isPresent()) {
			List<Member> list = new ArrayList<>();	
			list.add(member.get());
			model.addAttribute("list", list);
		}
		return "member/memberList";
	}
	
	@GetMapping("/searchByName")
	public String searchByName(Model model, String name) {
		List<Member> list = service.findByName(name);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@GetMapping("/searchByNameAddress1")
	public String searchByNameAddress1(Model model, String name, String address) {
		List<Member> list = service.findByNameAndAddress(name, address);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@GetMapping("/searchByNameAddress2")
	public String searchByNameAddress2(Model model, String name, String address) {
		List<Member> list = service.findByNameAndAddress2(name, address);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@PostMapping("/join")
	public String joinMember(Model model, @Validated MemberForm memberForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			String msg = "회원가입에 실패 하였습니다. ";
			msg += " count : " + bindingResult.getErrorCount();
			msg += " msg : " + bindingResult.getAllErrors().get(0).getDefaultMessage();
			model.addAttribute("joinMsg", msg);
			return "member/index";
		}
		Member m = service.insert(memberForm.toMember());
		if(m != null) {
			model.addAttribute("joinMsg","회원가입에 성공하였습니다.");
		}else {
			model.addAttribute("joinMsg","회원가입에 실패하였습니다.");
		}
		return "member/index";
	}
	
	@PostMapping("/modify")
	public String modifyMember(Model model, @Validated MemberForm memberForm, BindingResult bindingResult, 
					HttpSession session) {
		if(bindingResult.hasErrors()) {
			String msg = "회원가입 정보수정에 실패 하였습니다. ";
			msg += " count : " + bindingResult.getErrorCount();
			msg += " msg : " + bindingResult.getAllErrors().get(0).getDefaultMessage();
			model.addAttribute("joinMsg", msg);
			return "member/index";
		}
		Member member = memberForm.toMember();
		if(member.getMno() == 0) {
			model.addAttribute("modifyMsg","회원정보 수정에 실패하였습니다.");
			return "member/index";
		}
		
		Member m = service.update(member);
		
		if(m != null) {
			session.setAttribute("member", m);
			model.addAttribute("modifyMsg","회원정보 수정에 성공하였습니다.");
		}else {
			model.addAttribute("modifyMsg","회원정보 수정에 실패하였습니다.");
		}
		return "member/index";
	}
	
	@GetMapping("/delete")
	public String delete(Model model, int mno) {
		boolean result = service.delete(mno);
		if(result == true) {
			model.addAttribute("delMsg","탈퇴에 성공하였습니다.");
		}else{
			model.addAttribute("delMsg","탈퇴에 실패하였습니다.");
		}
		return "member/index";
	}
}
