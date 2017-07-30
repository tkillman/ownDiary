package diary.service.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import diary.vo.DiaryVo;
import diary.vo.GoalVo;

@Repository("DiaryDao")
public class DiaryDao extends SqlSessionDaoSupport{

	public int updateGoal(GoalVo goalVo) throws Exception{
		
		return (int)getSqlSession().update(goalVo.getSqlid(),goalVo);
	}
	
	public GoalVo selectGoal(DiaryVo diaryVo) throws Exception{
		
		return (GoalVo) getSqlSession().selectOne(diaryVo.getSqlid(), diaryVo);
	}

	public int insertDiary(DiaryVo diaryVo) throws Exception{
		return (int) getSqlSession().insert(diaryVo.getSqlid(), diaryVo);
	}
	
	public int countTodayData(DiaryVo diaryVo) throws Exception{
		return (int) getSqlSession().selectOne(diaryVo.getSqlid(), diaryVo);
	}
	
	public int updateTodayDiary(DiaryVo diaryVo) throws Exception{
		return (int) getSqlSession().update(diaryVo.getSqlid(), diaryVo);
	}
	
	public DiaryVo  selectTodayDiaryData(DiaryVo diaryVo) throws Exception{
		
		return (DiaryVo) getSqlSession().selectOne(diaryVo.getSqlid(), diaryVo);
	}
	
	
	public DiaryVo selectReqDiaryData(DiaryVo diaryVo)throws Exception{	
		return (DiaryVo) getSqlSession().selectOne(diaryVo.getSqlid(), diaryVo);
	}
	
	public int updateReqDiary(DiaryVo diaryVo)throws Exception{	
		return (int) getSqlSession().update(diaryVo.getSqlid(), diaryVo);
	}
	
	public int selectDataCount(DiaryVo diaryVo) {
		return (int)getSqlSession().selectOne(diaryVo.getSqlid(), diaryVo);
	}
	
	
}
