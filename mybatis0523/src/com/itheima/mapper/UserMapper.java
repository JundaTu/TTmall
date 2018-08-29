package com.itheima.mapper;

import java.util.List;

import cn.itcast.mybatis.pojo.CustomOrders;
import cn.itcast.mybatis.pojo.Orders;
import cn.itcast.mybatis.pojo.QueryVo;
import cn.itcast.mybatis.pojo.User;

public interface UserMapper {
	
	public User findUserById(Integer id);
	//动态代理形式中，如果返回结果集是list，那么mybatis会在生成实现类的时候
	//会自动调用selectList方法
	public List<User>findUserByUserName(String username);
	
	public void insertUser(User user);
	
	public List<User> findUserByVo(QueryVo vo);
	
	public Integer findUserCount() throws Exception;
	
	public List<User> findUserByUsernameAndSex(User User);
	
	public List<User> findUserByIds(QueryVo vo);
	
	public List<CustomOrders> findOrdersAndUser1();
	
	public List<Orders> findOrdersAndUser2();
}
