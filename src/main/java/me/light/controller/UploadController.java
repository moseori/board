package me.light.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import me.light.model.AttachFileDTO;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		for(MultipartFile file : uploadFile) {
			System.out.println("========================");
			System.out.println("파일 이름 : "+ file.getOriginalFilename());
			System.out.println("파일 크기 : "+ file.getSize());
			File saveFile=new File("C:/storage", file.getOriginalFilename());
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
	
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		List<AttachFileDTO> list=new ArrayList<AttachFileDTO>();//객체 생성
		File uploadPath = new File("C:/storage", getFolder());

		if (!uploadPath.exists()) {
			uploadPath.mkdirs();
		}

		for (MultipartFile file : uploadFile) {
			AttachFileDTO attachFileDTO=new AttachFileDTO();
			String uploadFileName = file.getOriginalFilename();
			attachFileDTO.setFileName(uploadFileName);//uuid 문자열 적용전

			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;

			File saveFile = new File(uploadPath, uploadFileName);
			try {
				file.transferTo(saveFile);
				attachFileDTO.setUuid(uuid.toString());//uuid
				attachFileDTO.setUploadPath(getFolder());//업로드 폴더
				
				if (checkImageType(saveFile)) {
					attachFileDTO.setImage(true);//이미지여부
					FileOutputStream thumnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(file.getInputStream(), thumnail, 100, 100);
				}
				list.add(attachFileDTO);//리스트 추가
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<List<AttachFileDTO>>(list,HttpStatus.OK);
	}

	private String getFolder() {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(new Date());
		return str.replace("-", File.separator);
	}
	
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
;