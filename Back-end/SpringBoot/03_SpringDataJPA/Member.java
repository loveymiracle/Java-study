package com.jpa.model.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA 연동시의 주의점
//1. 대소문자에 대한 규칙이 존재한다. 
//-> DB에서 '_'는 Java에서 카멜 표기법으로 변경된다.
//2. PK는 @Id로 어노테이션을 붙여줘야한다.
//3. 만일 이름을 다르게 사용할 경우는 @Column 어노테이션을 통해 별칭 입력이 필요하다.

// https://bsnippet.tistory.com/38
// https://velog.io/@dhk22/JPA-%EC%96%91%EB%B0%A9%ED%96%A5-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84

// Lombok 어노테이션
@Data
@NoArgsConstructor
@AllArgsConstructor
// JPA 어노테이션
@Entity(name = "Member") // @Entity : 해당 객체가 JPA로 Table과 매핑되어 있음을 알리는 어노테이션
@Transactional // 트랜잭션 처리가 될 수 있도록 선언하는 어노테이션
public class Member {
	
	@Id // PK 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY)// id 자동 생성하는 옵션  AUTO_INCREMENT
	private int mno; // mNo, m_no로 절대 표기하지 말것!! ->Repository 객체에서 문제 발생
	
//	@Column(nmae = "user_id") // 만일 table의 컬럼명과 일치하지 않은 경우 name 옵션 사용!
	@Column(unique = true, nullable = false, length = 20) // 텍스트 길이 20자, null 허용 안함, unique
	private String memberId; // table에서는 member_id로 변경됨
	
	@Column(nullable = false, length = 100)
	private String password;
	
	private String name;
	
	@Column(columnDefinition = "TEXT") // 컬럼 타입을 TEXT로 변환함
	private String address;
	

}
