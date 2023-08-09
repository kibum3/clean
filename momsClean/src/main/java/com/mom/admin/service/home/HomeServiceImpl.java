package com.mom.admin.service.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mom.admin.domain.Home;
import com.mom.admin.domain.PageRequest;
import com.mom.admin.mapper.home.HomeMapper;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeMapper mapper;

	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 회원리스트 반환
	@Override
	public List<Home> list(PageRequest mainPageRequest) throws Exception {
		return mapper.list(mainPageRequest);
	}

	// 문의 글 전체 건수 반환
	@Override
	public int count(PageRequest mainPageRequest) throws Exception {
		return mapper.count(mainPageRequest);

	}

	@Override
	public List<Home> request(PageRequest mainPageRequest) throws Exception {
		return mapper.request(mainPageRequest);
	}

	@Override
	public List<Home> review(PageRequest mainPageRequest) throws Exception {
		return mapper.review(mainPageRequest);
	}

	// 총 예약대기, 예약완료, 예약취소 전체 건수 반환
	@Override
	public int requestCount(Home home) throws Exception {
		return mapper.requestCount(home);
	}
	
	@Override
	public int reserveCount(Home home) throws Exception {
		return mapper.reserveCount(home);
	}

	@Override
	public int cancelCount(Home home) throws Exception {
		return mapper.cancelCount(home);
	}

	// 상품판매율 통계에 필요한 총 상품 판매율 전체 건수 반환
	// 1번부터 순서대로 A세트~F세트
	public int itemCount1(Home home) throws Exception {
		return mapper.itemCount1(home);
	}

	public int itemCount2(Home home) throws Exception {
		return mapper.itemCount2(home);
	}

	public int itemCount3(Home home) throws Exception {
		return mapper.itemCount3(home);
	}

	public int itemCount4(Home home) throws Exception {
		return mapper.itemCount4(home);
	}

	public int itemCount5(Home home) throws Exception {
		return mapper.itemCount5(home);
	}

	public int itemCount6(Home home) throws Exception {
		return mapper.itemCount6(home);
	}

	// 월 별 매출액 통계에 필요한 상품매출액, 옵션매출액, 총 매출액과 총 예약수 전체 건수 반환
	// 1월 통계
	public int itemSales1(Home home) throws Exception {
		return mapper.itemSales1(home);
	}

	public int optionSales1(Home home) throws Exception {
		return mapper.optionSales1(home);
	}

	public int totalSales1(Home home) throws Exception {
		return mapper.totalSales1(home);
	}

	public Integer monthlyReserveCount1(Home home) throws Exception {
		return mapper.monthlyReserveCount1(home);
	}

	// 2월 통계
	public int itemSales2(Home home) throws Exception {
		return mapper.itemSales2(home);
	}

	public int optionSales2(Home home) throws Exception {
		return mapper.optionSales2(home);
	}

	public int totalSales2(Home home) throws Exception {
		return mapper.totalSales2(home);
	}

	public Integer monthlyReserveCount2(Home home) throws Exception {
		return mapper.monthlyReserveCount2(home);
	}

	// 3월 통계
	public int itemSales3(Home home) throws Exception {
		return mapper.itemSales3(home);
	}

	public int optionSales3(Home home) throws Exception {
		return mapper.optionSales3(home);
	}

	public int totalSales3(Home home) throws Exception {
		return mapper.totalSales3(home);
	}

	public Integer monthlyReserveCount3(Home home) throws Exception {
		return mapper.monthlyReserveCount3(home);
	}

	// 4월 통계
	public int itemSales4(Home home) throws Exception {
		return mapper.itemSales4(home);
	}

	public int optionSales4(Home home) throws Exception {
		return mapper.optionSales4(home);
	}

	public int totalSales4(Home home) throws Exception {
		return mapper.totalSales4(home);
	}

	public Integer monthlyReserveCount4(Home home) throws Exception {
		return mapper.monthlyReserveCount4(home);
	}

	// 5월 통계
	public int itemSales5(Home home) throws Exception {
		return mapper.itemSales5(home);
	}

	public int optionSales5(Home home) throws Exception {
		return mapper.optionSales5(home);
	}

	public int totalSales5(Home home) throws Exception {
		return mapper.totalSales5(home);
	}

	public Integer monthlyReserveCount5(Home home) throws Exception {
		return mapper.monthlyReserveCount5(home);
	}

	// 6월 통계
	public int itemSales6(Home home) throws Exception {
		return mapper.itemSales6(home);
	}

	public int optionSales6(Home home) throws Exception {
		return mapper.optionSales6(home);
	}

	public int totalSales6(Home home) throws Exception {
		return mapper.totalSales6(home);
	}

	public Integer monthlyReserveCount6(Home home) throws Exception {
		return mapper.monthlyReserveCount6(home);
	}

	// 7월 통계
	public int itemSales7(Home home) throws Exception {
		return mapper.itemSales7(home);
	}

	public int optionSales7(Home home) throws Exception {
		return mapper.optionSales7(home);
	}

	public int totalSales7(Home home) throws Exception {
		return mapper.totalSales7(home);
	}

	public Integer monthlyReserveCount7(Home home) throws Exception {
		return mapper.monthlyReserveCount7(home);
	}

	// 8월 통계
	public int itemSales8(Home home) throws Exception {
		return mapper.itemSales8(home);
	}

	public int optionSales8(Home home) throws Exception {
		return mapper.optionSales8(home);
	}

	public int totalSales8(Home home) throws Exception {
		return mapper.totalSales8(home);
	}

	public Integer monthlyReserveCount8(Home home) throws Exception {
		return mapper.monthlyReserveCount8(home);
	}

	// 9월 통계
	public int itemSales9(Home home) throws Exception {
		return mapper.itemSales9(home);
	}

	public int optionSales9(Home home) throws Exception {
		return mapper.optionSales9(home);
	}

	public int totalSales9(Home home) throws Exception {
		return mapper.totalSales9(home);
	}

	public Integer monthlyReserveCount9(Home home) throws Exception {
		return mapper.monthlyReserveCount9(home);
	}

	// 10월 통계
	public int itemSales10(Home home) throws Exception {
		return mapper.itemSales10(home);
	}

	public int optionSales10(Home home) throws Exception {
		return mapper.optionSales10(home);
	}

	public int totalSales10(Home home) throws Exception {
		return mapper.totalSales10(home);
	}

	public Integer monthlyReserveCount10(Home home) throws Exception {
		return mapper.monthlyReserveCount10(home);
	}

	// 11월 통계
	public int itemSales11(Home home) throws Exception {
		return mapper.itemSales11(home);
	}

	public int optionSales11(Home home) throws Exception {
		return mapper.optionSales11(home);
	}

	public int totalSales11(Home home) throws Exception {
		return mapper.totalSales11(home);
	}

	public Integer monthlyReserveCount11(Home home) throws Exception {
		return mapper.monthlyReserveCount11(home);
	}

	// 12월 통계
	public int itemSales12(Home home) throws Exception {
		return mapper.itemSales12(home);
	}

	public int optionSales12(Home home) throws Exception {
		return mapper.optionSales12(home);
	}

	public int totalSales12(Home home) throws Exception {
		return mapper.totalSales12(home);
	}

	public Integer monthlyReserveCount12(Home home) throws Exception {
		return mapper.monthlyReserveCount12(home);
	}
}
