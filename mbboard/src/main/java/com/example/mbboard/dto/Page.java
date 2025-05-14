package com.example.mbboard.dto;

import lombok.Data;

@Data
public class Page {
	private int currentPage;
	private int rowPerPage;
	
	private int totalCount;
	private int beginRow;
	
	private String searchWord;
	
	/*  Controller에서 기본값 설정후 리스트 출력하는 방식
	 * 
	 * public Page(int currentPage, int rowPerPage, int totalCount, String searchWord){
	 * 		this.rowPerPage = rowPerPage;
			this.currentPage = currentPage;
			this.totalCount = totalCount;
			this.searchWord = searchWord;
			this.beginRow = (currentPage-1)*rowPerPage;
	 * }
	 * 
	 */
	public Page(int currentPage, int rowPerPage, String searchWord) {
		this.rowPerPage = rowPerPage;
		this.currentPage = currentPage;
		this.beginRow = (currentPage-1)*rowPerPage;
		this.searchWord = searchWord;
	}
	
	public Page() {
		this(1,10,"");
	}
	
	public int getLastPage() {
		int lastPage = this.totalCount / this.rowPerPage;
		if(this.totalCount % this.rowPerPage !=0) {
			lastPage++;
		}
		return lastPage;
	}
}
