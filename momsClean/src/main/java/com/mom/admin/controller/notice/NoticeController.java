package com.mom.admin.controller.notice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mom.admin.common.domain.CodeLabelValue;
import com.mom.admin.domain.Notice;
import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.Pagination;
import com.mom.admin.service.notice.NoticeService;

@Controller
@RequestMapping("/admin/notice")
public class NoticeController {

	@Autowired
	private NoticeService service;

	// 공지사항 등록 페이지
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Model model) throws Exception {
		Notice notice = new Notice();

		model.addAttribute(notice);
	}

	// 공지사항 등록 처리

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Notice notice, RedirectAttributes rttr) throws Exception {
		service.register(notice);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/notice/list";
	}

	// 공지사항 목록 페이지
	/*
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.list());
	}
	*/
	
	// 페이징 요청 정보를 매개 변수로 받고 다시 뷰에 전달한다
	
	 @RequestMapping(value = "/list", method = RequestMethod.GET) 
	 public void list(@ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception { 
	//뷰에 페이징 처리를 한 게시글 목록을 전달한다 
		 model.addAttribute("list", service.list(pageRequest));
	 
	 //페이징 네비게이션 정보를 뷰에 전달한다 
	 Pagination pagination = new Pagination();
	 pagination.setPageRequest(pageRequest);

		// 페이지 네비게이션 정보에 검색 처리된 게시글 건수를 저장한다.
		//pagination.setTotalCount(service.count());
		pagination.setTotalCount(service.count(pageRequest));
		
		model.addAttribute("pagination", pagination);
		
		// 검색 유형의 코드명과 코드값을 정의한다.
		
		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("t", "글 제목"));
		

		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
	 
	 }
	 

	// 공지사항 상세 페이지, 페이징 요청 정보를 매개변수로 받고 다시 뷰에 전달한다
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(int noticeNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		//조회한 게시글 상세 정보를 뷰에 전달한다
		Notice notice = service.read(noticeNo);
		
		model.addAttribute(notice);
	}

	// 공지사항 수정 페이지, 페이징 요청 정보를 매개변수로 받고 다시 뷰에 전달한다
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(int noticeNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		//조회한 게시글 상세 정보를 뷰에 전달한다
		Notice notice = service.read(noticeNo);
		
		model.addAttribute(notice);
	}

	// 공지사항 수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Notice notice,PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		service.modify(notice);
		
		//RedirectAttributes 객체에 일회성 데이터를 지정하여 전달한다
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
		
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/notice/list";
	}

	// 공지사항 삭제 처리
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(int noticeNo, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		service.remove(noticeNo);

		//RedirectAttributes 객체에 일회성 데이터를 지정하여 전달한다
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
				
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/notice/list";

	}
}
