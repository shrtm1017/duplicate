package practice.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import practice.user.dao.IUserDao;
import practice.user.model.UserVo;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource(name="userDao")
	private IUserDao userDao;
	
	public UserServiceImpl(){
		
}
	@Override
	public List<UserVo> userGetAll() {
		List<UserVo> userList = userDao.userGetAll();
		return userList;
	}
	@Override
	public UserVo selectUser(String userId) {
		UserVo user= userDao.selectUser(userId);
		return user;
	}
}
