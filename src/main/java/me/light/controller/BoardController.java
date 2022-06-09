package me.light.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.light.model.Board;
import me.light.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping("/list")
	public String boardList(Model model) {
		model.addAttribute("list", service.getList());
		return "board/list";
	}

	@GetMapping("/get")
	public String get(Long bno, Model model) {
		model.addAttribute("board", service.get(bno));
		return "board/get";
	}
	
	@GetMapping("/modify")
	public String modifyForm(Board board) {
		System.out.println(board);
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String modify(Board board) {
		service.modify(board);
		return "redirect:board/modify";
	}
}
