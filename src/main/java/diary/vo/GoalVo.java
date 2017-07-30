package diary.vo;

public class GoalVo {

	private String longGoal;
	private String shortGoal;
	private int seq_no;
	private String sqlid;
	
	
	
	public String getSqlid() {
		return sqlid;
	}
	public void setSqlid(String sqlid) {
		this.sqlid = sqlid;
	}
	public int getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}
	public String getLongGoal() {
		return longGoal;
	}
	public void setLongGoal(String longGoal) {
		this.longGoal = longGoal;
	}
	public String getShortGoal() {
		return shortGoal;
	}
	public void setShortGoal(String shortGoal) {
		this.shortGoal = shortGoal;
	}
	
	
}
