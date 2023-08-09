package com.board.study.dto.board.file;

import com.board.study.entity.board.file.BoardFile;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardFileResponseDto {
	
	private String origFileName;
	private String saveFileName;
	private String filePath;
	
	public BoardFileResponseDto(BoardFile entity) {
		this.origFileName = entity.getOrigFileName();
		this.saveFileName = entity.getSaveFileName();
		this.filePath = entity.getFilePath();
	}
	

	
}
