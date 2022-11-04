package com.green.nowon.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
		name = "gen_seq_bo",    // gen이름
		sequenceName = "seq_bo",// 시퀀스이름
		initialValue = 1,       // start with 1
		allocationSize = 1)     // increment by 1
@Table(name = "jpa_board")//카멜로 써도되요
@Entity//물리DB의 테이블과 매핑되는 클래스: 클래스이름==table이름, 필드이름(camel표기법)==컬럼명(underscore표기)
public class BoardEntity {//접속객체(DAO:Repository) 같이 만듭시다

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)//mariadb auto_increment
	@GeneratedValue(generator = "gen_seq_bo", strategy = GenerationType.SEQUENCE)//oracle/mariadb
	private int bno;
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "CLOB not null")//oracle
	//@Column(columnDefinition = "LONGTEXT not null")//mariadb
	private String content;
	private int readCount;
	private String writer;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(columnDefinition = "timestamp(6)")//mariadb 에서 timestamp 적용
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	//1:n
	//@OneToMany
	//List<ReplyEntity> replies;
}
