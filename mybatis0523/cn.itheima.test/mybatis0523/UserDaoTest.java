package mybatis0523;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserDaoImpl;

import cn.itcast.mybatis.pojo.User;
import jdk.jshell.spi.ExecutionControl.ExecutionControlException;

public class UserDaoTest {

	private SqlSessionFactory factory;
	@Before
	public void setUp() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = new UserDaoImpl(factory);
		
		User user = userDao.findUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByUsername() throws Exception{
		UserDao userDao = new UserDaoImpl(factory);
		
		List<User> list = userDao.findUserByUsername("王");
		System.out.println(list);
	}
}
