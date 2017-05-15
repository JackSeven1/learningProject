/**
 * Created by douqi on 2017/4/25.
 */
package com.seven.ssm.common.dao.impl;
import com.seven.ssm.common.model.ParameterKeyValue;
import org.springframework.stereotype.Repository;
import com.seven.ssm.common.dao.IBaseDao;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

    /**
     * 基础通用数据访问实现类
     *
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    @Repository("baseDao")
    public class BaseDao<T> implements IBaseDao<T> {
        private static Logger log = Logger.getLogger(BaseDao.class);
        @Autowired
        private SessionFactory sessionFactory;

        public SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        @Override
        public Session getCurrentSession() {
            return this.sessionFactory.getCurrentSession();
        }

        /**
         * 添加一个对象,返回该对象的主键ID
         *
         * @param
         * @return 添加对象的主键ID
         */
        @Override
        public Serializable save(T o) {
            return this.getCurrentSession().save(o);
        }

        /**
         * 根据对象类型和主键获取单个对象
         *
         * @param c  对象类型
         * @param id 主键ID
         * @return 符合条件的单个对象
         */
        @SuppressWarnings("unchecked")
        @Override
        public T get(Class<T> c, Serializable id) {
            return (T) this.getCurrentSession().get(c, id);
        }

        /**
         * 通过一个Hql语句获取单个对象(无参)
         *
         * @param hql 待执行的语句
         * @return 符合条件的单个对象
         */
        @SuppressWarnings("unchecked")
        @Override
        public T get(String hql) {
            Query q = this.getCurrentSession().createQuery(hql);
            List<T> l = q.list();
            if (l != null && l.size() > 0) {
                return l.get(0);
            }
            return null;
        }

        /**
         * 通过一个Hql语句获取单个对象(有参)
         *
         * @param hql    待执行的语句
         * @param params 查询参数
         * @return 符合条件的单个对象
         */
        @SuppressWarnings("unchecked")
        @Override
        public T get(String hql, List<ParameterKeyValue> params) {
            Query q = this.getCurrentSession().createQuery(hql);
            setParameters(q, params);
            List<T> l = q.list();
            if (l != null && l.size() > 0) {
                return l.get(0);
            }
            return null;
        }

        /**
         * 根据一个对象,删除指定对象
         *
         * @param
         */
        @Override
        public void delete(T o) {
            this.getCurrentSession().delete(o);
        }

        public void deleteById(Class<T> c, Serializable id) {
            this.delete(this.get(c, id));
        }

        /**
         * 根据一个对象,修改指定对象
         *
         * @param o
         */
        @Override
        public void update(T o) {

            this.getCurrentSession().update(o);
        }

        /**
         * 添加一个对象或根据一个对象,修改指定对象
         *
         * @param o
         */
        @Override
        public void saveOrUpdate(T o) {

            this.getCurrentSession().saveOrUpdate(o);
        }

        /**
         * 通过一个Hql语句查询数据(无参)
         *
         * @param hql 待执行的语句
         * @return 符合条件的数据集
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<T> find(String hql) {
            Query q = this.getCurrentSession().createQuery(hql);
            return q.list();
        }

        /**
         * 通过一个Hql语句查询数据(有参)
         *
         * @param hql    待执行的语句
         * @param params 条件参数
         * @return 符合条件的数据集
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<T> find(String hql, List<ParameterKeyValue> params) {
            Query q = this.getCurrentSession().createQuery(hql);
            setParameters(q, params);
            return q.list();
        }

        /**
         * 分页查找(有参)
         *
         * @param hql    待执行的语句
         * @param params 条件参数
         * @param page   页码
         * @param rows   记录条数
         * @return 符合条件的分页记录集
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<T> find(String hql, List<ParameterKeyValue> params, int page, int rows) {
            Query q = this.getCurrentSession().createQuery(hql);
            setParameters(q, params);
            q.setFirstResult((page - 1) * rows).setMaxResults(rows);
            return q.list();
        }

        @SuppressWarnings("unchecked")
        @Override
        public List<Map<String, Object>> findListMap(String hql, List<ParameterKeyValue> params, int page, int rows) {
            Query q = this.getCurrentSession().createQuery(hql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            if (params != null) {
                setParameters(q, params);
            }
            q.setFirstResult((page - 1) * rows).setMaxResults(rows);
            List<Map<String, Object>> list = q.list();
            return list;
        }

        @Override
        public void deleteAll(Class clazz) {
            String hql = "delete from " + clazz.getName();
            this.executeHql(hql);
        }

        @Override
        public List<T> getAll(Class clazz) {
            return this.find("from " + clazz.getName());
        }

        /**
         * 分页查找(无参)
         *
         * @param hql  待执行的语句
         * @param page 页码
         * @param rows 记录条数
         * @return 符合条件的分页记录集
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<T> find(String hql, int page, int rows) {
            Query q = this.getCurrentSession().createQuery(hql);
            return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
        }

        /**
         * 获取结果的第一行第一列的值,并将值转换为Long(无参)
         *
         * @param hql 待执行的语句
         * @return
         */
        @Override
        public Long uniqueResultToLong(String hql) {
            Query q = this.getCurrentSession().createQuery(hql);
            return (Long) q.uniqueResult();
        }

        /**
         * 获取结果的第一行第一列的值,并将值转换为Long(有参)
         *
         * @param hql    待执行的语句
         * @param params 参数条件
         * @return
         */
        @Override
        public Long uniqueResultToLong(String hql, List<ParameterKeyValue> params) {
            Query q = this.getCurrentSession().createQuery(hql);
            setParameters(q, params);
            return (Long) q.uniqueResult();
        }

        /**
         * 获取结果的第一行第一列的值(无参)
         *
         * @param hql 待执行的语句
         * @return
         */
        @Override
        public Object uniqueResult(String hql) {
            Query q = this.getCurrentSession().createQuery(hql);
            return q.uniqueResult();
        }

        /**
         * 获取结果的第一行第一列的值(有参)
         *
         * @param hql    待执行的语句
         * @param params 参数条件
         * @return
         */
        @Override
        public Object uniqueResult(String hql, List<ParameterKeyValue> params) {
            Query q = this.getCurrentSession().createQuery(hql);
            setParameters(q, params);
            return q.uniqueResult();
        }

        /**
         * 执行一条HQL(无参)
         *
         * @param hql 待执行的语句
         * @return 影响行数
         */
        @Override
        public int executeHql(String hql) {
            Query q = this.getCurrentSession().createQuery(hql);
            return q.executeUpdate();
        }

        /**
         * 执行一条HQL(有参)
         *
         * @param hql    待执行的语句
         * @param params 条件参数
         * @return 影响行数
         */
        @Override
        public int executeHql(String hql, List<ParameterKeyValue> params) {
            Query q = this.getCurrentSession().createQuery(hql);
            setParameters(q, params);
            return q.executeUpdate();
        }

        /**
         * 有参查询方法通用参数设置方法
         *
         * @param q      Query对象
         * @param params 参数集合
         */
        private void setParameters(Query q, List<ParameterKeyValue> params) {
            if (params != null && params.size() > 0) {
                for (ParameterKeyValue pKayValue : params) {
                    q.setParameter(pKayValue.getKey(), pKayValue.getValue());
                }
            }
        }

        private void setParameters(Query q, ParameterKeyValue[] params) {
            if (params != null && params.length > 0) {
                for (ParameterKeyValue pKayValue : params) {
                    q.setParameter(pKayValue.getKey(), pKayValue.getValue());
                }
            }
        }

        /**
         * 执行一条HQL(where in语句)
         * <p/>
         * in(:此处填写StrArr)
         *
         * @param hql    待执行的语句
         * @param StrArr 条件in参数
         * @return 影响行数
         */
        @Override
        public int executeHqlWhereIn(String hql, String[] StrArr) {
            Query q = this.getCurrentSession().createQuery(hql);
            return q.setParameterList("StrArr", StrArr).executeUpdate();
        }

        @Override
        public List<T> executeHqlWhereInQuery(String hql, String[] StrArr) {
            Query q = this.getCurrentSession().createQuery(hql);
            return q.setParameterList("StrArr", StrArr).list();
        }

        /**
         * 执行原生SQL
         *
         * @param c         泛型类型
         * @param sqlStr    原生SQL语句
         * @param pageIndex 页数
         * @param pageSize  行数
         * @return 泛型结果
         */
        @Override
        public <V> List<V> execSQL(Class<V> c, String sqlStr, int pageIndex, int pageSize) {
            return this.getSessionFactory().getCurrentSession().createSQLQuery(sqlStr).setResultTransformer(Transformers.aliasToBean(c)).setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
        }

        /**
         * 执行原生SQL
         *
         * @param c         泛型类型
         * @param sqlStr    原生SQL语句
         * @param params    参数
         * @param pageIndex 页数
         * @param pageSize  行数
         * @return 泛型结果
         */
        @Override
        public <V> List<V> execSQL(Class<V> c, String sqlStr, List<ParameterKeyValue> params, int pageIndex, int pageSize) {
            Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sqlStr);
            setParameters(query, params);
            return query.setResultTransformer(Transformers.aliasToBean(c)).setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
        }

        /**
         * 执行原生SQL 返回List结果集
         *
         * @param c      泛型类型
         * @param sqlStr 原生SQL语句
         * @return 泛型结果
         */
        @Override
        public <V> List<V> execSQL(Class<V> c, String sqlStr) {
            return this.getSessionFactory().getCurrentSession().createSQLQuery(sqlStr).setResultTransformer(Transformers.aliasToBean(c)).list();

        }

        @Override
        public <V> List<V> execSQL(Class<V> c, String sqlStr, List<ParameterKeyValue> params) {
            Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sqlStr);
            setParameters(query, params);
            return query.setResultTransformer(Transformers.aliasToBean(c)).list();
        }


        public <V> V getBySQL(Class<V> c, String sqlStr, List<ParameterKeyValue> params) {
            Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sqlStr);
            setParameters(query, params);
            List<V> list = query.setResultTransformer(Transformers.aliasToBean(c)).list();
            if (list.size() != 0) {
                return list.get(0);
            } else {
                return null;
            }

        }


        @Override
        public <V> List<V> findSqlWhereIn(Class<V> c, String sql, String[] StrArr) {
            Query q = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
            return q.setParameterList("StrArr", StrArr).setResultTransformer(Transformers.aliasToBean(c)).list();
        }

        /**
         * 执行SQL 返回一条数据的SQL 用于查询总行数
         *
         * @param sqlStr
         * @return 唯一结果
         */
        @Override
        public long sqlUniqueResult(String sqlStr) {
            Object tota = this.getSessionFactory().getCurrentSession().createSQLQuery(sqlStr).uniqueResult();
            return Long.valueOf(String.valueOf(tota)).longValue();

        }

        @Override
        public int sqlUpdate(String sql, List<ParameterKeyValue> params) {
            Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
            setParameters(query, params);
            int result = query.executeUpdate();
            return result;
        }

        /**
         * 执行SQL 返回一条数据的SQL 用于查询总行数
         *
         * @param sqlStr
         * @return 唯一结果
         */
        @Override
        public long sqlUniqueResult(String sqlStr, List<ParameterKeyValue> params) {
            Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sqlStr);
            setParameters(query, params);
            Object tota = query.uniqueResult();
            return Long.valueOf(String.valueOf(tota)).longValue();

        }

        /**
         * 执行SQL 返回一条数据的SQL
         *
         * @param sqlStr
         * @return 唯一结果
         */
        @Override
        public Object execSqlUniqueResult(String sqlStr, List<ParameterKeyValue> params) {
            Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sqlStr);
            setParameters(query, params);
            Object result = query.uniqueResult();
            return result;

        }

        /**
         * 执行更新 返回受影响行数
         */
        @Override
        public int execSqlNoQuery(String sqlStr, List<ParameterKeyValue> params) {
            Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sqlStr);
            setParameters(query, params);
            int result = query.executeUpdate();
            return result;

        }

        @Override
        public int execSqlNoQuery(String sqlString) {
            Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sqlString);
            return query.executeUpdate();
        }

	/*
     * 导入数据
	 */

        /**
         * 导入数据集合
         *
         * @param tArr 数据集合
         */
        @Override
        public void saveImport(T[] tArr) {
            for (T item : tArr) {
                this.save(item);
            }
        }

        @Override
        public CallableStatement getResultByProcedure(final String sql, final List<Object> params, final List<Map<String, Integer>> resultParam) {
            return this.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<CallableStatement>() {
                @Override
                public CallableStatement execute(Connection connection) throws SQLException {
                    CallableStatement stmt = connection.prepareCall(sql);
                    if (params != null) {
                        int idx = 1;
                        for (Object obj : params) {
                            if (obj != null) {
                                stmt.setObject(idx, obj);
                            } else {
                                stmt.setNull(idx, Types.NULL);
                            }
                            idx++;
                        }
                    }
                    if (resultParam != null) {
                        for (Map<String, Integer> map : resultParam) {
                            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                                stmt.registerOutParameter(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    stmt.execute();
                    return stmt;
                }
            });
        }

        @Override
        public T findById(Class clazz, Serializable id) {
            return (T) this.getSessionFactory().getCurrentSession().get(clazz, id);
        }

    }



