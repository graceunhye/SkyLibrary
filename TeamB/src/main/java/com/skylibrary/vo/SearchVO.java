package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchVO {
	private int start;
	private int end;
	private String searchType; //검색옵션
	private String searchText; //검색어
	private String startDate;
	private String endDate;
	private String selectType; //구분옵션
	
}
