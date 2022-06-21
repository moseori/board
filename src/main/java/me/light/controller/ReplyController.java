package me.light.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.light.model.Criteria;
import me.light.model.ReplyVO;
import me.light.service.ReplyService;

@RestController
@RequestMapping("/replies/")
@AllArgsConstructor
public class ReplyController {
	private ReplyService service;

	@PostMapping(value = "new",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		int insertCount=service.register(vo);
		return insertCount==1?
				new ResponseEntity<>("success", HttpStatus.OK) :
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/page/{bno}/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable int page,@PathVariable Long bno){
		Criteria criteria=new Criteria(page, 10);
		return new ResponseEntity<>(service.getList(criteria, bno), HttpStatus.OK);
	}
}
