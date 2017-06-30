package com.deilsky.springmvc.utils;

import java.util.List;

public class GridModel {
	private int total;
	private int page;
	private int records;
	private List<?> rows;

	public GridModel(PageModel pageModel) {
		this.total = pageModel.getTotalPage();
		this.page = pageModel.getPage();
		this.records = pageModel.getTotal();
		this.rows = pageModel.getResult();
	}
	public GridModel(List<?> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
