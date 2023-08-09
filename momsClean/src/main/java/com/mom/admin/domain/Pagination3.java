package com.mom.admin.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Pagination3 {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 10;
	private PageRequest3 pageRequest3;
	
	public void setPageRequest3(PageRequest3 pageRequest3) {
		this.pageRequest3 = pageRequest3;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData() {
		endPage = (int) (Math.ceil(pageRequest3.getPage() / (double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) pageRequest3.getSizePerPage()));
		
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		// 추가된 부분: 레코드 수가 10개 미만인 경우, 총 페이지 수를 1로 설정하여 한 페이지만 표시하도록 함
	    int totalPage = (int) Math.ceil(totalCount / (double) pageRequest3.getSizePerPage());
	    if (totalPage <= 1) {
	        endPage = 1;
	    }
		
		prev = startPage == 1 ? false : true;
		next = endPage * pageRequest3.getSizePerPage() >= totalCount ? false:true;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	public PageRequest3 getPageRequest3() {
		return pageRequest3;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("searchType", pageRequest3.getSearchType())
				.queryParam("keyword", pageRequest3.getKeyword())
				.build();
		
		return uriComponents.toUriString();
	}

}
