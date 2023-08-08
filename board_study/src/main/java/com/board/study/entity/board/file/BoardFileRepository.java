package com.board.study.entity.board.file;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardFileRepository extends JpaRepository<BoardFile, Long> {
	
	static final String SELECT_FILE_ID ="SELECT ID FROM board_file" +
	"WHERE BOARD_ID = :boardId AND DELETE_YN !='Y'";
	
	static final String UPDATE_DELETE_YN = "UPDATE board_file SET"+
	"DELETE_YN='Y' WHERE ID IN (:deleteIdList)";
	
	static final String DELETE_BOARD_FILE_YN = "UPDATE board_file"+
	"SET DELETE_YN='Y'"+
	"WHERE bOARD_ID IN (:boardIdList)";
}
