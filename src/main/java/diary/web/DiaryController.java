package diary.web;

import java.util.Calendar;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import diary.service.DiaryService;
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
		
		int startDay = cal.getMinimum(java.util.Calendar.DATE);
		diaryVo.setStartDay(startDay);
		
		int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		diaryVo.setEndDay(endDay);
		
		int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
		diaryVo.setStart(start);
		
		
		
		model.addAttribute("diaryVo", diaryVo);
		
		return "diaryForm";
	}
	
	@RequestMapping(value= {"/diaryInsert.do"})
	public String diaryInsert(@ModelAttribute("diaryVo")DiaryVo diaryVo,ModelMap model) throws Exception {
		
		String resultMsg = "시스템 오류입니다.";
		String moveType = "back";
		String returnUrl ="";
		
		diaryService.diaryInsert(diaryVo);
		
		
		return "commResult";
	}
}
