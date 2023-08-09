package com.mom.admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Review {

	private int reviewNo; 			// 번호
	private String reserveNo; 		// 예약번호
	private int userNo; 			// 회원번호
	private int reviewGrade; 		// 평점
	private String reviewContent; 	// 글내용
	private Date reviewDate; 		// 작성일
}
