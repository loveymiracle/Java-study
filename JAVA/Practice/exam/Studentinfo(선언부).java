package com.multi.exam;

import java.util.Scanner;

public class StudentInfo_lec {
	
	public static void main(String[] args) {
		// 학사정보 관리 프로그램입니다.
		// 학생의 이름, 나이, 주소, 학년, 학점(소수점 까지 관리) 입력 받아주세요.
		// 모든 정보를 입력받으면 출력 하는 기능을 만들어 주세요.
		
		// 선언부 시작 
		String name = null;
		int age = 0;
		String address = null;
		int grade = 1;
		double gpa = 0.0; // 학점
		
		// 선언부 끝 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		
		System.out.println("나이를 입력하세요.");
		age = sc.nextInt();
		
		System.out.println("주소를 입력하세요.");
		address = sc.nextLine();
		
		System.out.println("학년 입력하세요.");
		grade = sc.nextInt();
		
		System.out.println("학점(3.4)을 입력하세요.");
		gpa = sc.nextDouble();
		
		System.out.println("---------학사 정보--------");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + address);
		System.out.println("학년 : " + grade);
		System.out.println("학점 : " + gpa);
		
	}
}
