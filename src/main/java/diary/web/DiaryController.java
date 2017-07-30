package diary.web;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import diary.service.DiaryServiceImpl;
import diary.vo.DiaryVo;
import diary.vo.GoalVo;

@Controller
public class DiaryController {

	
	Logger log = Logger.getLogger(this.getClass());

	
	@Resource(name="DiaryServiceImpl")
	private DiaryServiceImpl diaryServiceImpl;
	

	@RequestMapping(value={"/diary/diaryForm.do"})
	public String diaryList(@ModelAttribute("diaryVo")DiaryVo diaryVo, ModelMap model) throws Exception{
		log.debug("테스트");
		//목표 보내주기
		GoalVo goalVo = diaryServiceImpl.selectGoal(diaryVo);
		model.addAttribute("goalVo", goalVo);
		
	    //오늘 날짜 내용 보내주기
		DiaryVo todayDiaryVo = diaryServiceImpl.selectTodayDiaryData(diaryVo);
		model.addAttribute("todayDiaryVo", todayDiaryVo);
		
		//조회 내용 보내주기
		if(diaryVo.getReqDay() !=null){
			
		DiaryVo reqDiaryVo = diaryServiceImpl.selectReqDiaryData(diaryVo);
		model.addAttribute("reqDiaryVo", reqDiaryVo);
		}
		
		
		return "diaryForm";
	}
	
	@RequestMapping(value={"/diary/goalUpdate.do"})
	public String goalUpdate(@ModelAttribute("goalVo")GoalVo goalVo, ModelMap model) throws Exception{
		
		diaryServiceImpl.updateGoal(goalVo);
		
		return "redirect:/diary/diaryForm.do";
	}
	
	@RequestMapping(value={"/diary/diarySave.do"})
	public String diarySave(@ModelAttribute("diaryVo")DiaryVo diaryVo, ModelMap model) throws Exception{
		
		
		int searchResult = diaryServiceImpl.countTodayData(diaryVo);
		
		
		if(searchResult == 1){
			diaryServiceImpl.updateTodayDiary(diaryVo);
		}else{
		diaryServiceImpl.insertDiary(diaryVo);
		}
		
		
		return "redirect:/diary/diaryForm.do";
	}
	
	
	@RequestMapping(value={"/diary/diaryUpdate.do"})
	public String diaryUpdate(@ModelAttribute("diaryVo")DiaryVo diaryVo, ModelMap model) throws Exception{
		
			diaryServiceImpl.updateReqDiary(diaryVo);
		
		return "redirect:/diary/diaryForm.do";
	}
	
	
	
}
