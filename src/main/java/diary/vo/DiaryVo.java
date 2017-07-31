package diary.vo;

import java.util.List;

public class DiaryVo {

	
	private int startDay;
	private int endDay;
	private int newLine;
	private int start;
	private int year;
	private int month;
	private List<DbVo> dbVoList;
 	
	
	
	
	public List<DbVo> getDbVoList() {
		return dbVoList;
	}
	public void setDbVoList(List<DbVo> dbVoList) {
		this.dbVoList = dbVoList;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
	public int getNewLine() {
		return newLine;
	}
	public void setNewLine(int newLine) {
		this.newLine = newLine;
	}
	
	
	
	
	
}
