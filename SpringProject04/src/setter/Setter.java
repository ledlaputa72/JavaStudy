package setter;

import insa.Insa;

public class Setter {
	//private String babo; //자료형 변수명 
	private Insa insa; //필드명이 객체 (insaBean 객체 참조 변수 들어감) 
	// Insa 클래스 insa 객체 
	
	public Insa getInsa() { // 반환형이 객체 
		return insa;
	}
	
	public void setInsa(Insa insa) { //set도 객체를 
		this.insa = insa; //insaBean객체가 전달되어 
					//insa 필드에 들어간다. 
	}
	
	public String KajaHello(String str1) {
		return insa.helloName(str1);
	}
}
