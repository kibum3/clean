package com.mom.admin.service.reference;

import java.util.List;

import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.Reference;

public interface ReferenceService {

	public List<Reference> list(PageRequest pageRequest) throws Exception;

	public Reference read(Integer referenceNo) throws Exception;
	
	public void register(Reference reference) throws Exception;
	// 문의 게시글 전체 건수 반환
	public int count(PageRequest pageRequest) throws Exception;
	
	}

