package diary.vo;

public class DbVo {

	private long seq;           
	private String year_month;          
	private int idx;                       
	private String etc;
	private String sqlid;
	
	
	
	
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public String getSqlid() {
		return sqlid;
	}
	public void setSqlid(String sqlid) {
		this.sqlid = sqlid;
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
