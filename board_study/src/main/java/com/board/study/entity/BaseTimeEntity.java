package com.board.study.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
//jpa 내부에서 엔티티 객체가 생성/변경되는 것을 감지하는 역할
public class BaseTimeEntity {
	
	@CreatedDate
	private LocalDateTime registerTime;
	
	@LastModifiedDate
	private LocalDateTime updateTime;
}
