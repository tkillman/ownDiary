package diary.web;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import diary.vo.DiaryVo;

@Controller
public class DiaryController {

	
	@RequestMapping(value= {"/diaryForm.do"})
	public String diaryForm(@ModelAttribute("diaryVo") DiaryVo diaryVo, ModelMap model)throws Exception{
		
		
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
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
	
}
