package com.board.study.web;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardFileContoller {
	
	private final BoardFileService boardFileService;

	@GetMapping("/file/download")
	public void downloadFile(@RequestParam()Long id, HttpServletResponse res) throws Exception{
		try {
			// 파일 정보를 조회한다.
			BoardFileResponseDto fileInfo = boardFileService.findById(id);
			
			if(fileInfo == null) throw new FileNotFoundException("Empty FileDate");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
