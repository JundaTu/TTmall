package com.itheima.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(Integer id) {
		SqlSession openSession = sqlSessionFactory.openSession();
		User user = openSession.selectOne("test.findUserById", id);
		return user;
	}

	@Override
	public List<User> findUserByUsername(String username) {
		SqlSession openSession = sqlSessionFactory.openSession();
		List<User> list = openSession.selectList("test.findUserByUserName", username);
		return list;
	}
	
	
}
