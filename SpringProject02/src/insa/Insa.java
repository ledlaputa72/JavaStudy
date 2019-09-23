package insa;

public class Insa { //VO
	
	private String name; //홍길동 //setter Injection 
	// 홍길동 setName() ---> useBean setProperty
	// xml 에서 인자의 처리는 set등을 뺀 property만 사용
	
	public void setName(String name) { //초기치 인자 : 홍길동 
		this.name = name;
	}
								//"오늘 날씨 어때요?"
	public String insaGo(String str1) { // 출력을 위하 메소드 
		return this.name + " 님\n" + str1;
	}
	
}
