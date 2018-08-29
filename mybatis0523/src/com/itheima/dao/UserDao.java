package com.itheima.dao;

import java.util.List;

import cn.itcast.mybatis.pojo.User;

public interface UserDao {
	public User findUserById(Integer id);
	
	public List<User> findUserByUsername(String username);
}
