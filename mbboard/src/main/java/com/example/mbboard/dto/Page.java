package com.example.mbboard.dto;

import lombok.Data;

@Data
public class Page {
	private int currentPage;
	private int rowPerPage;
	
	private int totalCount;
	private int beginRow;
	
	private String searchWord;
	
	public Page(int currentPage, int rowPerPage) {
		this.rowPerPage = rowPerPage;
		this.currentPage = currentPage;
		this.beginRow = (currentPage-1)*rowPerPage;
	}
	
	public Page(int currentPage, int rowPerPage, String searchWord) {
		this(currentPage, rowPerPage);
		this.searchWord = searchWord;
	}
	
	public Page() {
		this(1,10);
	}
	
	public int getLastPage() {
		int lastPage = this.totalCount / this.rowPerPage;
		if(this.totalCount % this.rowPerPage !=0) {
			lastPage++;
		}
		return lastPage;
	}
}
