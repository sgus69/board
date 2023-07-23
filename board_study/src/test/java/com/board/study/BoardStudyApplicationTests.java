package com.board.study;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.study.dto.board.BoardRequestDto;
import com.board.study.dto.board.BoardResponseDto;
import com.board.study.service.BoardService;

@SpringBootTest
class BoardStudyApplicationTests {
	
	@Autowired
	private BoardService boardService;
	
	@Test
	void save() {
		BoardRequestDto boardSaveDto = new BoardRequestDto();
		
		boardSaveDto.setTitle("제목");
		boardSaveDto.setContent("내용");
		boardSaveDto.setRegisterId("작성자");
		
		Long result = boardService.save(boardSaveDto);
		
		if(result >0) {
			System.out.println("#success save()~");
			findAll();
			findById(result);
		}else {
			System.out.println("# fail save()~");
		}
			
	}
	
	void findAll() {
		List<BoardResponseDto> list = boardService.findAll();
	}
	
	void findById(Long id) {
		
	}

}
