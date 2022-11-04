package com.green.nowon.domain.dto.board;

import java.time.LocalDateTime;

import com.green.nowon.domain.entity.BoardEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class BoardListDTO {
	private int bno;
	private String title;
	private int readCount;
	private String writer;
	private LocalDateTime updatedDate;
	
	public BoardListDTO(BoardEntity e) {
		this.bno = e.getBno();
		this.title = e.getTitle();
		this.readCount = e.getReadCount();
		this.writer = e.getWriter();
		this.updatedDate = e.getUpdatedDate();
	}
	
		//Entity객체를 매개변수로 하는 생성자
	/*
	public BoardListDTO(BoardEntity e) {
		bno=e.getBno();
		title=e.getTitle();
		readCount=e.getReadCount();
		writer=e.getWriter();
		updatedDate=e.getUpdatedDate();
	}
	*/
	
	
}
