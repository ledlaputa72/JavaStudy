package insapkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Insa {

	@Autowired @Value("ȫ�浿") //�ʵ� 
	
	private String name; //setName("ȫ�浿") or �����ڷ� ó�� 
	
	
	//��� ���� 
	public String helloName(String str1) {
		return this.name + " ��\n" + str1;
	}
}
