package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PagingVO {
	private int nowPage;    //현재페이지 
	private int startPage;  //시작페이지
	private int endPage;    //끝페이지 
	private int total;      //게시글 총 수 
	private int cntPerPage; //페이지당 글 갯수 
	private int lastPage;   //마지막페이지 
	private int start;      //sql쿼리 limit 에 쓸  start 
	private int end;        //end 
	
	//생성자
	public PagingVO() {
		
	}

	//생성자
	public PagingVO(int total, int nowPage, int cntPerPage) 
	{
		
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPerPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}
	
	//제일 마지막 페이지 계산
	public void calcLastPage (int total, int cntPerPage) 
	{
		setLastPage(
			(int)Math.ceil(
					(double)total/(double)cntPerPage));
		//ceil:소수점이 나왔을 때 무조건 올림

	}
	
	//시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage, int cntPerPage) 
	{
		setEndPage(
				(int)Math.ceil(
						(double)nowPage/(double)cntPerPage) * cntPerPage);
	
		if(getLastPage() < getEndPage()) 
		{
			setEndPage(getLastPage());
		}
		

		setStartPage(getEndPage() - cntPerPage + 1);
		if(getStartPage() < 1) 
		{
			setStartPage(1);
		}
	}
	
	//DB 쿼리에서 사용할 start, end 값 계산
	//화면에 몇개보여줄지 정하는 메서드
	//오라클에선 end값까지 필요하나
	//mySQL에선 필요하지 않다.
	public void calcStartEnd(int nowPage, int cntPerPage) 
	{
		setEnd(nowPage * cntPerPage); 
		setStart(getEnd() - cntPerPage);
		
	}

//	public int getNowPage() {
//		return nowPage;
//	}
//
//	public void setNowPage(int nowPage) {
//		this.nowPage = nowPage;
//	}
//
//	public int getStartPage() {
//		return startPage;
//	}
//
//	public void setStartPage(int startPage) {
//		this.startPage = startPage;
//	}
//
//	public int getEndPage() {
//		return endPage;
//	}
//
//	public void setEndPage(int endPage) {
//		this.endPage = endPage;
//	}
//
//	public int getTotal() {
//		return total;
//	}
//
//	public void setTotal(int total) {
//		this.total = total;
//	}
//
//	public int getCntPerPage() {
//		return cntPerPage;
//	}
//
//	public void setCntPerPage(int cntPerPage) {
//		this.cntPerPage = cntPerPage;
//	}
//
//	public int getLastPage() {
//		return lastPage;
//	}
//
//	public void setLastPage(int lastPage) {
//		this.lastPage = lastPage;
//	}
//
//	public int getStart() {
//		return start;
//	}
//
//	public void setStart(int start) {
//		this.start = start;
//	}
//
//	public int getEnd() {
//		return end;
//	}
//
//	public void setEnd(int end) {
//		this.end = end;
//	}
	
	
	
}
