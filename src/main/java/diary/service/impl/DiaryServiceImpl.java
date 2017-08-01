package diary.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import diary.service.DiaryService;
import diary.service.dao.DiaryDAO;
import diary.vo.DbVo;
import diary.vo.DiaryVo;

@Service("DiaryService")
public class DiaryServiceImpl implements DiaryService{

	@Resource(name="DiaryDAO")
	private DiaryDAO diaryDAO;

	@Override
	public Long diaryInsert(DiaryVo diaryVo) throws Exception {
		int month = diaryVo.getMonth() +1;
		
		String year_month= Integer.toString(diaryVo.getYear())+"_"+Integer.toString(month);
		
		for(int i=0;i<diaryVo.getDbVoList().size();i++) {
			DbVo dbvo = diaryVo.getDbVoList().get(i);
			dbvo.setYear_month(year_month);
			dbvo.setSqlid("DiaryDao.diaryInsert");
			
			diaryDAO.diaryInsert(dbvo);
		}
		
		
		
		return null;
	}
	
	
	
}
