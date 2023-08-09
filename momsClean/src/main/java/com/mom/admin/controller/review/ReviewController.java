package com.mom.admin.controller.review;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mom.admin.common.domain.CodeLabelValue;
import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.Pagination;
import com.mom.admin.domain.Review;
import com.mom.admin.service.review.ReviewService;

@Controller
@RequestMapping("/admin/review")
public class ReviewController {

	@Autowired
	private ReviewService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		// 뷰에 페이징 처리를 한 게시글 목록을 전달한다
		model.addAttribute("list", service.list(pageRequest));

		// 페이징 네비게이션 정보를 뷰에 전달한다
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);

		// 페이지 네비게이션 정보에 검색 처리된 게시글 건수를 저장한다.
		// pagination.setTotalCount(service.count());
		pagination.setTotalCount(service.count(pageRequest));

		model.addAttribute("pagination", pagination);

		// 검색 유형의 코드명과 코드값을 정의한다.

		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("c", "글 내용"));

		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);

	}

	// 리뷰게시판 상세 페이지, 페이징 요청 정보를 매개변수로 받고 다시 뷰에 전달한다
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(int reviewNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		// 조회한 게시글 상세 정보를 뷰에 전달한다
		Review review = service.read(reviewNo);

		model.addAttribute(review);
	}

	// 리뷰 삭제 처리
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(int reviewNo, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		service.remove(reviewNo);

		// RedirectAttributes 객체에 일회성 데이터를 지정하여 전달한다
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/review/list";

	}

}
