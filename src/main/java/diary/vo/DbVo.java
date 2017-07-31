package diary.vo;

public class DbVo {

	private Long seq;           
	private String year_month;          
	private int idx;                       
	private String etc;
	
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getYear_month() {
		return year_month;
	}
	public void setYear_month(String year_month) {
		this.year_month = year_month;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}                
	
}
