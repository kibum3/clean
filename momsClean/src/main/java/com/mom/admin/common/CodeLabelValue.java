package com.mom.admin.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor // final 필드의 생성자 자동생성
@Getter
@Setter
@ToString
public class CodeLabelValue {

	private final String value;
	private final String label;
}
