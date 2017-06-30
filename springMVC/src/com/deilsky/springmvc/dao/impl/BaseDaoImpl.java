package com.deilsky.springmvc.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.deilsky.springmvc.dao.BaseDao;
import com.deilsky.springmvc.utils.PageModel;
import com.deilsky.springmvc.utils.ParamSet;

@Repository
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	// Class<T> clazz;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T e) {
		session().saveOrUpdate(e);
	}

	@Override
	public void updateOrDelete(String sql, ArrayList<Object> param) {
		Query query = session().createSQLQuery(sql);
		ParamSet.setParams(query, param);
		query.executeUpdate();

	}

	@Override
	public void delete(T e, long id) {
		session().delete(session().get(e.getClass(), id));
	}

	@Override
	public void delete(T e, int id) {
		session().delete(session().get(e.getClass(), id));
	}

	@Override
	public T getEntity(T e, long id) {
		return (T) session().get(e.getClass(), id);
	}

	@Override
	public T getEntity(T e, int id) {
		return (T) session().get(e.getClass(), id);
	}

	@Override
	public T getEntity(String hql, ArrayList<Object> param) {
		Query query = session().createQuery(hql);
		ParamSet.setParams(query, param);
		return (T) query.uniqueResult();
	}

	@Override
	public List<Map<String, Object>> getListMapByConditions(String sql, ArrayList<Object> param) {
		Query query = session().createSQLQuery(sql);
		ParamSet.setParams(query, param);
		List<Map<String, Object>> data = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return data;
	}

	@Override
	public List<Map<String, Object>> getListMapByArrayList(String sql, String field, ArrayList<Object> param) {
		Query query = session().createSQLQuery(sql);
		query.setParameterList(field, param);
		List<Map<String, Object>> data = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return data;
	}

	@Override
	public List<T> getEntityList(String hql, ArrayList<Object> param) {
		Query query = session().createQuery(hql);
		ParamSet.setParams(query, param);
		return (List<T>) query.list();
	}

	@Override
	public Map<String, Object> getMap(String sql, ArrayList<Object> param) {
		Query query = session().createSQLQuery(sql.toLowerCase());
		ParamSet.setParams(query, param);
		Map<String, Object> data = (Map<String, Object>) query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
		return data;
	}

	@Override
	public long getLongCount(String sql, ArrayList<Object> param) {
		Query query = session().createSQLQuery(sql);
		ParamSet.setParams(query, param);
		long is = ((BigInteger) query.uniqueResult()).longValue();
		return is;
	}

	@Override
	public List<List<Object>> getListListByConditions(String sql, ArrayList<Object> param) {
		SQLQuery query = session().createSQLQuery(sql);
		ParamSet.setParams(query, param);
		List<List<Object>> data = query.setResultTransformer(Transformers.TO_LIST).list();
		return data;
	}

	@Override
	public PageModel getPageModelByConditions(PageModel page, String sql, ArrayList<Object> param) {
		String _sql = sql.toLowerCase();
		StringBuffer sqlCount = new StringBuffer("select count(0) ");
		int start = _sql.indexOf("from");
		int end = _sql.indexOf("group by") == -1 ? (_sql.indexOf("order by") == -1 ? _sql.length() : _sql.indexOf("order by")) : _sql.length();
		sqlCount.append(_sql.substring(start, end));
		Query querycount = session().createSQLQuery(sqlCount.toString().toLowerCase());
		ParamSet.setParams(querycount, param);
		int total = ((BigInteger) querycount.uniqueResult()).intValue();
		int first = (page.getPage() - 1) * page.getPageSize();
		int max = page.getPageSize();
		Query query = session().createSQLQuery(sql);
		ParamSet.setParams(query, param);
		List<Map<String, String>> result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).setFirstResult(first).setMaxResults(max).list();
		page.setTotal(total);
		page.setResult(result);
		return page;
	}

}
