package insapkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Insa {

	@Autowired @Value("홍길동") //필드 
	
	private String name; //setName("홍길동") or 생성자로 처리 
	
	
	
	
	/*//생성자
	public Insa(String name) { //생성자 오버로딩 
		this.name = name;
	}
	
	public Insa() { //디폴트 생성자 		
	}
	
	//setter getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/
	
	//출력 내용 
	public String helloName(String str1) {
		return this.name + " 님\n" + str1;
	}
}
