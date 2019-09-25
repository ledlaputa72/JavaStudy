package insa;

public class Insa {
	private String name; //홍길동
	
	public Insa(String name) { //생성자 오버로딩 
		this.name = name;
	}
	
	public Insa() { //디폴트 생성자 		
	}
	
	public String helloName(String str1) {
		return this.name + " 님\n" + str1;
	}
}
