package practice.user.service;

import java.util.List;

import practice.user.model.UserVo;

public interface IUserService {
	public List<UserVo> userGetAll();
	UserVo selectUser(String userId);
}
