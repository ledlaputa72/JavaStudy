package java005;
//��� 
class Boomo { // �θ� Ŭ����
	String juso;
	public void don() {
		System.out.println("�� ��� ����~");
	}
}

class Janyu extends Boomo{ //�ڽ� Ŭ����
	int na2;
	
	public Janyu(String juso, int na2) {
		this.na2=na2;
		this.juso=juso;
	}
	
	public Janyu() {
		
	}
	
	public void car() {
		System.out.println("������ ����~");
	}
}

public class InheritanceStudy {

	public static void main(String[] args) {
		Boomo b1=new Boomo();
		b1.don();
		// b1.car()�� �ȵȴ�. 
		Janyu j1=new Janyu();
		j1.don(); // Boomo Ŭ�������� ��� ���� ����
		j1.car();
	}

}
