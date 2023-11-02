// 패키지 명 : 폴더 구분 또는 소스코드 그룹핑 용
package com.multi;

//import  외부 패키지를 가져오는 명령어
//F3을 누르면 위치를 열 수 있다.

import java.util.Date;

// 프로그램 실행 방법 2가지
// 1. run(재생) 버튼
// 2. ctrl + F11(실행) // F11(디버깅)

// 코드가 수정되면 반드시 저장이 필수이다.
// ctrl + s를 누르면 파일이 저장된다.
// 저장하지 않으면 파일 앞에 '*'이 붙는다.

// 주석다는 방법(주석이란? 실행 되지 않는 코드 = 코드를 설명하는 용도로 사용해야하는데, 주석이 길면 좋지 않은 코드이다.
// 학습용으로는 많이 사용하길 권장!
// 1. '//'로 시작하는 방법, 한줄 주석
// 2. '/* */'로 주석의 시작과 끝을 알리는 방법
// 3. 이클립스 주석 다는 단축키 활용 : ctrl + / -> shift로 선택된 범위가 주석이 된다.

// 한줄 주석다는 방법
/* 시작과
 * 끝으로 분리되는 주석 
 */

// Class 이름을 지칭하는 , 'public class'가 파일의 이름과 일치해야 한다.
// ->일치하지 않으면 에러가 발생한다.
public class MyFirstClass {
	// 이름을 바꾸고 싶으면 alt + shift + r 단축키 추천 (win기준)
	
	
	// main : 프로그램의 시작 경로
	// * 주의 : main은 반드시 'public static void main(String[] args)'이어야 한다.
	// class당 하나만 존재할 수 있다.
	
	// 'main'을 입력하고, ctrl + space로 자동완성 된다.
	public static void main(String[] args) {
		// sysout -> System.out.println();로 자동완성 된다.
		System.out.println("Hello Java World!"); // println : 문장을 콘솔화면으로 출력하고, 한줄(line) 띄는 명령
		System.out.print("Hello Java World!"); // print -> 문장을 출력하는 명령, 한줄 안띔!
		System.out.println("Hello Java Wrold!");
		
		// 오류 고치는 방법
		// 1. 마우스로 오류(에러, 빨간줄) 위에 위치하면 이클립스가 자동으로 칩을 준다. -> 해결까지 가능하다.
		// 2. 자동 임포트 활용 : ctrl + shift + o
		System.out.println(new Date());
		
		// 들여쓰기 (indent)
		// - 이클립스에서는 tab(/t)으로 들여쓰기를 표현한다.
		// - java 문법적으로는 들여쓰기가 의미 없지만, 가독성을 위해서 반드시 지켜야하는 암묵적인 룰
		// - 
		
		for(int i = 0 ; i < 10; i++) {
			System.out.println("!!!");
			if(i == 10) {
				System.out.println("@@@@@");
			}
		}
