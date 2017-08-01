package diary.web;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import diary.service.DiaryService;
import diary.vo.DbVo;
import diary.vo.DiaryVo;

@Controller
public class DiaryController {

	@Resource(name="DiaryService")
	private DiaryService diaryService;
	
	private Logger log = Logger.getLogger(getClass());
	 
	@RequestMapping(value= {"/diaryForm.do"})
	public String diaryForm(@ModelAttribute("diaryVo") DiaryVo diaryVo, ModelMap model)throws Exception{
		
		Calendar cal = Calendar.getInstance();
		
		int year;
		int month;
		if(diaryVo.getYear() != 0) {
			year = diaryVo.getYear();
			month = diaryVo.getMonth();		
		}else {
			year = cal.get(Calendar.YEAR);
			diaryVo.setYear(year);
			month = cal.get(Calendar.MONTH);
			diaryVo.setMonth(month);	
		}
		
		log.debug(year);
		log.debug(month);
		
		cal.set(year, month, 1);
		
		//시작 요일 예) 1
		int startDay = cal.getMinimum(java.util.Calendar.DATE);
		diaryVo.setStartDay(startDay);
		
		//끝 요일 예) 7월이면 31, 9월이면 30
		int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		diaryVo.setEndDay(endDay);
		
		//1일의 요일 , 일1,월2,화3,수4,목5,금6,토7
		int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
		diaryVo.setStart(start);
		
		//다이어리 내용
		List<DbVo> dbVoList = diaryService.selectDbVoList(diaryVo);
		diaryVo.setDbVoList(dbVoList);
		
		
		model.addAttribute("diaryVo", diaryVo);
		
		return "diaryForm";
	}
	
	@RequestMapping(value= {"/diaryInsert.do"})
	public String diaryInsert(@ModelAttribute("diaryVo")DiaryVo diaryVo,ModelMap model){
		
		String resultMsg = "시스템 오류입니다.";
		String moveType = "back";
		String returnUrl ="";
		
		try {
			diaryService.diaryDelete(diaryVo);
			diaryService.diaryInsert(diaryVo);
			resultMsg="정상적으로 다이어리가 저장되었습니다.";
			moveType="replace";
			returnUrl="/ownDiary/diaryForm.do?year="+diaryVo.getYear()+"&month="+diaryVo.getMonth();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("resultMsg", resultMsg);
		model.addAttribute("moveType", moveType);
		model.addAttribute("returnUrl", returnUrl);
		return "commResult";
	}
}
