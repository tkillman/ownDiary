package diary.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import diary.service.DiaryService;
import diary.service.dao.DiaryDAO;

@Service("DiaryServiceImpl")
public class DiaryServiceImpl implements DiaryService{

	@Resource(name="DiaryDAO")
	private DiaryDAO diaryDAO;
	
	
	
}
