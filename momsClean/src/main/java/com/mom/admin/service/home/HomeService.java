package com.mom.admin.service.home;

import java.util.List;

import com.mom.admin.domain.Home;
import com.mom.admin.domain.PageRequest;

public interface HomeService {

	public List<Home> list(PageRequest mainPageRequest) throws Exception;

	// 문의 게시글 전체 건수 반환
	public int count(PageRequest mainPageRequest) throws Exception;

	// 예약취소율 통계에 필요한 총 예약대기, 예약완료, 예약취소 전체 건수 반환
	public int requestCount(Home home) throws Exception;
	
	public int reserveCount(Home home) throws Exception;

	public int cancelCount(Home home) throws Exception;

	// 상품 선택 통계에 필요한 총 상품 선택 전체 건수 반환
	public int itemCount1(Home home) throws Exception;

	public int itemCount2(Home home) throws Exception;

	public int itemCount3(Home home) throws Exception;

	public int itemCount4(Home home) throws Exception;

	public int itemCount5(Home home) throws Exception;

	public int itemCount6(Home home) throws Exception;

	// 월 별 매출액 통계에 필요한 상품매출액, 옵션매출액, 총 매출액과 총 예약수 전체 건수 반환
	// 1월 통계
	public int itemSales1(Home home) throws Exception;

	public int optionSales1(Home home) throws Exception;

	public int totalSales1(Home home) throws Exception;

	public Integer monthlyReserveCount1(Home home) throws Exception;

	// 2월 통계
	public int itemSales2(Home home) throws Exception;

	public int optionSales2(Home home) throws Exception;

	public int totalSales2(Home home) throws Exception;

	public Integer monthlyReserveCount2(Home home) throws Exception;

	// 3월 통계
	public int itemSales3(Home home) throws Exception;

	public int optionSales3(Home home) throws Exception;

	public int totalSales3(Home home) throws Exception;

	public Integer monthlyReserveCount3(Home home) throws Exception;

	// 4월 통계
	public int itemSales4(Home home) throws Exception;

	public int optionSales4(Home home) throws Exception;

	public int totalSales4(Home home) throws Exception;

	public Integer monthlyReserveCount4(Home home) throws Exception;

	// 5월 통계
	public int itemSales5(Home home) throws Exception;

	public int optionSales5(Home home) throws Exception;

	public int totalSales5(Home home) throws Exception;

	public Integer monthlyReserveCount5(Home home) throws Exception;

	// 6월 통계
	public int itemSales6(Home home) throws Exception;

	public int optionSales6(Home home) throws Exception;

	public int totalSales6(Home home) throws Exception;

	public Integer monthlyReserveCount6(Home home) throws Exception;

	// 7월 통계
	public int itemSales7(Home home) throws Exception;

	public int optionSales7(Home home) throws Exception;

	public int totalSales7(Home home) throws Exception;

	public Integer monthlyReserveCount7(Home home) throws Exception;

	// 8월 통계
	public int itemSales8(Home home) throws Exception;

	public int optionSales8(Home home) throws Exception;

	public int totalSales8(Home home) throws Exception;

	public Integer monthlyReserveCount8(Home home) throws Exception;

	// 9월 통계
	public int itemSales9(Home home) throws Exception;

	public int optionSales9(Home home) throws Exception;

	public int totalSales9(Home home) throws Exception;

	public Integer monthlyReserveCount9(Home home) throws Exception;

	// 10월 통계
	public int itemSales10(Home home) throws Exception;

	public int optionSales10(Home home) throws Exception;

	public int totalSales10(Home home) throws Exception;

	public Integer monthlyReserveCount10(Home home) throws Exception;

	// 11월 통계
	public int itemSales11(Home home) throws Exception;

	public int optionSales11(Home home) throws Exception;

	public int totalSales11(Home home) throws Exception;

	public Integer monthlyReserveCount11(Home home) throws Exception;

	// 12월 통계
	public int itemSales12(Home home) throws Exception;

	public int optionSales12(Home home) throws Exception;

	public int totalSales12(Home home) throws Exception;

	public Integer monthlyReserveCount12(Home home) throws Exception;

	
	public List<Home> request(PageRequest mainPageRequest) throws Exception;

	public List<Home> review(PageRequest mainPageRequest) throws Exception;

}
