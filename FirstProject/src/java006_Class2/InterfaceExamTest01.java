package java006_Class2;

interface OtherOwner{
	public void pack();
	public void costomerService();
}

class Owner{
	public void cookWell() {
		System.out.println("�丮 ���ϴ� �� - ����");
	}
}

class Worker extends Owner implements OtherOwner{
	public void cookWell() {
		System.out.println("�丮���ϴ� �� - ����");
	}
	@Override
	public void pack() {
		System.out.println("�������ϴ� �� - �ٸ� ����");
	}
	@Override
	public void costomerService() {
		System.out.println("�� ����� - �ٸ� ����");
	}
}

public class InterfaceExamTest01 {

	public static void main(String[] args) {

		Worker w1=new Worker();
		Owner o1=new Owner();
		Owner o2=w1;
		o1.cookWell();
		o2.cookWell();
		w1.cookWell();
		w1.pack();
		w1.costomerService();
		
	}
}
