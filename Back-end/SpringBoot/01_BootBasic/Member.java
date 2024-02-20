package com.basic.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member{
	private String id;
	private String name;
	private int age;
	private String gender;
	private String address; 
	private String[] devLang; 
}
