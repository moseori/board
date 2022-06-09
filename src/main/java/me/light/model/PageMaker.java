package me.light.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageMaker {
	private Criteria criteria;
	private int startPage;
	private int endPage;
	private int displayPageNum = 10;

	public PageMaker(Criteria criteria) {
		endPage = (int) Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum;
		startPage = endPage - displayPageNum + 1;
	}
}
