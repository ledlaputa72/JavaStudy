package constarg;

import insa.Insa;

public class Constarg {
	private Insa insa; //insa�ʵ�(�Ӽ�)�� //��ü�� ���� �ʵ�  

	//������ ����� 
	public Constarg(Insa insa) { //�����ڿ� insa ��ü�� �Ѿ�� ��, insaBean��ü�� �޾� insa�ʵ�(��ü)�� �ֱ� 
		this.insa = insa;
	}
	
	public Constarg() { } //������ 
	
	public String kajaHello(String str1) {
		return insa.helloName(str1);
		//insaBean��ü.helloName()
	}
}
