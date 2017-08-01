package diary.service.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import diary.vo.DbVo;

public class DiaryDAO extends SqlSessionDaoSupport{

	public int diaryInsert(DbVo dbvo) throws Exception{
		
		return getSqlSession().insert(dbvo.getSqlid(), dbvo);
	}
	
}
