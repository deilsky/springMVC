package com.deilsky.springmvc.utils;

import java.util.List;

public class PageModel {

	private static int			DEFAULT_PAGE_SIZE	= 10;

	public static final String	ASC					= "asc";

	public static final String	DESC				= "desc";

	protected List<?>			result;

	protected int				page;

	protected int				pageSize			= DEFAULT_PAGE_SIZE;

	protected String			orderBy;

	protected String			order;

	protected int				total;

	public PageModel() {

	}

	public PageModel(Integer page, int pageSize) {
		page = (page == null || page == 0) ? 1 : page;
		this.page = page;
		this.pageSize = pageSize;
	}

	public PageModel(int offset, int limit) {
		int _offset = offset == 0 ? 1 : (offset / limit) + 1;
		this.page = _offset;
		this.pageSize = limit;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		if (total % pageSize == 0)
			return total / pageSize;
		else
			return total / pageSize + 1;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public java.lang.String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(java.lang.String orderBy) {
		this.orderBy = orderBy;
	}

	public java.lang.String getOrder() {
		return order;
	}

	public void setOrder(java.lang.String order) {
		this.order = order;
	}

}
