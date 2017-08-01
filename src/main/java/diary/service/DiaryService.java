package diary.service;

import java.util.List;

import diary.vo.DbVo;
import diary.vo.DiaryVo;

public interface DiaryService {

	int diaryDelete(DiaryVo diaryVo) throws Exception;
	int diaryInsert(DiaryVo diaryVo) throws Exception;
	
	List<DbVo> selectDbVoList(DiaryVo diaryVo) throws Exception;
	List<DbVo> dumpList() throws Exception;
}
