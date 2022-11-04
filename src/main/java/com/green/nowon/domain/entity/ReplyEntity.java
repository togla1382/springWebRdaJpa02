package com.green.nowon.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(exclude = "board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
	//@JoinColumn(name = "bno")//fk컬럼명 지정가능
	//@ManyToOne
	//BoardEntity board;//관계설정
	//FK컬럼명 : board_bno : 객체.pk이름-> 객체이름_pk이름
	
	@JoinColumn(nullable = false)//양방향관계에서 Many 엔티티를 owns엔티티 선언
	@ManyToOne// mappedBy가 존재하지 않아요
	BoardEntity board;//관계설정
}
