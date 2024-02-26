package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jpa.model.vo.Board;
import com.jpa.model.vo.Member;
import com.jpa.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardContorller {

	@Autowired
	private BoardService service;
	
	@GetMapping(value = {"index", "/"})
	public String index(Model model, @SessionAttribute(required = false) Member member) {
		return "/board/index";
	}
	
	@GetMapping("/allList1")
	public String allAList1(Model model) {
		List<Board> list = service.findAllSortByBnoDesc();
		model.addAttribute("list", list);
		model.addAttribute("count", service.count());
		return "/board/boardList";
	}
	
	@GetMapping("/allList2")
	public String allAList2(Model model) {
		List<Board> list = service.findAllSortByTitleAndSortByContent();
		model.addAttribute("list", list);
		model.addAttribute("count", service.count());
		return "/board/boardList";
	}
	
	@GetMapping("/page")
	public String page(Model model, int page, int pageSize ) {
		Page<Board> list = service.findAllByPaging(page, pageSize);
		model.addAttribute("list", list);
		model.addAttribute("count", list.getNumberOfElements());
		return "/board/boardList";
	}
	
	@GetMapping("/searchTitle")
	public String searchTitle(Model model, String title) {
		Page<Board> list = service.findByTitle(title, 0, 10);
		model.addAttribute("list", list);
		model.addAttribute("count", list.getNumberOfElements());
		return "/board/boardList";
	}
	
	@GetMapping("/searchTitleAndContent")
	public String searchTitleAndContent(Model model, String title, String content) {
		Page<Board> list = service.findByTitleAndContent(title, content, 0, 20);
		model.addAttribute("list", list);
		model.addAttribute("count", list.getNumberOfElements());
		return "/board/boardList";
	}
	
	@GetMapping("/searchTitleAndContentAndMemberId")
	public String searchTitleAndContentAndMemberId(Model model, String title, String content, String memberId) {
		Page<Board> list = service.findByTitleAndContentAndMemberId(title, content, memberId, 0, 20);
		model.addAttribute("list", list);
		model.addAttribute("count", list.getNumberOfElements());
		return "/board/boardList";
	}
	
	@GetMapping("/searchTitle1")
	public String searchTitle1(Model model, String title) {
		List<Board> list = service.findByTitle1(title);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/board/boardList";
	}
	
	@GetMapping("/searchTitle2")
	public String searchTitle2(Model model, String title) {
		List<Board> list = service.findByTitle2(title);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/board/boardList";
	}
}
