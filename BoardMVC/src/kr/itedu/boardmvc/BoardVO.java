package kr.itedu.boardmvc;

public class BoardVO {
	private int bid;
	private String btitle, bcontent, bregdate ,updatedate;
	
	public BoardVO(int bid,String btitle,String bregdate,String updatedate) {
		setBid(bid);
		setBtitle(btitle);
		setBregdate(bregdate);
		setUpdatedate(updatedate);
		
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBregdate() {
		return bregdate;
	}
	public void setBregdate(String bregdate) {
		this.bregdate = bregdate;
	}
	
	
}
