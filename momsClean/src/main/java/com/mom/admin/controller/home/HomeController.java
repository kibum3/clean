package com.mom.admin.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mom.admin.domain.Home;
import com.mom.admin.domain.PageRequest;
import com.mom.admin.service.home.HomeService;

@Controller

public class HomeController {

	@Autowired
	private HomeService service;

	@GetMapping("/")
	public String list(Home home, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		PageRequest mainPageRequest = new PageRequest();
		mainPageRequest.setSizePerPage(5);
		List<Home> references = service.list(mainPageRequest);
		model.addAttribute("list", references);
		model.addAttribute("request", service.request(mainPageRequest));
		model.addAttribute("review", service.review(mainPageRequest));

		// 예약취소율 통계 카운트 호출
		int requestCount = service.requestCount(home);
		int reserveCount = service.reserveCount(home);
		int cancelCount = service.cancelCount(home);

		// 상품 선택 통계 카운트 호출
		int itemCount1 = service.itemCount1(home);
		int itemCount2 = service.itemCount2(home);
		int itemCount3 = service.itemCount3(home);
		int itemCount4 = service.itemCount4(home);
		int itemCount5 = service.itemCount5(home);
		int itemCount6 = service.itemCount6(home);

		// 월 별 매출액 통계 호출 : 상품매출액, 옵션매출액, 총 매출액, 총 예약수 통계 카운트
		// 1월 통계
		int itemSales1 = service.itemSales1(home);
		int optionSales1 = service.optionSales1(home);
		int totalSales1 = service.totalSales1(home);
		
		Integer monthlyReserveCount1 = service.monthlyReserveCount1(home);

		// 2월 통계
		int itemSales2 = service.itemSales2(home);
		int optionSales2 = service.optionSales2(home);
		int totalSales2 = service.totalSales2(home);
		Integer monthlyReserveCount2 = service.monthlyReserveCount2(home);

		// 3월 통계
		int itemSales3 = service.itemSales3(home);
		int optionSales3 = service.optionSales3(home);
		int totalSales3 = service.totalSales3(home);
		Integer monthlyReserveCount3 = service.monthlyReserveCount3(home);

		// 4월 통계
		int itemSales4 = service.itemSales4(home);
		int optionSales4 = service.optionSales4(home);
		int totalSales4 = service.totalSales4(home);
		Integer monthlyReserveCount4 = service.monthlyReserveCount4(home);

		// 5월 통계
		int itemSales5 = service.itemSales5(home);
		int optionSales5 = service.optionSales5(home);
		int totalSales5 = service.totalSales5(home);
		Integer monthlyReserveCount5 = service.monthlyReserveCount5(home);

		// 6월 통계
		int itemSales6 = service.itemSales6(home);
		int optionSales6 = service.optionSales6(home);
		int totalSales6 = service.totalSales6(home);
		Integer monthlyReserveCount6 = service.monthlyReserveCount6(home);

		// 7월 통계
		int itemSales7 = service.itemSales7(home);
		int optionSales7 = service.optionSales7(home);
		int totalSales7 = service.totalSales7(home);
		Integer monthlyReserveCount7 = service.monthlyReserveCount7(home);

		// 8월 통계
		int itemSales8 = service.itemSales8(home);
		int optionSales8 = service.optionSales8(home);
		int totalSales8 = service.totalSales8(home);
		Integer monthlyReserveCount8 = service.monthlyReserveCount8(home);

		// 9월 통계
		int itemSales9 = service.itemSales9(home);
		int optionSales9 = service.optionSales9(home);
		int totalSales9 = service.totalSales9(home);
		Integer monthlyReserveCount9 = service.monthlyReserveCount9(home);

		// 10월 통계
		int itemSales10 = service.itemSales10(home);
		int optionSales10 = service.optionSales10(home);
		int totalSales10 = service.totalSales10(home);
		Integer monthlyReserveCount10 = service.monthlyReserveCount10(home);

		// 11월 통계
		int itemSales11 = service.itemSales11(home);
		int optionSales11 = service.optionSales11(home);
		int totalSales11 = service.totalSales11(home);
		Integer monthlyReserveCount11 = service.monthlyReserveCount11(home);

		// 12월 통계
		int itemSales12 = service.itemSales12(home);
		int optionSales12 = service.optionSales12(home);
		int totalSales12 = service.totalSales12(home);
		Integer monthlyReserveCount12 = service.monthlyReserveCount12(home);

		// 예약 완료 및 취소 통계의 값을 뷰로 전달
		model.addAttribute("requestCount", requestCount);
		model.addAttribute("reserveCount", reserveCount);
		model.addAttribute("cancelCount", cancelCount);

		// 상품 선택 통계의 값을 뷰로 전달
		model.addAttribute("itemCount1", itemCount1);
		model.addAttribute("itemCount2", itemCount2);
		model.addAttribute("itemCount3", itemCount3);
		model.addAttribute("itemCount4", itemCount4);
		model.addAttribute("itemCount5", itemCount5);
		model.addAttribute("itemCount6", itemCount6);

		// 상품매출액, 옵션매출액, 총 매출액과 총 예약수 전체 건수의 값을 뷰로 전달
		model.addAttribute("itemSales1", itemSales1);
		model.addAttribute("itemSales2", itemSales2);
		model.addAttribute("itemSales3", itemSales3);
		model.addAttribute("itemSales4", itemSales4);
		model.addAttribute("itemSales5", itemSales5);
		model.addAttribute("itemSales6", itemSales6);
		model.addAttribute("itemSales7", itemSales7);
		model.addAttribute("itemSales8", itemSales8);
		model.addAttribute("itemSales9", itemSales9);
		model.addAttribute("itemSales10", itemSales10);
		model.addAttribute("itemSales11", itemSales11);
		model.addAttribute("itemSales12", itemSales12);
		model.addAttribute("optionSales1", optionSales1);
		model.addAttribute("optionSales2", optionSales2);
		model.addAttribute("optionSales3", optionSales3);
		model.addAttribute("optionSales4", optionSales4);
		model.addAttribute("optionSales5", optionSales5);
		model.addAttribute("optionSales6", optionSales6);
		model.addAttribute("optionSales7", optionSales7);
		model.addAttribute("optionSales8", optionSales8);
		model.addAttribute("optionSales9", optionSales9);
		model.addAttribute("optionSales10", optionSales10);
		model.addAttribute("optionSales11", optionSales11);
		model.addAttribute("optionSales12", optionSales12);
		model.addAttribute("totalSales1", totalSales1);
		model.addAttribute("totalSales2", totalSales2);
		model.addAttribute("totalSales3", totalSales3);
		model.addAttribute("totalSales4", totalSales4);
		model.addAttribute("totalSales5", totalSales5);
		model.addAttribute("totalSales6", totalSales6);
		model.addAttribute("totalSales7", totalSales7);
		model.addAttribute("totalSales8", totalSales8);
		model.addAttribute("totalSales9", totalSales9);
		model.addAttribute("totalSales10", totalSales10);
		model.addAttribute("totalSales11", totalSales11);
		model.addAttribute("totalSales12", totalSales12);
		model.addAttribute("monthlyReserveCount1", monthlyReserveCount1);
		model.addAttribute("monthlyReserveCount2", monthlyReserveCount2);
		model.addAttribute("monthlyReserveCount3", monthlyReserveCount3);
		model.addAttribute("monthlyReserveCount4", monthlyReserveCount4);
		model.addAttribute("monthlyReserveCount5", monthlyReserveCount5);
		model.addAttribute("monthlyReserveCount6", monthlyReserveCount6);
		model.addAttribute("monthlyReserveCount7", monthlyReserveCount7);
		model.addAttribute("monthlyReserveCount8", monthlyReserveCount8);
		model.addAttribute("monthlyReserveCount9", monthlyReserveCount9);
		model.addAttribute("monthlyReserveCount10", monthlyReserveCount10);
		model.addAttribute("monthlyReserveCount11", monthlyReserveCount11);
		model.addAttribute("monthlyReserveCount12", monthlyReserveCount12);
		

		return "home";
	}

}
