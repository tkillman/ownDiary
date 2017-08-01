package diary.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public int diaryInsert(DiaryVo diaryVo) throws Exception {
		int resultNum = 0;
		
		int month = diaryVo.getMonth() +1;
		
		String year_month= Integer.toString(diaryVo.getYear())+"-"+Integer.toString(month);
		
		for(int i=0;i<diaryVo.getDbVoList().size();i++) {
			DbVo dbvo = diaryVo.getDbVoList().get(i);
			dbvo.setYear_month(year_month);
			dbvo.setSqlid("DiaryDao.diaryInsert");
			
			diaryDAO.diaryInsert(dbvo);
			resultNum++;
		}
		
		return resultNum;
	}

	@Override
	public List<DbVo> selectDbVoList(DiaryVo diaryVo) throws Exception {
		
		diaryVo.setSqlid("DiaryDao.selectDbVoList");
		
		int month = diaryVo.getMonth() +1;
		String searchValue= Integer.toString(diaryVo.getYear())+"-"+Integer.toString(month); 
		diaryVo.setSearchValue(searchValue);
		
		
		return diaryDAO.selectDataList(diaryVo);
	}

	@Override
	public int diaryDelete(DiaryVo diaryVo) throws Exception {
	
		diaryVo.setSqlid("DiaryDao.diaryDelete");
		int month = diaryVo.getMonth() +1;
		String searchValue= Integer.toString(diaryVo.getYear())+"-"+Integer.toString(month);
		diaryVo.setSearchValue(searchValue);
		
		return diaryDAO.deleteData(diaryVo);
	}

	@Override
	public List<DbVo> dumpList() throws Exception {
		
		List<DbVo> dbVoList = new ArrayList<>();
		for(int i=0;i<32;i++) {
			DbVo tempDbVo = new DbVo();
			dbVoList.add(tempDbVo);
		}

		System.out.println(dbVoList.size());
		return dbVoList;
	}
	
}
