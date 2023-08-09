package com.mom.admin.domain;





import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item {


	private String itemNo;
	private String itemName;
	private Integer itemPrice;
	private Integer iNo;
	private MultipartFile picture;
	private String itemImg;
	private MultipartFile thumb;
	private String itemImgThumb;

	
	
}
