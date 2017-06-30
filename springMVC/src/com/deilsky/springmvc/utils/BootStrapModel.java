package com.deilsky.springmvc.utils;

import java.util.List;

public class BootStrapModel {
	private int		total;
	private List<?>	rows;
	private int		pageSize;

	public BootStrapModel(PageModel pageModel) {
		this.total = pageModel.getTotal();
		this.rows = pageModel.getResult();
		this.pageSize = pageModel.getPageSize();
	}

	public BootStrapModel(List<?> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	

}
