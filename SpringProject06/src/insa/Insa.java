package insa;

public class Insa {
	private String name; //ȫ�浿
	
	public Insa(String name) { //������ �����ε� 
		this.name = name;
	}
	
	public Insa() { //����Ʈ ������ 		
	}
	
	public String helloName(String str1) {
		return this.name + " ��\n" + str1;
	}
}
