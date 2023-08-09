package com.mom.admin.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mom.admin.domain.Review;
import com.mom.admin.domain.PageRequest;
import com.mom.admin.mapper.review.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper mapper;

	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 게시글 목록을 반환한다

	@Override
	public List<Review> list(PageRequest pageRequest) throws Exception {

		return mapper.list(pageRequest);
	}

	// 리뷰 상세 페이지
	@Override
	public Review read(int reviewNo) throws Exception {
		return mapper.read(reviewNo);
	}
	
	// 리뷰 삭제 처리
		@Override
		public void remove(int reviewNo) throws Exception {
			mapper.delete(reviewNo);
		}

	// 게시글 전체 건수를 반환한다
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return mapper.count(pageRequest);
	}
}
