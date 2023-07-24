package com.board.study.entity.board;

import com.board.study.entity.BaseTimeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access= AccessLevel.PROTECTED)
//파라미터가 없는 생성자를 생성한다.
@Getter
@Entity
/*entity: 실제 db의 테이블과 매칭될 class임을 명시한다.
 		  즉, 테이블과 링크될 클래스임을 나타낸다.	*/ 
public class Board extends BaseTimeEntity{
	@Id //해당 테이블의 pk필드를 나타낸다.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//pk의 생성 규칙을 나타낸다.
	
	private Long Id;
	private String title;		//제목
	private String content;		//내용
	private int readCnt;		//조회수	
	private String registerId;	//작성자
	
	@Builder //어느 필드에 어떤 값을 채워야 할지 명확하게 정하여 생성 시점에 값을 채워준다.
	public Board(Long id, String title, String content, int readCnt, String registerId) {
		this.Id = id;
		this.title = title;
		this.content = content;
		this.readCnt = readCnt;
		this.registerId = registerId;
	}
}
