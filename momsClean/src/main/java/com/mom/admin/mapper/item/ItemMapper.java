package com.mom.admin.mapper.item;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mom.admin.domain.Item;

@Mapper
public interface ItemMapper {

	// 상품 등록 처리
	public void create(Item item) throws Exception;

	// 상품 등록 처리
	public void createOption(Item item) throws Exception;

	// 상품 상세 페이지
	public Item read(String itemNo) throws Exception;

	public Item optionRead(String itemName) throws Exception;

	// 상품 수정 페이지
	public void update(Item item) throws Exception;

	// 옵션 수정 페이지
	public void updateOption(Item item) throws Exception;

	// 상품 삭제 처리
	public void delete(String itemNo) throws Exception;

	// 상품 목록 페이지
	public List<Item> list() throws Exception;

	// 옵션 목록 페이지
	public List<Item> list2() throws Exception;

	// 원본 이미지 표시
	public String getPicture(String itemNo) throws Exception;

	// 썸네일 이미지 표시
	public String getThumb(String itemNo) throws Exception;
}
