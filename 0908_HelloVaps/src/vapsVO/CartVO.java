package vapsVO;

public class CartVO {
	
	private int cno;
	private String user_id;
	private String menu;
	private int price;
	private int amount;
	
	// 디폴트 생성자
	public CartVO() {
		super();
	}

	// 생성자
	public CartVO(int cno, String user_id, String menu, int price, int amount) {
		super();
		this.cno = cno;
		this.user_id = user_id;
		this.menu = menu;
		this.price = price;
		this.amount = amount;
	}

	public int getcno() {
		return cno;
	}

	public void setcno(int cno) {
		this.cno = cno;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getmenu() {
		return menu;
	}

	public void setmenu(String menu) {
		this.menu = menu;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
