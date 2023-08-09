package com.mom.admin.service.item;

import java.util.List;

import com.mom.admin.domain.Item;

public interface ItemService {

	// 상품 등록 처리
	public void register(Item item) throws Exception;

	// 상품 등록 처리
	public void optionRegister(Item item) throws Exception;

	// 상품 수정 처리
	public void modify(Item item) throws Exception;

	// 옵션 수정 처리
	public void optionModify(Item item) throws Exception;

	// 상품 삭제 처리
	public void remove(String itemNo) throws Exception;

	// 상품 목록 페이지
	public List<Item> list() throws Exception;

	// 옵션 목록 페이지
	public List<Item> list2() throws Exception;

	// 상품 상세 페이지
	public Item read(String itemNo) throws Exception;

	public Item optionRead(String itemName) throws Exception;

	/* public Integer getINo(String itemName) throws Exception; */

	// 썸네일 이미지
	public String getThumb(String itemNo) throws Exception;

	// 원본 이미지
	public String getPicture(String itemNo) throws Exception;

}
