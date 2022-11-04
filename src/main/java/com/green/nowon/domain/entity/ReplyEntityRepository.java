package com.green.nowon.domain.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyEntityRepository extends JpaRepository<ReplyEntity, Integer>{

	//쿼리메서드: 쿼리를 생성해주는메서드
	List<ReplyEntity> findByBoardBno(int bno);

}
