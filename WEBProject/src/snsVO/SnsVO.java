package snsVO;

public class SnsVO {
	
	private String name;
	private String sns;
	
	public SnsVO() {
		
	}
	
	public SnsVO(String name, String sns) {
		this.name = name;
		this.sns = sns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}

}
