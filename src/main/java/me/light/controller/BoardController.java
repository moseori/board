package me.light.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.light.model.Board;
import me.light.model.BoardAttachVO;
import me.light.model.Criteria;
import me.light.model.PageMaker;
import me.light.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping("/list")
	public String boardList(Model model, Criteria criteria) {
		PageMaker pageMaker = new PageMaker(criteria, service.totalCount(criteria));
		pageMaker.setCriteria(criteria);
		model.addAttribute("list", service.getList(criteria));
		model.addAttribute("pageMaker", pageMaker);
		return "board/list";
	}

	@GetMapping("/get")
	public String get(Long bno, Model model) {
		model.addAttribute("board", service.get(bno));
		return "board/get";
	}
	
	@GetMapping("/modify")
	public String modifyForm(Long bno, Model model) {
		service.get(bno);
		model.addAttribute("board", service.get(bno));
		return "board/modify";
	}
	@PreAuthorize("principal.username == #board.wrirer")
	@PostMapping("/modify")
	public String modify(Board board, RedirectAttributes rttr) {
		service.modify(board);
		rttr.addFlashAttribute("message",board.getBno());
		return "redirect:list";
	}
	
	@PreAuthorize("principal.username == #wrirer")
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr, String writer) {
		List<BoardAttachVO> attachList=service.getAttachList(bno);
		deleteFile(attachList);
		service.remove(bno);
		rttr.addFlashAttribute("message",bno);
		return "redirect:list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/register")
	public String registerForm() {
		return "board/register";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/register")
	public String register(Board board, RedirectAttributes rttr) {
		service.register(board);
		rttr.addFlashAttribute("message", board.getBno());
//		board.getAttachList().forEach(v ->{
//			System.out.println(v);
//		});
//		System.out.println(board.getAttachList());
//		System.out.println(board.getBno());
//		rttr.addFlashAttribute("message",board.getBno());
		return "redirect:list";
	}
	
	@GetMapping(value ="/getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		List<BoardAttachVO> attcahList=service.getAttachList(bno);
		return new ResponseEntity<>(attcahList, HttpStatus.OK);
	}
	
	private void deleteFile(List<BoardAttachVO> attachList) {
		if (attachList == null || attachList.size() == 0) return;
		attachList.forEach(attach -> {
			Path file = Paths .get("C:/storage/" + attach.getUploadPath() + "/" + attach.getUuid() + "_" + attach.getFileName());
//			System.out.println(file);
			try {
				Files.deleteIfExists(file);
				if (Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("C:/storage/" + attach.getUploadPath() + "/s_" + attach.getUuid() + "_" + attach.getFileName());
					Files.deleteIfExists(thumbNail);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
