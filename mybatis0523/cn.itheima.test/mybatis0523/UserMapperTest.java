package mybatis0523;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mapper.UserMapper;

import cn.itcast.mybatis.pojo.CustomOrders;
import cn.itcast.mybatis.pojo.Orders;
import cn.itcast.mybatis.pojo.QueryVo;
import cn.itcast.mybatis.pojo.User;





public class UserMapperTest {
	private SqlSessionFactory factory;
	@Before
	public void setUp() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testFindUserById() {
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(1);
	}
	@Test
	public void testFindUserByVo() {
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("王");
		user.setSex("2");
		
		vo.setUser(user);
		
		List<User> list = mapper.findUserByVo(vo);
		//User user = mapper.find(1);
		System.out.println(list);
		
	}
	@Test
	public void testFindUserCount() throws Exception {
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		
		
		Integer i = mapper.findUserCount();
		//User user = mapper.find(1);
		System.out.println(i);
		
	}
	@Test
	public void testfindUserByUsernameAndSex() {
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("王");
		user.setSex("2");
		
		List<User> list= mapper.findUserByUsernameAndSex(user);
		//User user = mapper.find(1);
		System.out.println(list);
		
	}
	@Test
	public void testfindUserByIds() {
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(16);
		ids.add(28);
		
		vo.setIds(ids);
	
		List<User> list= mapper.findUserByIds(vo);
		//User user = mapper.find(1);
		System.out.println(list);
		
	}
	@Test
	public void testfindOrdersAndUser1() {
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		//CustomOrders customOrders = new CustomOrders();
		List<CustomOrders> list = mapper.findOrdersAndUser1();
		//User user = mapper.find(1);
		System.out.println(list);
		
	}
	@Test
	public void testfindOrdersAndUser2() {
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		//CustomOrders customOrders = new CustomOrders();
		List<Orders> list = mapper.findOrdersAndUser2();
		//User user = mapper.find(1);
		System.out.println(list);
		
	}
}

