package com.mom.admin.mapper.reference;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mom.admin.domain.PageRequest;
import com.mom.admin.domain.Reference;

@Mapper
public interface ReferenceMapper {

	public List<Reference> list(PageRequest pageRequest) throws Exception;
	
	public Reference read(Integer referenceNo) throws Exception;

	// 회원리스트 전체 건수 반환
	public int count(PageRequest pageRequest) throws Exception;
	
	public void create(Reference reference) throws Exception;
	
}
