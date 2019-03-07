package practice.file.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import practice.db.mybatis.MybatisSqlSessionFactoy;
import practice.file.dao.FileDaoImpl;
import practice.file.dao.IFileDao;
import practice.file.model.fileVo;

public class FileSerivceImpl implements IFileSerivce{
	private IFileDao fileDao;
	 public FileSerivceImpl() {
		 fileDao = new FileDaoImpl();
	
}
	@Override
	public int insertBoard(fileVo vo) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		int fileVo= fileDao.insertboardFile(sqlSession, vo);
		sqlSession.commit();
		sqlSession.close();
		return fileVo;
	}

}
