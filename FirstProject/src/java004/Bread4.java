package java004;

class BBang4 { 
	private String jong; // ��ü �Ӽ� 
	private int ka;
	
	public BBang4(String jong, int ka) { // ������ �����ε�
		this.jong=jong;
		this.ka=ka;
	}
	
	public BBang4() { // ������ �����ε� 
	}

	public String getJong() {
		return jong;
	}
	public void setJong(String jong) {
		this.jong = jong;
	}
	public int getKa() {
		return ka;
	}
	public void setKa(int ka) {
		this.ka = ka;
	} 

	// ������(construct)
//	public BBang4(String jong, int ka) { //�޼ҵ尰�� ��������, void/return�� ����. public���� ����. 
//		this.jong=jong;
//		this.ka=ka;
//	}
	
}
public class Bread4 {
	public static void main(String[] args) {
		BBang4 b1=new BBang4("�Һ��λ�",3000); // ��ü�� ����鼭 �ʱ�ġ�� �ְ� ������, ����+�ʱ�ġ
		
		System.out.println(b1.getJong()); 
		System.out.println(b1.getKa());
		
		BBang4 b2=new BBang4(); //�ʱ�ġ ���� ������ �ִ� ���  (����Ʈ �����ڸ� �ȸ���� �ְ� �ִ�. ���� ������)
	}
}
