package com.mom.admin.mapper.review;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mom.admin.domain.Review;
import com.mom.admin.domain.PageRequest;

@Mapper
public interface ReviewMapper {

		//페이징 요청 정보를 매개  변수로 받아 페이징 처리를 한 게시글 목록을 반환한다
		public List<Review> list(PageRequest pageRequest) throws Exception;
		// 리뷰 상세 페이지
		public Review read(int reviewNo) throws Exception;
		// 리뷰 삭제 처리
		public void delete(int reviewNo) throws Exception;
		//게시글 전체 건수를 반환한다
		public int count(PageRequest pageRequest) throws Exception;
}
