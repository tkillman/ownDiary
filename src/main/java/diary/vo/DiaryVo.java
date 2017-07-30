package diary.vo;

public class DiaryVo {

	private String reqDay;  
	private String daystr;           
	private String diaryetc;
	private String sqlid;
	private String reqDiaryetc;
	private String today;
	
	
	
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getReqDiaryetc() {
		return reqDiaryetc;
	}
	public void setReqDiaryetc(String reqDiaryetc) {
		this.reqDiaryetc = reqDiaryetc;
	}
	public String getSqlid() {
		return sqlid;
	}
	public void setSqlid(String sqlid) {
		this.sqlid = sqlid;
	}
	public String getReqDay() {
		return reqDay;
	}
	public void setReqDay(String reqDay) {
		this.reqDay = reqDay;
	}
	
	public String getDaystr() {
		return daystr;
	}
	public void setDaystr(String daystr) {
		this.daystr = daystr;
	}
	public String getDiaryetc() {
		return diaryetc;
	}
	public void setDiaryetc(String diaryetc) {
		this.diaryetc = diaryetc;
	}       

	
	
}
