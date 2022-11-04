package com.green.nowon;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.nowon.domain.entity.BoardEntity;
import com.green.nowon.domain.entity.BoardEntityRepository;
import com.green.nowon.domain.entity.ReplyEntity;
import com.green.nowon.domain.entity.ReplyEntityRepository;

@SpringBootTest
class SpringWebRdaJpa02ApplicationTests {
	@Autowired
	BoardEntityRepository repository;
	
	@Autowired
	ReplyEntityRepository replyEntityRepository;
	
	//@Test
	void 댓글생성() {
		//ReplyEntity e1=new ReplyEntity(0, null, null, null, null);
		//int bno=105;
		ReplyEntity e2=ReplyEntity.builder()
				.text("번의 댓글입니다.2").writer("작성자2")
				//.board(BoardEntity.builder().bno(bno).build())//fk 객체의 pk
				.build();
		replyEntityRepository.save(e2);
	}
	
	//@Test
	void 더미() {
		IntStream.rangeClosed(1, 100).forEach(i->{
			repository.save(BoardEntity.builder()
					.title("제목"+i).content("내용"+i)
					.build());
		});
		
	}
	//@Test
	void contextLoads() {
		
		repository.save(BoardEntity.builder()
				.title("제목02").content("내용02")
				.build());
	}
	
	//@Test
	void 삭제() {
		repository.deleteById(2);
	}
	
	//@Test
	void 게시글_상세페이지() {
		int bno=103;
		BoardEntity result=repository.findById(bno).orElseThrow();
		System.out.println(result);
		System.out.println(">>>>>>>>>댓글");
		List<ReplyEntity> replyResult=replyEntityRepository.findByBoardBno(bno);
		for(ReplyEntity r: replyResult) {
			System.out.println(r);
		}
	}
	
	@Transactional
	@Test
	void 게시글_상세페이지2() {
		int bno=103;
		BoardEntity result=repository.findById(bno).orElseThrow();
		System.out.println(result);
		
		result.getReplies().forEach(System.out::println);
		
	}

}
