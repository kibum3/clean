package com.mom.admin.service.reserve;

import java.util.List;

import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.PageRequest2;
import com.mom.admin.domain.PageRequest3;
import com.mom.admin.domain.Reserve;

public interface ReserveService {

	// 승인요청리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 승인요청리스트 반환
	public List<Reserve> request(PageRequest pageRequest) throws Exception;

	// 승인요청리스트 전체 건수 반환
	public int count() throws Exception;

	// 예약완료리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 승인요청리스트 반환
	public List<Reserve> complete(PageRequest2 pageRequest2) throws Exception;

	// 예약완료리스트 전체 건수 반환
	public int count2(PageRequest2 pageRequest2) throws Exception;

	// 예약취소리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 승인요청리스트 반환
	public List<Reserve> cancel(PageRequest3 pageRequest3) throws Exception;

	// 예약취소리스트 전체 건수 반환
	public int count3(PageRequest3 pageRequest3) throws Exception;

	// 예약 상세페이지
	public Reserve read(String reserveNo) throws Exception;

	// 예약요청 승인처리
	public void requestModify(Reserve reserve) throws Exception;

	// 예약완료 청소완료처리
	public void finishModify(Reserve reserve) throws Exception;

	// 예약완료 청소완료처리
	public void finishModify2(Reserve reserve) throws Exception;

	// 예약완료 복구처리
	public void completeModify(Reserve reserve) throws Exception;

	// 취소완료 복구처리
	public void cancelModify(Reserve reserve) throws Exception;
}
