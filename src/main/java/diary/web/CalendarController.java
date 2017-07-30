package diary.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalendarController {

	
	@RequestMapping(value= {"/calendarForm.do"})
	public String calendarForm()throws Exception{
		
		return "calendarForm";
	}
	
}
