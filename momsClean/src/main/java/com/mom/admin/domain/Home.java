package com.mom.admin.domain;

import java.lang.reflect.Field;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Home {
	
	private int referenceNo;
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
	private int rNo;
	private String reserveNo;
	private String userId;
	private String itemNo;
	private String reserveItemName;
	private int reserveItemPrice;
	private String reserveOptionName;
	private int reserveOptionPrice;
	private String reserveState;
	private String reserveAddr;
	private Date reserveDate;
	private Date cleanDate;
	private Date cancelDate;
	private String reserveRequest;
	private String cleanDone;
	private int reviewNo;
	private int reviewGrade;	
	private String reviewContent;
	private Date reviewDate;
	
	// 예약취소율 통계 카운트
	private int requestCount;
	private int reserveCount;
	private int cancelCount;
	
	// 상품 및 옵션 선택 통계 카운트
	private int itemCount1;
	private int itemCount2;
	private int itemCount3;
	private int itemCount4;
	private int itemCount5;
	private int itemCount6;
	
	// 월 별 매출액 통계 : 상품매출, 옵션매출, 총 매출, 총 예약수
	private int itemSales1;
	private int itemSales2;
	private int itemSales3;
	private int itemSales4;
	private int itemSales5;
	private int itemSales6;
	private int itemSales7;
	private int itemSales8;
	private int itemSales9;
	private int itemSales10;
	private int itemSales11;
	private int itemSales12;
	
	private int optionSales1;
	private int optionSales2;
	private int optionSales3;
	private int optionSales4;
	private int optionSales5;
	private int optionSales6;
	private int optionSales7;
	private int optionSales8;
	private int optionSales9;
	private int optionSales10;
	private int optionSales11;
	private int optionSales12;
	
	private int totalSales1;
	private int totalSales2;
	private int totalSales3;
	private int totalSales4;
	private int totalSales5;
	private int totalSales6;
	private int totalSales7;
	private int totalSales8;
	private int totalSales9;
	private int totalSales10;
	private int totalSales11;
	private int totalSales12;
	
	private Integer monthlyReserveCount1;
	private Integer monthlyReserveCount2;
	private Integer monthlyReserveCount3;
	private Integer monthlyReserveCount4;
	private Integer monthlyReserveCount5;
	private Integer monthlyReserveCount6;
	private Integer monthlyReserveCount7;
	private Integer monthlyReserveCount8;
	private Integer monthlyReserveCount9;
	private Integer monthlyReserveCount10;
	private Integer monthlyReserveCount11;
	private Integer monthlyReserveCount12;
	
	public void initializeCountsToZero() {
        Field[] fields = Home.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == Integer.class) {
                field.setAccessible(true);
                try {
                    Integer value = (Integer) field.get(this);
                    if (value == null) {
                        field.set(this, 0);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
