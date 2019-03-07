package practice.user.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import practice.db.mybatis.MybatisSqlSessionFactoy;
import practice.user.dao.IUserDao;
import practice.user.dao.UserDaoImpl;
import practice.user.model.UserVo;


public class UserServiceImpl implements IUserService {
	private IUserDao userDao;
	public UserServiceImpl(){
		userDao = new UserDaoImpl();
}
	@Override
	public List<UserVo> userGetAll() {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		List<UserVo> userList = userDao.userGetAll(sqlSession);
		sqlSession.close();
		return userList;
	}
	@Override
	public UserVo selectUser(String userId) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		UserVo user= userDao.selectUser(sqlSession, userId);
		sqlSession.close();
		return user;
	}
}
