package setter;

import insa.Insa;

public class Setter {
	//private String babo; //�ڷ��� ������ 
	private Insa insa; //�ʵ���� ��ü (insaBean ��ü ���� ���� ��) 
	// Insa Ŭ���� insa ��ü 
	
	public Insa getInsa() { // ��ȯ���� ��ü 
		return insa;
	}
	
	public void setInsa(Insa insa) { //set�� ��ü�� 
		this.insa = insa; //insaBean��ü�� ���޵Ǿ� 
					//insa �ʵ忡 ����. 
	}
	
	public String KajaHello(String str1) {
		return insa.helloName(str1);
	}
}
