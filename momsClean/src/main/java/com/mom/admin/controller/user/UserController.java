package com.mom.admin.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mom.admin.common.CodeLabelValue;
import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.PageRequest2;
import com.mom.admin.domain.Pagination;
import com.mom.admin.domain.Pagination2;
import com.mom.admin.domain.User;
import com.mom.admin.service.user.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {
	@Autowired
	private UserService service;

	// 회원 리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받고 다시 뷰에 전달
	@GetMapping("/list")
	public void list(@ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		// 뷰에 페이징 처리를 한 회원리스트를 전달한다.
		model.addAttribute("list", service.list(pageRequest));
		

		// 페이징 네비게이션 정보를 뷰에 전달한다.
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);

		// 페이지 네비게이션 정보에 검색 처리된 회원 건수를 저장한다.
		pagination.setTotalCount(service.count(pageRequest));
		model.addAttribute("pagination", pagination);

		// 검색 유형의 코드명과 코드값을 정의한다.
		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("ca", "카테고리"));
		searchTypeCodeValueList.add(new CodeLabelValue("no", "회원번호"));
		searchTypeCodeValueList.add(new CodeLabelValue("id", "아이디"));
		searchTypeCodeValueList.add(new CodeLabelValue("na", "이름"));

		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
	}

	// 회원 탈퇴처리 페이지
	@GetMapping("/modify")
	public String modifyForm(int userNo, Model model)
			throws Exception {
		User user = service.read(userNo);
		model.addAttribute(user);
		return "admin/user/modify";
	}

	// 회원 탈퇴 처리
	@PostMapping("/modify")
	public String modify(User user, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		service.withdraw(user);

		// RedirectAttributes 객체에 일회성 데이터를 지정하여 전달한다.
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());

		return "redirect:/admin/user/list";
	}

	// 탈퇴회원 리스트 페이지
	// 페이징 요청 정보를 매개 변수로 받고 다시 뷰에 전달
	@GetMapping("/withdraw/list")
	public void withdraw(@ModelAttribute("pgrq2") PageRequest2 pageRequest2, Model model) throws Exception {
		// 뷰에 페이징 처리를 한 탈퇴회원 리스트를 전달한다.
		model.addAttribute("withdraw", service.withdraw(pageRequest2));
		
		// 페이징 네비게이션 정보를 뷰에 전달한다.
		Pagination2 pagination2 = new Pagination2();
		pagination2.setPageRequest2(pageRequest2);

		// 페이지 네비게이션 정보에 검색 처리된 탈퇴회원 건수를 저장한다.
		pagination2.setTotalCount(service.count2(pageRequest2));
		model.addAttribute("pagination2", pagination2);

		// 검색 유형의 코드명과 코드값을 정의한다.
		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("ca", "카테고리"));
		searchTypeCodeValueList.add(new CodeLabelValue("no", "회원번호"));
		searchTypeCodeValueList.add(new CodeLabelValue("id", "아이디"));
		searchTypeCodeValueList.add(new CodeLabelValue("na", "이름"));

		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
	}

	// 탈퇴회원 복구처리 페이지
	@GetMapping("/withdraw/modify")
	public String withdrawModifyForm(int userNo, @ModelAttribute("pgrq2") PageRequest2 pageRequest2, Model model)
			throws Exception {
		User user = service.read(userNo);
		model.addAttribute(user);
		return "admin/user/withdraw/modify";
	}

	// 탈퇴회원 복구 처리
	@PostMapping("/withdraw/modify")
	public String withdrawModify(User user, PageRequest2 pageRequest2, RedirectAttributes rttr) throws Exception {
		service.restore(user);

		// RedirectAttributes 객체에 일회성 데이터를 지정하여 전달한다.
		rttr.addAttribute("page", pageRequest2.getPage());
		rttr.addAttribute("sizePerPage", pageRequest2.getSizePerPage());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/user/withdraw/list";
	}
}
