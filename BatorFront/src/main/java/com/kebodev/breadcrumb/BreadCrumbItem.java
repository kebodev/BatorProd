package com.kebodev.breadcrumb;

public class BreadCrumbItem {

	
	public final static String SERACH_PAGE = "search.xhtml";
	public final static String SERACH_PAGE_RESULT = "search_result.xhtml";
	
	private String pageName;
	private String pageShowName;
	private int pageIndex;
	
		
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getPageShowNam() {
		return pageShowName;
	}
	public void setPageShowNam(String pageShowNam) {
		this.pageShowName = pageShowNam;
	}
	public BreadCrumbItem(String pageName, String pageShowName, int pageIndex) {
		super();
		this.pageName = pageName;
		this.pageShowName = pageShowName;
		this.pageIndex = pageIndex;
	}
	
	
	
}
