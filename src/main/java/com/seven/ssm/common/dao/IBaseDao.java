package com.seven.ssm.common.dao;
import com.seven.ssm.common.model.ParameterKeyValue;
import org.hibernate.Session;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.util.List;
import java.util.Map;

/**
 * 基础通用数据访问接口类
 *
 *
 * @param <T>
 *            类类型
 */
public interface IBaseDao<T> {
    Session getCurrentSession();

    /**
     * 添加一个对象,返回该对象的主键ID
     *
     * @param
     * @return 添加对象的主键ID
     */
    public Serializable save(T o);

    /**
     * 根据一个对象,删除指定对象
     *
     * @param
     */
    public void delete(T o);

    /**
     * 根据对象类型和主键值，删除对象
     *
     * @param c
     *            对象类型
     * @param id
     *            主键值
     * ***/
   public void deleteById(Class<T> c, Serializable id);

    /**
     * 根据一个对象,修改指定对象
     *
     * @param o
     */
    public void update(T o);

    /**
     * 添加一个对象或根据一个对象,修改指定对象
     *
     * @param o
     */
    public void saveOrUpdate(T o);

    /**
     * 根据对象类型和主键获取单个对象
     *
     * @param c
     *            对象类型
     * @param id
     *            主键ID
     * @return 符合条件的单个对象
     */
    public T get(Class<T> c, Serializable id);

    /**
     * 通过一个Hql语句获取单个对象(无参)
     *
     * @param hql
     *            待执行的语句
     * @return 符合条件的单个对象
     */
    public T get(String hql);

    /**
     * 通过一个Hql语句获取单个对象(有参)
     *
     * @param hql
     *            待执行的语句
     * @param params
     *            查询参数
     * @return 符合条件的单个对象
     */
    public T get(String hql, List<ParameterKeyValue> params);

    /**
     * 通过一个Hql语句查询数据(无参)
     *
     * @param hql
     *            待执行的语句
     * @return 符合条件的数据集
     */
    public List<T> find(String hql);

    /**
     * 通过一个Hql语句查询数据(有参)
     *
     * @param hql
     *            待执行的语句
     * @param params
     *            条件参数
     * @return 符合条件的数据集
     */
    public List<T> find(String hql, List<ParameterKeyValue> params);

    /**
     * 分页查找(无参)
     *
     * @param hql
     *            待执行的语句
     * @param page
     *            页码
     * @param rows
     *            记录条数
     * @return 符合条件的分页记录集
     */
    public List<T> find(String hql, int page, int rows);

    /**
     * 分页查找(有参)
     *
     * @param hql
     *            待执行的语句
     * @param params
     *            条件参数
     * @param page
     *            页码
     * @param rows
     *            记录条数
     * @return 符合条件的分页记录集
     */
    public List<T> find(String hql, List<ParameterKeyValue> params, int page, int rows);

    /**
     * 获取记录条数(无参)
     *
     * @param hql
     *            待执行的语句
     * @return 记录条数
     */
    public Long uniqueResultToLong(String hql);

    /**
     * 获取记录条数(有参)
     *
     * @param hql
     *            待执行的语句
     * @param params
     *            参数条件
     * @return 符合条件的记录条数
     */
    public Long uniqueResultToLong(String hql, List<ParameterKeyValue> params);

    /**
     * 执行一条HQL(无参)
     *
     * @param hql
     *            待执行的语句
     * @return 影响行数
     */
    public int executeHql(String hql);

    /**
     * 执行一条HQL(有参)
     *
     * @param hql
     *            待执行的语句
     * @param params
     *            条件参数
     * @return 影响行数
     */
    public int executeHql(String hql, List<ParameterKeyValue> params);

    /**
     * 执行一条HQL(where in 语句)
     *
     * @param hql
     *            待执行的语句
     * @param params
     *            条件参数
     * @return 影响行数
     */

    /**
     * 执行一条HQL(where in 语句)
     *
     * @param hql
     *            待执行的语句
     * @param StrArr
     *            条件参数
     * @return 影响行数
     *
     */
    public int executeHqlWhereIn(String hql, String[] StrArr);

    public List<T> executeHqlWhereInQuery(String hql, String[] StrArr);



    /**
     * 执行原生SQL 用于分页查询
     *
     * @param c
     *            泛型类型
     * @param sqlStr
     *            原生SQL语句
     * @param pageIndex
     *            页数
     * @param pageSize
     *            行数
     * @return 泛型结果
     */
    public <V> List<V> execSQL(Class<V> c, String sqlStr, int pageIndex, int pageSize);

    /**
     * 执行原生SQL 返回List结果集
     *
     * @param c
     *            泛型类型
     * @param sqlStr
     *            原生SQL语句
     * @return 泛型结果
     */
    public <V> List<V> execSQL(Class<V> c, String sqlStr);

    /**
     * 执行SQL 返回一条数据的SQL 用于查询总行数
     *
     * @param sqlStr
     * @return 唯一结果
     */
    public long sqlUniqueResult(String sqlStr);

    /**
     * 带参数的原生sql执行语句
     * @param sql
     * @param params
     * @return
     */
    public int sqlUpdate(String sql, List<ParameterKeyValue> params);

    <V> List<V> execSQL(Class<V> c, String sqlStr, List<ParameterKeyValue> params);

    public <V> List<V> execSQL(Class<V> c, String sqlStr, List<ParameterKeyValue> params, int pageIndex, int pageSize);

    long sqlUniqueResult(String sqlStr, List<ParameterKeyValue> params);

    Object execSqlUniqueResult(String sqlStr, List<ParameterKeyValue> params);

    int execSqlNoQuery(String sqlStr, List<ParameterKeyValue> params);

    <V> List<V> findSqlWhereIn(Class<V> c, String sql, String[] StrArr);

    int execSqlNoQuery(String sqlString);

    Object uniqueResult(String hql);

    Object uniqueResult(String hql, List<ParameterKeyValue> params);

	/*
	 * 导入数据
	 */
    /**
     * 导入数据集合
     *
     * @param tArr
     *            数据集合
     */
    void saveImport(T[] tArr);

    /**
     * @author zhangbowen
     * @param sql 调用事物语句 call xxx(?,?,?) 问号对应传递进procedure的参数和procedure返回的参数，如传递2个参数，返回1个参数，需写3个问号
     * @param params 传递的参数(自定义事物时填写的) 与语句中的问号对应 List<Object> params: params.add("paramName");
     * @param resultPram 事物返回的参数(自定义事物填写的) Map<String,Integer>: map.put("paramName",Types.Integer);Types为sql中的类，指定返回类型
     * @return 返回Statement 取数据 sta.getInt("XXX");
     */
    public CallableStatement getResultByProcedure(String sql, List<Object> params, List<Map<String, Integer>> resultPram);

    public T findById(Class clazz, Serializable id);

    public List<Map<String,Object>> findListMap(String hql, List<ParameterKeyValue> params, int page, int rows);

    public void deleteAll(Class clazz);

    public List<T> getAll(Class clazz);
}