package java006_Class2;

interface Samchon{
	public void boat(); //�߻� Ŭ������ ������ ����ϴ�. {} ������ �����´�. ���� �����ϰ� ������ �ȵȴ�. 
	// interface�� ������ �ڽĿ��� �ؾ��Ѵ�. 
}

interface Bestfreind{
	public void motocycle();
}

class Parent{
	public void car() {
		System.out.println("�θ� �� Ÿ�� ����̺� ����");
	}
}

class Child extends Parent implements Samchon,Bestfreind{
	public void car() {
		System.out.println("�ڳ� �� Ÿ�� ����̺� ����");
	}
	@Override
	public void boat() {
		System.out.println("���� ���� Ÿ�� ����");
	}
	@Override
	public void motocycle() {
		System.out.println("���� ������� Ÿ�� ����");
	}
}

public class InterfaceStudy01 {
	public static void main(String[] args) {
		Child c1=new Child();
		Parent p1=c1;
		p1.car();
		c1.car();
		c1.boat();
		c1.motocycle();

	}
}
