package practice.file.dao;

import org.apache.ibatis.session.SqlSession;

import practice.file.model.fileVo;

public interface IFileDao {
	int insertboardFile (SqlSession openSession,fileVo vo);
}
