package java005;

class Animal{
	String noon;
	public Animal() { //Animal ������1
		System.out.println("�� �����̾�!");
	}
	
	public Animal(int soo) { //Animal ������2
		System.out.println("���� ���� "+soo+"����.");
	}

	public void soomshim() {
		System.out.println("SoomShim");
	}
}

class Bird extends Animal{
	int soo;
	
	public Bird(String noon, int soo) { //Bird ������
		super(soo);//Animal ������ 2�� ã�ư� 
		this.noon=noon;
		this.soo=soo;
		System.out.println("�ڳడ ��ü���� �� �ֱ� ��");
	}
	
	public Bird() {
		
	}

	public void singing() {
		System.out.println("Singing");
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
		Bird b2=new Bird("eyes",2);
	}

}
