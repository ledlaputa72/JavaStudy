package Day021_Class2;

class Animal{
	String noon;
	
	public void soomshim() {
		System.out.println("������");
	}
	
	public Animal() { //Animal ������1 (���ھ���)
		System.out.println("�� �����̾�!");
	}
	
	public Animal(int soo) { //Animal ������2 (�����ִ�)
		System.out.println("���� ���� "+soo+"����.");
	}

}

class Bird extends Animal{
	int soo;
	
	public Bird(String noon, int soo) { //Bird ������, ��ӹ��� noon�� ����Ҽ� �ְ�, �ڱ⸸�� soo�� ���
		super(soo);//Animal �θ�� ����. ������ 2�� ã�ư� soo���� 2�� ������ �� 
		this.noon=noon;
		this.soo=soo;
		System.out.println("�ڳడ ��ü���� �� �ֱ� ��");
		//��ӿ����� ������ ȣ��� �θ�����ڸ� ���� �����ϰ� �ڳ�����ڸ� �����Ѵ�. 
	}
	
	public Bird() {
		
	}

	public void singing() {
		System.out.println("�뷡�Ѵ�");
		System.out.println("�� ����");
	}
	
}
public class Animal_Bird {
	
	public static void main(String[] args) {
		Animal a1=new Animal();
		a1.soomshim();
		
		Bird b1=new Bird();
		b1.soomshim();
		b1.singing();
		Bird b2=new Bird("eyes",2);//�ڳ� �����ڸ� ȣ��
	}

}
