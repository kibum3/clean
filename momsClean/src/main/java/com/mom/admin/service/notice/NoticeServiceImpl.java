package com.mom.admin.service.notice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mom.admin.domain.Notice;
import com.mom.admin.domain.PageRequest;
import com.mom.admin.mapper.notice.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper mapper;

	// 공지사항 등록 처리
	@Override
	public void register(Notice notice) throws Exception {
		mapper.create(notice);
	}
	

	// 공지사항 목록 페이지
	/*
	@Override
	public List<Notice> list() throws Exception {
		return mapper.list();
	}
	*/
	
	//페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 게시글 목록을 반환한다
	
	@Override
	public List<Notice> list(PageRequest pageRequest) throws Exception {

		return mapper.list(pageRequest);
	}
	
	// 공지사항 상세 페이지
	@Override
	public Notice read(int noticeNo) throws Exception {
		return mapper.read(noticeNo);
	}

	// 공지사항 수정 처리
	@Override
	public void modify(Notice notice) throws Exception {
		mapper.update(notice);
	}

	// 공지사항 삭제 처리
	@Override
	public void remove(int noticeNo) throws Exception {
		mapper.delete(noticeNo);
	}
	
	//게시글 전체 건수를 반환한다
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return mapper.count(pageRequest);
	}

}