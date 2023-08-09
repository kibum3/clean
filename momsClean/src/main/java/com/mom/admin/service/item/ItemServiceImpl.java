package com.mom.admin.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mom.admin.domain.Item;
import com.mom.admin.mapper.item.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper mapper;

	// 상품 등록 처리
	@Override
	public void register(Item item) throws Exception {
		mapper.create(item);
	}

	@Override
	public void optionRegister(Item item) throws Exception {
		mapper.createOption(item);
	}

	// 상품 상세 페이지
	@Override
	public Item read(String itemNo) throws Exception {
		return mapper.read(itemNo);
	}

	// 옵션 상세 페이지
	@Override
	public Item optionRead(String itemName) throws Exception {
		return mapper.optionRead(itemName);
	}

	// 상품 수정 처리
	@Override
	public void modify(Item item) throws Exception {
		mapper.update(item);
	}

	// 옵션 수정 처리
	@Override
	public void optionModify(Item item) throws Exception {
		mapper.updateOption(item);
	}

	// 상품 삭제 처리
	@Override
	public void remove(String itemNo) throws Exception {
		mapper.delete(itemNo);
	}

	// 상품 목록 페이지
	@Override
	public List<Item> list() throws Exception {

		return mapper.list();
	}

	// 옵션 목록 페이지
	@Override
	public List<Item> list2() throws Exception {

		return mapper.list2();
	}

	// 썸네일 이미지 표시
	@Override
	public String getThumb(String itemNo) throws Exception {
		return mapper.getThumb(itemNo);
	}

	// 원본 이미지 표시
	@Override
	public String getPicture(String itemNo) throws Exception {
		return mapper.getPicture(itemNo);
	}
}
