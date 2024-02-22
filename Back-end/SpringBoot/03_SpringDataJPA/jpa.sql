DROP SCHEMA jpa;
CREATE SCHEMA jpa;
USE jpa;
-- DROP TABLE jpa.BOARD;
-- DROP TABLE jpa.MEMBER;

-- 자동생성을 위해선 여기까지만 초기화

CREATE TABLE MEMBER(
    mno	   	INT NOT NULL AUTO_INCREMENT,
    member_id   VARCHAR(20)  NOT NULL unique,
    password    VARCHAR(20) NOT NULL,
    name   		VARCHAR(30),
    address   	TEXT,
    PRIMARY KEY(mno)
);

CREATE TABLE BOARD(
    bno     		INT NOT NULL AUTO_INCREMENT,
	title			VARCHAR(1000),
    content			TEXT,
    read_count		INT DEFAULT 0,
    -- JPA를 위한 표기법 
    member_mno   	INT NOT NULL,
    create_date 	timestamp DEFAULT NOW(),
    PRIMARY KEY(bno),
    FOREIGN KEY(member_mno) REFERENCES MEMBER(mno) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO MEMBER VALUES(0, "test1", "1234", "홍길동", "서울시 강남구 역삼동");
INSERT INTO MEMBER VALUES(0, "test2", "1234", "최길동", "서울시 강남구 논현동");

INSERT INTO BOARD VALUES(0, "게시글1-아이폰12 mini 삽니다.", "게시글1의 내용입니다. 아이폰 사요. 갤럭시 안사요", 0, 1, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글2-갤럭시 플립2 팝니다.", "게시글2의 내용입니다. 갤럭시 팝니다.", 0, 2, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글3-아이폰14 프로 팝니다.", "게시글1의 내용입니다. 애플 아이폰 팝니다.", 0, 1, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글4-맥북 구해요.", "게시글2의 내용입니다. 애플 맥북", 0, 2, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글5-맥북 에어 팝니다.", "게시글1의 내용입니다. 맥북 팝니다.", 0, 1, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글6-아이폰14 삽니다.", "게시글2의 내용입니다. 애플 아이폰 삽니다.", 0, 2, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글7-아이폰13 프로 팝니다.", "게시글1의 내용입니다. 프로 팝니다.", 0, 1, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글8-갤럭시 플립3 삽니다.", "게시글2의 내용입니다. 갤플3삽니다.", 0, 2, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글9-아이폰3s 팝니다.", "게시글1의 내용입니다. 아이폰", 0, 1, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글10-갤럭시 플립4 삽니다.", "게시글2의 내용입니다. 애플", 0, 2, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글12-아이폰12 mini 삽니다.", "게시글1의 내용입니다. 아이폰 사요. 갤럭시 안사요", 0, 1, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글12-갤럭시 플립2 팝니다.", "게시글2의 내용입니다. 갤럭시 팝니다.", 0, 2, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글13-아이폰14 프로 팝니다.", "게시글1의 내용입니다. 애플 아이폰 팝니다.", 0, 1, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글14-맥북 구해요.", "게시글2의 내용입니다. 애플 맥북", 0, 2, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글15-맥북 에어 팝니다.", "게시글1의 내용입니다. 맥북 팝니다.", 0, 1, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글16-아이폰14 삽니다.", "게시글2의 내용입니다. 애플 아이폰 삽니다.", 0, 2, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글17-아이폰13 프로 팝니다.", "게시글1의 내용입니다. 프로 팝니다.", 0, 1, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글18-갤럭시 플립3 삽니다.", "게시글2의 내용입니다. 갤플3삽니다.", 0, 2, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글19-아이폰3s 팝니다.", "게시글1의 내용입니다. 아이폰", 0, 1, DEFAULT);
INSERT INTO BOARD VALUES(0, "게시글20-갤럭시 플립4 삽니다.", "게시글2의 내용입니다. 애플", 0, 2, DEFAULT);


SELECT * FROM MEMBER;
SELECT * FROM BOARD;
SELECT * FROM BOARD B join MEMBER M on B.member_mno = M.mno;


commit;
