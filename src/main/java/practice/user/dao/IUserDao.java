package practice.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import practice.user.model.UserVo;

public interface IUserDao {
	
	public List<UserVo> userGetAll(SqlSession openSession);
	UserVo selectUser(SqlSession openSession,String userId);
}
