package lxy.demo.transaction.dao;


import java.util.List;
import java.util.Map;

import lxy.demo.transaction.bean.Api_user;


/**
 * 
 * author : zyk
 * comments:用户表（手表，手机）数据读取接口 
 * create date:2016-08-23 17:23:18
 */
public interface IApi_userDao {

    /**
     * 单条插入 用户表（手表，手机） 数据
     * @param user
     * @return 插入数据 影响行数
     */
    public int insert(Api_user api_user);

    /**
     * 单条插入 用户表（手表，手机） 数据 生成主键id，赋值到实体
     * @param user
     * @return 插入数据 影响行数
     */
    public int insertSetId(Api_user api_user);

    /**
     * 批量插入 用户表（手表，手机） 数据
     * @param users
     * @return 插入数据 影响行数
     */
    public int insertList(List<Api_user> api_users);


    /**
     * 单条更新 用户表（手表，手机） 数据
     * @param user
     * @return 更新数据 影响行数
     */
    public int update(Api_user api_user);

    /**
     * 批量更新 用户表（手表，手机） 数据
     * @param users
     * @return 更新数据 影响行数
     */
    public int updateList(List<Api_user> api_users);


    /**
     * 根据主键删除 用户表（手表，手机） 数据
     * @param id 主键id
     * @return 删除数据 影响行数
     */
    public int delete(int id);

    /**
     * 根据查询条件删除 用户表（手表，手机） 数据
     * @param params 查询条件
     * @return 删除数据 影响行数
     */
    public int deleteByParam(Map<String, Object> params);


    /**
     * 根据主键查询 用户表（手表，手机） 数据
     * @param id 
     * @return 查询到的用户表（手表，手机）数据
     */
    public Api_user load(int id);

    /**
     * 根据条件查询 用户表（手表，手机） 数据
     * @param params
     * @return 查询到的用户表（手表，手机）数据
     */
    public Api_user loadByParam(Map<String, Object> params);


    /**
     * 不分页查询全部 用户表（手表，手机） 数据
     * @return 查询到的列表数据 不分页
     */
    public List<Api_user> list();

    /**
     * 不分页根据条件查询 用户表（手表，手机） 数据
     * @param params
     * @return 查询到的列表数据 不分页
     */
    public List<Api_user> listByParam(Map<String, Object> params);


    /**
     * 根据查询条件分页查询 用户表（手表，手机） 数据
     * @return 查询到的列表数据 分页
     */
    public List<Api_user> find(Map<String, Object> params);

    /**
     * 查询满足条件的 用户表（手表，手机）数据的记录数
     * @param params
     * @return 满足条件的记录数
     */
    public int findCount(Map<String, Object> params);

    /***
     * 是否有效小记者
     * 
     *   `user_status` tinyint(4) DEFAULT '1' COMMENT '用户状态:1正常，2：停用',
  		`ispay` int(11) DEFAULT '0' COMMENT '是否支付小记者年费  0=否  1=是',
  		 `dueDate` datetime DEFAULT NULL COMMENT '小记者年费到期日期',
     * 
     * */
    public int isReporter(Map<String, Object> params) ;
    
    /***
     * 更新用户表的 money
     * 
     * */
    public void updateMoney(Map<String, Object> params);
    
}
