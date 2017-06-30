package com.deilsky.springmvc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deilsky.springmvc.utils.PageModel;

public interface BaseDao<T> {
	// 添加
	void save(T e);

	// 修改
	void updateOrDelete(String sql, ArrayList<Object> param);

	// 删除
	void delete(T e, long id);

	void delete(T e, int id);

	// 根据ID 返回实体
	T getEntity(T e, long id);

	T getEntity(T e, int id);

	T getEntity(String hql, ArrayList<Object> param);

	// 返回实体map
	Map<String, Object> getMap(String sql, ArrayList<Object> param);

	// 根据条件 返回列表
	List<Map<String, Object>> getListMapByConditions(String sql, ArrayList<Object> param);

	List<Map<String, Object>> getListMapByArrayList(String sql, String field, ArrayList<Object> param);

	List<List<Object>> getListListByConditions(String sql, ArrayList<Object> param);

	// 获取实体类
	List<T> getEntityList(String hql, ArrayList<Object> param);

	// 根据条件 查询数量
	long getLongCount(String sql, ArrayList<Object> param);

	// 返回PageModel
	public PageModel getPageModelByConditions(PageModel page, String sql, ArrayList<Object> param);
}
