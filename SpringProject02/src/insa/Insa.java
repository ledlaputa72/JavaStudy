package insa;

public class Insa { //VO
	
	private String name; //ȫ�浿 //setter Injection 
	// ȫ�浿 setName() ---> useBean setProperty
	// xml ���� ������ ó���� set���� �� property�� ���
	
	public void setName(String name) { //�ʱ�ġ ���� : ȫ�浿 
		this.name = name;
	}
								//"���� ���� ���?"
	public String insaGo(String str1) { // ����� ���� �޼ҵ� 
		return this.name + " ��\n" + str1;
	}
	
}
