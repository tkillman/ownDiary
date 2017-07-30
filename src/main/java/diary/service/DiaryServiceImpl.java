package diary.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import diary.service.dao.DiaryDao;
import diary.vo.DiaryVo;
import diary.vo.GoalVo;

@Service("DiaryServiceImpl")
public class DiaryServiceImpl {

	@Resource(name="DiaryDao")
	private DiaryDao diaryDao;
	
	/*
	 * 목표 업데이트
	 * 
	 * */
	public int updateGoal(GoalVo goalVo) throws Exception{
		
		goalVo.setSqlid("DiaryDao.updateGoal");
		return diaryDao.updateGoal(goalVo);
	}
	
	
	/*
	 * 목표 조회
	 * 
	 * */
	public GoalVo selectGoal(DiaryVo diaryVo) throws Exception{
		
		diaryVo.setSqlid("DiaryDao.selectGoal");
		return diaryDao.selectGoal(diaryVo);
	}
	
	
	/*
	 * 다이어리 삽입
	 * 
	 * */
	public int insertDiary(DiaryVo diaryVo) throws Exception{
		diaryVo.setSqlid("DiaryDao.insertDiary");
		return diaryDao.insertDiary(diaryVo);
	}
	
	/*
	 * 오늘 날짜 다이어리 갯수 구하기
	 * 
	 * */
	public int countTodayData(DiaryVo diaryVo) throws Exception{
		diaryVo.setSqlid("DiaryDao.countTodayData");
		return diaryDao.countTodayData(diaryVo);
	}
	
	/*
	 * 다이어리 수정
	 * 
	 * */
	public int updateTodayDiary(DiaryVo diaryVo)throws Exception{ 
		diaryVo.setSqlid("DiaryDao.updateTodayDiary");
		return diaryDao.updateTodayDiary(diaryVo);
	}
	
	/*
	 * 오늘 날짜 다이어리 조회
	 * 
	 * */
	public DiaryVo selectTodayDiaryData(DiaryVo diaryVo) throws Exception{
		
		diaryVo.setSqlid("DiaryDao.selectTodayDiaryData");
		
		Date today = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		diaryVo.setToday(sdf.format(today));
		
		return diaryDao.selectTodayDiaryData(diaryVo);
	}
	
	/*
	 * 요청 날짜 다이어리 조회
	 * 
	 * */
	public DiaryVo selectReqDiaryData(DiaryVo diaryVo)throws Exception{
	
		diaryVo.setSqlid("DiaryDao.selectReqDiaryData");
		
		return diaryDao.selectReqDiaryData(diaryVo);
	}
	
	public int updateReqDiary(DiaryVo diaryVo)throws Exception{
		diaryVo.setSqlid("DiaryDao.updateReqDiary");
		
		return diaryDao.updateReqDiary(diaryVo);
	}
}
