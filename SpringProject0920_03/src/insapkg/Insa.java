package insapkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Insa {

	@Autowired @Value("ȫ�浿") //�ʵ� 
	
	private String name; //setName("ȫ�浿") or �����ڷ� ó�� 
	
	
	
	
	/*//������
	public Insa(String name) { //������ �����ε� 
		this.name = name;
	}
	
	public Insa() { //����Ʈ ������ 		
	}
	
	//setter getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/
	
	//��� ���� 
	public String helloName(String str1) {
		return this.name + " ��\n" + str1;
	}
}
