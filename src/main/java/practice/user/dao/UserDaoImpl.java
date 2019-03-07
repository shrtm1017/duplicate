package practice.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import practice.user.model.UserVo;


public class UserDaoImpl implements IUserDao {

	@Override
	public List<UserVo> userGetAll(SqlSession openSession) {
		List<UserVo> userList = openSession.selectList("user.getAllUser");
		return userList;
	}

	@Override
	public UserVo selectUser(SqlSession openSession,String userId) {
		UserVo user= openSession.selectOne("user.selectUser",userId);
		return user;
	}

}
