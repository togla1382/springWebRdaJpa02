package com.green.nowon.domain.dto.mybatis;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MyBoardDTO {
	
	private long bno;
	private String title;
	private String content;
	private int readCount;
	private String writer;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

}
