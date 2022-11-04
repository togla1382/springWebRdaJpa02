package com.green.nowon.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@SequenceGenerator(name = "gen_seq_reply",
		sequenceName = "seq_reply",
		initialValue = 1, allocationSize = 1)
@Entity
public class ReplyEntity {
	@Id
	@GeneratedValue(generator = "gen_seq_reply", strategy = GenerationType.SEQUENCE)
	private int rno;
	@Column(nullable = false)
	private String text;
	private String writer;
	@CreationTimestamp
	private LocalDateTime createdDate;
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	//1:n n:1 ==이론적으로는 모두 일대다
	//다대일
	@ManyToOne
	BoardEntity board;//관계설정
	//FK컬럼명 : board_bno : 객체.pk이름-> 객체이름_pk이름
}
