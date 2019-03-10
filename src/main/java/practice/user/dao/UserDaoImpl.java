package practice.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import practice.user.model.UserVo;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<UserVo> userGetAll() {
		List<UserVo> userList = sqlSessionTemplate.selectList("user.getAllUser");
		return userList;
	}

	@Override
	public UserVo selectUser(String userId) {
		UserVo user= sqlSessionTemplate.selectOne("user.selectUser",userId);
		return user;
	}

}
