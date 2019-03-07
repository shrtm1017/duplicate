package practice.file.dao;

import org.apache.ibatis.session.SqlSession;

import practice.file.model.fileVo;

public class FileDaoImpl implements IFileDao{

	@Override
	public int insertboardFile(SqlSession openSession, fileVo vo) {
		int insertboardFile = openSession.insert("file.insertboardFile", vo );
		return insertboardFile;
	}

}
