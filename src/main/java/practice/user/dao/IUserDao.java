package practice.user.dao;

import java.util.List;

import practice.user.model.UserVo;

public interface IUserDao {
	
	public List<UserVo> userGetAll();
	UserVo selectUser(String userId);
}
