package java004;

class BBangEncap { //���� 
	private String jong; //ĸ��ȭ,  private�� �ܺ� Ŭ�������� ������ �Ұ��� �Ѵ�. 
	private int ka; 
	// private �Ӽ��� �����ְ�, �ް� �ϴ� �����(�޼ҵ�)�� �ʿ��ϴ�. public 
	
	//�Ӽ��� ����� �� �ְ� ����� �޼ҵ带 ���� �Ѵ�. 
	public void setJong (String jong) { //���� �ִ� ����� �޼ҵ�
		this.jong = jong; // ��ü.�Ӽ�=��  
		// �տ� jong�� ���� ��ü �Ӽ�, ���� jong�� �޼ҵ��� ����, �տ� this.�� �ٿ� ������ �ش�. 
	}
	
	public String getJong () { // ������ �޾ƿ��� ����� �޼ҵ�
		return jong; //jong�� �׳ɽᵵ �ǰ�, this.jong�� �ᵵ �ȴ�. 
	}
	
	public void setKa (int ka) { //���� �ִ� ����� �޼ҵ�
		this.ka = ka; 
	}
	
	public int getKa () { // ������ �޾ƿ��� ����� �޼ҵ�
		return this.ka;  //jong�� �׳ɽᵵ �ǰ�, this.jong�� �ᵵ �ȴ�. 
	}
	
}

public class BreadEncapsul {
	public static void main(String[] args) {
		BBangEncap b1=new BBangEncap(); // ����
		// b1.jong="�ϻ�"; �̷��� �ȵȴ�.
		b1.setJong("��ũ����"); //�Ӽ����� �ִ� setJong
		b1.setKa(2000);
				
		System.out.println(b1.getJong()); //�Ӽ����� �������� getJong
		System.out.println(b1.getKa());
		
		BBangEncap b2=new BBangEncap(); // ����
		b2.setJong("��ũ����"); //�Ӽ����� �ִ� setJong
		b2.setKa(2000);
		
		System.out.println(b2.getJong()); //�Ӽ����� �������� getJong
		System.out.println(b2.getKa());
		
	}

}
