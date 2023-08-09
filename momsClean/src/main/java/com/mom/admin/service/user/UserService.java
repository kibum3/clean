package com.mom.admin.service.user;

import java.util.List;

import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.PageRequest2;
import com.mom.admin.domain.User;

public interface UserService {

	// 회원리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 회원리스트 반환
	public List<User> list(PageRequest pageRequest) throws Exception;

	// 회원리스트 전체 건수 반환
	public int count(PageRequest pageRequest) throws Exception;

	// 탈퇴회원리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 탈퇴회원리스트 반환
	public List<User> withdraw(PageRequest2 pageRequest2) throws Exception;

	// 탈퇴회원리스트 전체 건수 반환
	public int count2(PageRequest2 pageRequest2) throws Exception;

	// 회원 탈퇴, 복구 페이지
	public User read(int userNo) throws Exception;

	// 회원 탈퇴처리
	public void withdraw(User user) throws Exception;

	// 회원 복구처리
	public void restore(User user) throws Exception;
}
