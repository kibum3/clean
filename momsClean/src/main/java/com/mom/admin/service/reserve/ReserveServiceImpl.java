package com.mom.admin.service.reserve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.PageRequest2;
import com.mom.admin.domain.PageRequest3;
import com.mom.admin.domain.Reserve;
import com.mom.admin.mapper.reserve.ReserveMapper;

@Service
public class ReserveServiceImpl implements ReserveService {
	@Autowired
	private ReserveMapper mapper;

	// 승인요청리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 승인요청리스트 반환
	@Override
	public List<Reserve> request(PageRequest pageRequest) throws Exception {
		return mapper.request(pageRequest);
	}

	// 승인요청리스트 전체 건수 반환
	@Override
	public int count() throws Exception {
		return mapper.count();
	}

	// 예약완료리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 승인요청리스트 반환
	@Override
	public List<Reserve> complete(PageRequest2 pageRequest2) throws Exception {
		return mapper.complete(pageRequest2);
	}

	// 예약완료리스트 전체 건수 반환
	@Override
	public int count2(PageRequest2 pageRequest2) throws Exception {
		return mapper.count2(pageRequest2);
	}

	// 예약취소리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 승인요청리스트 반환
	@Override
	public List<Reserve> cancel(PageRequest3 pageRequest3) throws Exception {
		return mapper.cancel(pageRequest3);
	}

	// 예약취소리스트 전체 건수 반환
	@Override
	public int count3(PageRequest3 pageRequest3) throws Exception {
		return mapper.count3(pageRequest3);
	}

	// 예약 상세페이지
	@Override
	public Reserve read(String reserveNo) throws Exception {
		return mapper.read(reserveNo);
	}

	// 예약요청 승인처리
	@Override
	public void requestModify(Reserve reserve) throws Exception {
		mapper.cancelApproval(reserve);
		mapper.requestApproval(reserve);
	}

	// 예약완료 청소완료처리
	@Override
	public void finishModify(Reserve reserve) throws Exception {
		mapper.finishUpdate(reserve);

	}

	// 예약완료 청소완료처리
	@Override
	public void finishModify2(Reserve reserve) throws Exception {

		mapper.finishCancel(reserve);
	}

	// 예약완료 복구처리
	@Override
	public void completeModify(Reserve reserve) throws Exception {
		mapper.completeRestore(reserve);
	}

	// 취소완료 복구처리
	@Override
	public void cancelModify(Reserve reserve) throws Exception {
		mapper.cancelRestore(reserve);
	}
}
