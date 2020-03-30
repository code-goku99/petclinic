package com.petclinic.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/image")
@Controller
public class TestController {

	@PostMapping("/upload")
	public String imageUpload(@RequestParam("file") MultipartFile file) {
		try {
			saveImage(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/owners/";
	}

	private void saveImage(byte[] bytes) {
		System.out.println("File  uploading logic");
	}
}
