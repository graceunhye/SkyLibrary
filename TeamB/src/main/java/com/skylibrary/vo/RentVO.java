package com.skylibrary.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RentVO extends SessionVO{
	
	private int    rentNo;        //대출번호
    private String userID;        //사용자아이디
	private String bookISBN;      //isbn
	private String rentStartDate; //대출시작일
	private String rentEndDate;   //반납예정일
	private int    compare;       //연장 기준값
	
	public RentVO() throws ParseException {
		setCompare(this.rentStartDate, this.rentEndDate);
	}
	
	public void setCompare(String startDate, String endDate) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date start_d = dateFormat.parse(startDate);
		Date end_d = dateFormat.parse(endDate);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(start_d);
		cal.add(Calendar.DATE,14);
		
		String startd_add = dateFormat.format(cal.getTime());
		Date startadd_d = dateFormat.parse(startd_add);
		
		this.compare = end_d.compareTo(startadd_d);
	}

	public void setRentStartDate(String rentStartDate) {
		String[] array = rentStartDate.split(" ");
		this.rentStartDate = array[0];
	}

	public void setRentEndDate(String rentEndDate) {
		String[] array = rentEndDate.split(" ");
		this.rentEndDate = array[0];
	}
	
	
}
