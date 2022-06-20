package me.light.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.light.model.SampleVO;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@GetMapping(value = "/getText",produces = "text/plain;charset=utf-8")
	public String getText() {
		return "안녕하세요!";
	}
	
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "홍길", "홍");
	}
	
	
	@GetMapping(value = "/sampleList", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public List<SampleVO> sampleList(){
		List<SampleVO> list=new ArrayList<SampleVO>();
		list.add(new SampleVO(1,"길동","홍"));
		list.add(new SampleVO(2,"길동","김"));
		list.add(new SampleVO(3,"길동","고"));
		list.add(new SampleVO(4,"길동","마"));
		return list;
	}
	
	@GetMapping(value = "/getMap", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map=new HashMap<>();
		map.put("first", new SampleVO(1, "길동", "홍"));
		map.put("second", new SampleVO(1, "길동", "홍"));
		return map;
	}
	
	@GetMapping("/member/{id}")
	public String[] getPath(String id) {
		return new String[] {id,"홍길동"};
	}
}
