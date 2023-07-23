package com.board.study.entity.board;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.board.study.dto.board.BoardRequestDto;

import jakarta.transaction.Transactional;

public interface BoardRespository extends JpaRepository<Board, Long>{

	String UPDATE_BOARD = "UPDATE bOARD "+ 
			"SET TITLE = :#{#boardRequestDto.title}, " +
			"CONTENT = :#{#boardRequestDto.content}, " +
			"UPDATE_TIME = NOW()" +
			"WHERE ID = :#{#:boardRequestDto.id}";
	
	@Transactional // 선언적 트랜잭션을 사용한다.
	@Modifying //@Query 어노테이션으로 작성 된 변경, 삭제 쿼리를 사용할 때 사용한다.
	@Query(value = UPDATE_BOARD, nativeQuery = true)
	// SQL을 JPQL로 작성할 수 있고, nativeQuery=true옵션으로 네이티브 쿼리도 사용 가능하게 한다.
	public int updateBoard(@Param("boardRequestDto") BoardRequestDto boardRequestDto);
}
