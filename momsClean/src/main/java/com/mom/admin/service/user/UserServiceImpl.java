package com.mom.admin.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.PageRequest2;
import com.mom.admin.domain.User;
import com.mom.admin.mapper.user.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;

	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 회원리스트 반환
	@Override
	public List<User> list(PageRequest pageRequest) throws Exception {
		return mapper.list(pageRequest);
	}

	// 회원리스트 전체 건수 반환
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return mapper.count(pageRequest);
	}

	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 탈퇴회원리스트 반환
	@Override
	public List<User> withdraw(PageRequest2 pageRequest2) throws Exception {
		return mapper.withdraw(pageRequest2);
	}

	// 회원리스트 전체 건수 반환
	@Override
	public int count2(PageRequest2 pageRequest2) throws Exception {
		return mapper.count2(pageRequest2);
	}

	// 회원 탈퇴, 복구 페이지
	@Override
	public User read(int userNo) throws Exception {
		return mapper.read(userNo);
	}

	// 회원 탈퇴처리
	@Override
	public void withdraw(User user) throws Exception {
		mapper.withdrawUpdate(user);
	}

	// 회원 복구처리
	@Override
	public void restore(User user) throws Exception {
		mapper.restoreUpdate(user);
	}
}
