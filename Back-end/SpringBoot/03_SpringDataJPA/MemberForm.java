package com.jpa.model.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// validation을 써서 회원정보 데이터의 유효성을 확보하는 기능
// https://velog.io/@_koiil/SpringBoot-Spring-Validation%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%9C%A0%ED%9A%A8%EC%84%B1-%EA%B2%80%EC%A6%9D

//	@Null  // null만 허용합니다.
//	@NotNull  // null을 허용하지 않습니다. "", " "는 허용합니다.
//	@NotEmpty  // null, ""을 허용하지 않습니다. " "는 허용합니다.
//	@NotBlank  // null, "", " " 모두 허용하지 않습니다.
//
//	@Email  // 이메일 형식을 검사합니다. 다만 ""의 경우를 통과 시킵니다
//	@Pattern(regexp = )  // 정규식을 검사할 때 사용됩니다.
//	@Size(min=, max=)  // 길이를 제한할 때 사용됩니다.
//
//	@Max(value = )  // value 이하의 값을 받을 때 사용됩니다.
//	@Min(value = )  // value 이상의 값을 받을 때 사용됩니다.
//
//	@Positive  // 값을 양수로 제한합니다.
//	@PositiveOrZero  // 값을 양수와 0만 가능하도록 제한합니다.
//
//	@Negative  // 값을 음수로 제한합니다.
//	@NegativeOrZero  // 값을 음수와 0만 가능하도록 제한합니다.
//
//	@Future  // 현재보다 미래
//	@Past  // 현재보다 과거
//
//	@AssertFalse  // false 여부, null은 체크하지 않습니다.
//	@AssertTrue  // true 여부, null은 체크하지 않습니다.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberForm {
	private int mno; 
	@NotBlank(message = "id가 유효하지 않습니다.")
	@Size(min = 4, max = 20, message = "id는 4글자 이상, 20글자 미만으로 입력 바랍니다.")
	private String memberId; 
	
	@NotBlank(message = "pw가 유효하지 않습니다.")
	@Size(min = 4, max = 20, message = "비밀번호는 4글자 이상, 20글자 미만으로 입력 바랍니다.")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,20}$", message = "영문과 일부 특수문자만 활용 가능합니다. 영문과 특수문자 1글자 이상 입력 바랍니다.")
	private String password;
	
	@NotBlank(message = "이름이 유효하지 않습니다.")
	@Size(max = 20, min =  2, message = "이름은 2글자 이상, 20글자 미만 입력바랍니다.")
	private String name;
	
	@NotBlank(message = "주소가 유효하지 않습니다.")
	@Size(max = 100, min =  10, message = "주소는 10글자 이상, 100글자 미만 입력바랍니다.")
	private String address;
	
	public Member toMember() {
		return new Member(mno, memberId, password, name, address);
	}
}



