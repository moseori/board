package me.light.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageMaker {
	private Criteria criteria;
	private int startPage;
	private int endPage;
	private int tempEndPage;
	private int totalCount;
	
	private int displayPageNum = 10;

	private boolean prev;
	private boolean next;

	public PageMaker(Criteria criteria, int totalCount) {
		
		endPage = (int) Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum;
		startPage = endPage - displayPageNum + 1;
		tempEndPage = (int) Math.ceil(totalCount / (double) criteria.getPerPageNum());
		if (endPage > tempEndPage) endPage = tempEndPage;

		prev = startPage != 1;
		next = endPage < tempEndPage;
	}
}
