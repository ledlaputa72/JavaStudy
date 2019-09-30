package vapsVO;

import java.util.Date;

public class BoardVO {
	
	private int bno;
	private String title;
	private String content;
	private String author;
	private Date regDate;
	private int hitCount;
	
	// 디폴트 생성자
	public BoardVO() {
		super();
	}

	// 생성자
	public BoardVO(int bno, String title, String content, String author, Date regDate, int hitCount) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.author = author;
		this.regDate = regDate;
		this.hitCount = hitCount;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	
}
