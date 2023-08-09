package com.mom.admin.controller.reference;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mom.admin.common.CodeLabelValue;
import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.Pagination;
import com.mom.admin.domain.Reference;
import com.mom.admin.service.reference.ReferenceService;

@Controller
@RequestMapping("/admin/reference")
public class ReferenceController {

	@Autowired
	private ReferenceService service;

	// 회원 리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받고 다시 뷰에 전달
	@GetMapping("/list")
	public void list(@ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		model.addAttribute("list", service.list(pageRequest));

		// 페이징 네비게이션 정보를 뷰에 전달한다.
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);

		// 페이지 네비게이션 정보에 검색 처리된 문의 게시글 건수를 저장한다.
		pagination.setTotalCount(service.count(pageRequest));

		model.addAttribute("pagination", pagination);

		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("ca", "카테고리"));
		searchTypeCodeValueList.add(new CodeLabelValue("n", "게시글 번호"));
		searchTypeCodeValueList.add(new CodeLabelValue("t", "글 제목"));
		searchTypeCodeValueList.add(new CodeLabelValue("r", "작성자"));

		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
	}

	// 상세 페이지
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(Integer referenceNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		Reference reference = service.read(referenceNo);

		model.addAttribute(reference);
	}
	
	// 답글 작성 페이지 
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public void registerForm(Model model, Integer referenceNo) throws Exception {
		Reference reference = service.read(referenceNo);
		
		model.addAttribute("reference",reference);
		
		
	}

	// 답글 등록 처리

	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public String register(@ModelAttribute Reference reference, RedirectAttributes rttr) throws Exception {
		
		service.register(reference);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/reference/list";
	}
}


