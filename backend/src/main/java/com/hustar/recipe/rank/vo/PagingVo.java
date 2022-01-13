package com.hustar.recipe.rank.vo;

import lombok.Data;

@Data
public class PagingVo {
	private int pageSize=12; //한 페이지당 게시글 개수
	private int rangeSize=4; //한 블럭 당 페이지 수
	private int curPage=1; //현재 페이지
	private int curRange=1; //현재 블럭
	private int listCnt; //총 게시글 수
	private int pageCnt; //총 페이지 수
	private int rangCnt; //총 블럭 수
	private int startPage=1; //시작 페이지
	private int endPage=1; //끝 페이지
	private int startIndex=0; //시작 인덱스
	private int prevPage; //이전 페이지
	private int nextPage; //다음 페이지
	
	public PagingVo(int listCnt, int curPage) {
		/*총 게시물 수와 현재 페이지를 controller로 부터 받아옴*/
		setCurPage(curPage); // 현재페이지
		setListCnt(listCnt); // 총 게시물 수
		setPageCnt(listCnt); // 1. 총 페이지 수
		setRangeCnt(pageCnt); // 2. 총 블럭 수
		rangeSetting(curPage);// 3. 블럭 세팅
		setStartIndex(curPage); // DB질의를 위한 startIndex 설정
	}
	public void setPageCnt(int listCnt) {
		this.pageCnt = (int) Math.ceil(listCnt*1.0/pageSize);
	}
	public void setRangeCnt(int pageCnt) {
		this.rangCnt = (int)Math.ceil(pageCnt*1.0/rangeSize);
	}
	public void rangeSetting(int curPage) {
		setCurRange(curPage);
		this.startPage=(curRange-1)*rangeSize+1;
		this.endPage=startPage+rangeSize-1;
		
		if(endPage>pageCnt) {
			this.endPage=pageCnt;
		}
		this.prevPage=curPage-1;
		this.nextPage=curPage+1;
	}
	public void setCurRange(int curPage) {
		this.curRange=(int)((curPage-1)/rangeSize)+1;
	}
	public void setStartIndex(int curPage) {
		this.startIndex=(curPage-1)*pageSize;
	}
	
}
