package com.mom.admin.domain;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Reference {

	private Integer referenceNo;
	private String userName;
	private String userPhone;
	private int userNo;
	private String referenceTitle;
	private String referenceContent;
	private Date referenceDate;
	private int root;
	private Integer step;
	private int indent;
	private Integer no;

}
