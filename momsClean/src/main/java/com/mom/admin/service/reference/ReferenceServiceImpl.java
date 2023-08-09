package com.mom.admin.service.reference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.Reference;
import com.mom.admin.mapper.reference.ReferenceMapper;

@Service
public class ReferenceServiceImpl implements ReferenceService {
	
	@Autowired
	private ReferenceMapper mapper;


	 //페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 회원리스트 반환
	@Override
	public List<Reference> list(PageRequest pageRequest) throws Exception{
		return mapper.list(pageRequest);
	}
	
	// 상세 페이지
	public Reference read(Integer referenceNo) throws Exception{
		return mapper.read(referenceNo);
	}
	// 문의 글 전체 건수 반환
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return mapper.count(pageRequest);
	}
	
	@Override
	public void register(Reference reference) throws Exception {
		 mapper.create(reference);
	}
	

}
