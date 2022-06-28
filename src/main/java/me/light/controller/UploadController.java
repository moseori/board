package me.light.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		
	}
	
	@PostMapping("uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		for(MultipartFile file : uploadFile) {
			System.out.println("========================");
			System.out.println("파일 이름 : "+ file.getOriginalFilename());
			System.out.println("파일 크기 : "+ file.getSize());
			File saveFile=new File("C://storage", file.getOriginalFilename());
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() { }
	
	@PostMapping("/uploadAjaxAction")
	@ResponseBody
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		for(MultipartFile file : uploadFile) {
			System.out.println("========================");
			System.out.println("파일 이름 : "+ file.getOriginalFilename());
			System.out.println("파일 크기 : "+ file.getSize());
			File saveFile=new File("C:\\storage", file.getOriginalFilename());
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
