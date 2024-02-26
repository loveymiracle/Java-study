package com.jpa.model.vo;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// JPA 관련 어노테이션
@Entity(name = "Board")
@Transactional
@DynamicInsert
@DynamicUpdate
// https://bsnippet.tistory.com/38
// https://velog.io/@dhk22/JPA-%EC%96%91%EB%B0%A9%ED%96%A5-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84
// https://velog.io/@goniieee/JPA-OneToMany-ManyToOne%EC%9C%BC%EB%A1%9C-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84-%EA%B4%80%EB%A6%AC%ED%95%98%EA%B8%B0
public class Board {
//	  bno     		INT NOT NULL AUTO_INCREMENT,
//	  title			VARCHAR(1000),
//    content			TEXT,
//    read_count		INT DEFAULT 0,
//    create_date 	timestamp DEFAULT NOW(),
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bno;
	
	@Column(length = 1000)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	// https://eocoding.tistory.com/71
	@ColumnDefault("0") // default 값을 넣는 방법
	private int readCount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
	// CascadeType : 외래키가 삭제되는 경우 동작하는 제약
	@ManyToOne(cascade = CascadeType.REMOVE)
//	@JoinColumn(name = "mno") 
	// member의 외래키를 mno로 설정하는 방법인데, 만일 Member의 PK가 있는 경우 PK가 자동으로 외래키로 선정됨
	private Member member;
}










