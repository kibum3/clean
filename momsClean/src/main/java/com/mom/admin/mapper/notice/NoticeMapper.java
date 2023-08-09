package com.mom.admin.mapper.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mom.admin.domain.Notice;
import com.mom.admin.domain.PageRequest;

@Mapper
public interface NoticeMapper {
	// 공지사항 등록 처리
	public void create(Notice notice) throws Exception;
	// 공지사항 목록 페이지
	//public List<Notice> list() throws Exception;
	//페이징 요청 정보를 매개  변수로 받아 페이징 처리를 한 게시글 목록을 반환한다
	public List<Notice> list(PageRequest pageRequest) throws Exception;
	// 공지사항 상세 페이지
	public Notice read(int noticeNo) throws Exception;
	// 공지사항 수정 처리
	public void update(Notice notice) throws Exception;
	// 공지사항 삭제 처리
	public void delete(int noticeNo) throws Exception;
	//게시글 전체 건수를 반환한다
	public int count(PageRequest pageRequest) throws Exception;
}
