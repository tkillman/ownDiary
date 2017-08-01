package diary.service.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import diary.vo.DbVo;
import diary.vo.DiaryVo;

public class DiaryDAO extends SqlSessionDaoSupport{

	public int diaryInsert(DbVo dbvo) throws Exception{
		return getSqlSession().insert(dbvo.getSqlid(), dbvo);
	}
	
	
	public List<DbVo> selectDataList(DiaryVo diaryVo) throws Exception{
		return getSqlSession().selectList(diaryVo.getSqlid(), diaryVo);
	}
	
	public int deleteData(DiaryVo diaryVo) throws Exception{
		return getSqlSession().delete(diaryVo.getSqlid(), diaryVo);
	}
}
