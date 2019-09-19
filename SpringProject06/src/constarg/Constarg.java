package constarg;

import insa.Insa;

public class Constarg {
	private Insa insa; //insa필드(속성)명 //객체가 들어가는 필드  

	//생성자 만들기 
	public Constarg(Insa insa) { //생성자에 insa 객체가 넘어옴 즉, insaBean객체를 받아 insa필드(객체)에 넣기 
		this.insa = insa;
	}
	
	public Constarg() { } //생성자 
	
	public String kajaHello(String str1) {
		return insa.helloName(str1);
		//insaBean객체.helloName()
	}
}
