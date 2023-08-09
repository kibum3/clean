package com.mom.admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	
	
	private int userNo;				// 회원번호
	
	private String userId;			// 아이디
	
	private String userPw;			// 비밀번호
	
	private String userName;		// 이름
	
	private String userPhone;		// 핸드폰번호
	
	private String userEmail;		// 이메일
	
	private String emailAuth;		// 이메일인증
	
	private Date regDate;		// 가입일자
	
	private String userDivision;	// 회원구분
	
	private Date withdrawDate;	// 탈퇴일자
	
}
