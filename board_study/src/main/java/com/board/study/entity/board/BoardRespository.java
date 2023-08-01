package com.board.study.entity.board;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.board.study.dto.board.BoardRequestDto;

import jakarta.transaction.Transactional;

public interface BoardRespository extends JpaRepository<Board, Long>{

	static final String UPDATE_BOARD = "UPDATE BOARD "+ 
			"SET TITLE = :#{#boardRequestDto.title}, " +
			"CONTENT = :#{#boardRequestDto.content}, " +
			"UPDATE_TIME = TO_DATE(SYSDATE, 'yyyy-mm-dd hh24:mi:ss')" +
			"WHERE ID = :#{#boardRequestDto.id}";
	
	static final String UPDATE_BOARD_READ_CNT_INC ="UPDATE BOARD SET READ_CNT = READ_CNT+1 WHERE ID=:id";
	
	static final String DELETE_BOARD = "DELETE FROM Board WHERE ID IN(:deleteList)";
	
	@Transactional // 선언적 트랜잭션을 사용한다.
	@Modifying //@Query 어노테이션으로 작성 된 변경, 삭제 쿼리를 사용할 때 사용한다.
	@Query(value = UPDATE_BOARD, nativeQuery = true)// SQL을 JPQL로 작성할 수 있고, nativeQuery=true옵션으로 네이티브 쿼리도 사용 가능하게 한다.
	public int updateBoard(@Param("boardRequestDto") BoardRequestDto boardRequestDto);
	
	@Transactional
	@Modifying
	@Query(value= UPDATE_BOARD_READ_CNT_INC, nativeQuery=true)
	public int updateBoardReadCntInc(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value = DELETE_BOARD, nativeQuery = true)
	public int deleteBoard(@Param("deleteList")Long[] deleteList);
	

}
