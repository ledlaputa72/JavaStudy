package insapkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Insa {

	@Autowired @Value("홍길동") //필드 
	
	private String name; //setName("홍길동") or 생성자로 처리 
	
	
	//출력 내용 
	public String helloName(String str1) {
		return this.name + " 님\n" + str1;
	}
}
