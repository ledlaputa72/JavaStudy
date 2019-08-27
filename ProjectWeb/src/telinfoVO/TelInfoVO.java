package telinfoVO;

public class TelInfoVO {
	private int id;
	private String name;
	private String tel;
	private String d;
	
	public TelInfoVO() {	}

	public TelInfoVO(int id, String name, String tel, String d) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.d = d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}
	
	
}


