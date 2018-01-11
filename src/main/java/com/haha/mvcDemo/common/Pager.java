package com.haha.mvcDemo.common;

import java.util.List;

/**
 * 分页对象
 * @author dell
 *
 * @param <T>
 */
public class Pager<T> {
	@Override
	public String toString() {
		return "Pager [records=" + records + ", pageSize=" + pageSize
				+ ", pageNum=" + pageIndex + ", totalPage=" + totalPage
				+ ", startIndex=" + startIndex + ", totalRecords="
				+ totalRecords + ", startPage=" + startPage + ", endPage="
				+ endPage + ", servletUrl=" + servletUrl + "]";
	}

	private List<T> records;
	private int pageSize = 10;//每页显示的记录条数
	private int pageIndex;//用户要看的页码即当前页码
	private int totalPage;//总页数
	private int startIndex;//每页开始记录的索引
	private int totalRecords;//总记录条数
	
	//显示的页码
	private int startPage=1;
	private int endPage;
	
	//查询数据时的Servlet的URL
	private String servletUrl;
	
	
	public void prePager(){
		this.totalPage = (int)Math.ceil((this.totalRecords*1.0)/this.pageSize);
		this.endPage = this.totalPage;
	}
	
	
	
	public Pager(int pageSize, int totalNum, int pageIndex){
		this.pageSize=pageSize;
		this.totalRecords = totalNum;
		this.pageIndex = pageIndex;
		this.prePager();
	}
	
	
	public void prePager2(int pageSize,int totalNum,int pageIndex){
		this.pageSize=pageSize;
		this.totalRecords = totalNum;
		this.pageIndex = pageIndex;
		this.prePager();
	}
	
	
	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getpageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int gettotalPage() {
		return totalPage;
	}

	public void settotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int gettotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getServletUrl() {
		return servletUrl;
	}

	public void setServletUrl(String servletUrl) {
		this.servletUrl = servletUrl;
	}

	public Pager() {
		super();
	}

	
	
	

}
