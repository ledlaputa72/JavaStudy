package Day021_Class2;
//��� 
class Boomo { // �θ� Ŭ����
	String juso; //�θ��� �Ӽ�(�ʵ�), ������������ Default(�տ� public ������ ����)  
	public Boomo() { //������1 �����ε�
		System.out.println("�� ���̴� ���� 100�� �Ʒ���");
	}
	public Boomo(int na2) { //������2 �����ε�
		System.out.println("���� �׷���"+na2+"�� ���ٴ� ����~");
	}
	public void don() { // �θ��� �޼ҵ�
		System.out.println("�� ��� ����~");
	}
}

class Janyu extends Boomo{ //�ڽ� Ŭ����
	protected int na2; // �ڽ��� �Ӽ�(�ʵ�), ��ӵ� �͵� ������ ���� �� �ִ� ���������� : protected
	
	public Janyu(String juso, int na2) { //������1
	  super(na2); //��������� �θ� ã�� ���, Boomo ������2�� ã�ư� 
	  //super() //-> Boomo������ 1�� ã�ư�
	  this.na2=na2;
	  this.juso=juso; //�θ��� juso�� ��� �޾ƿ�
	  System.out.println("���� �ڳ� ������");
	}
	 
	public Janyu() { //������2
		
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
		Janyu j2=new Janyu("����",30);
		
		System.out.println(j2.na2+"\t"+j2.juso);
	}

}
