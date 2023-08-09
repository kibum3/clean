package com.mom.admin.mapper.reserve;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.PageRequest2;
import com.mom.admin.domain.PageRequest3;
import com.mom.admin.domain.Reserve;

@Mapper
public interface ReserveMapper {

	// 승인요청리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 승인요청리스트 반환
	public List<Reserve> request(PageRequest pageRequest) throws Exception;

	// 승인요청리스트 전체 건수 반환
	public int count() throws Exception;

	// 예약완료리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 예약완료리스트 반환
	public List<Reserve> complete(PageRequest2 pageRequest2) throws Exception;

	// 예약완료리스트 전체 건수 반환
	public int count2(PageRequest2 pageRequest2) throws Exception;

	// 예약취소리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 예약취소리스트 반환
	public List<Reserve> cancel(PageRequest3 pageRequest3) throws Exception;

	// 예약취소리스트 전체 건수 반환
	public int count3(PageRequest3 pageRequest3) throws Exception;

	// 예약 상세페이지
	public Reserve read(String reserveNo) throws Exception;

	// 예약요청 승인처리
	public void requestApproval(Reserve reserve) throws Exception;

	// 취소요청 승인처리
	public void cancelApproval(Reserve reserve) throws Exception;

	// 예약요청 청소완료처리
	public void finishUpdate(Reserve reserve) throws Exception;

	// 예약요청 청소완료 취소처리
	public void finishCancel(Reserve reserve) throws Exception;

	// 예약요청 복구처리
	public void completeRestore(Reserve reserve) throws Exception;

	// 취소요청 복구처리
	public void cancelRestore(Reserve reserve) throws Exception;

}
