package java006_Class2;

interface OtherOwner{
	public void pack();
	public void costomerService();
}

class Owner{
	public void cookWell() {
		System.out.println("요리 잘하는 법 - 사장");
	}
}

class Worker extends Owner implements OtherOwner{
	public void cookWell() {
		System.out.println("요리잘하는 법 - 직원");
	}
	@Override
	public void pack() {
		System.out.println("포장잘하는 법 - 다른 사장");
	}
	@Override
	public void costomerService() {
		System.out.println("고객 응대법 - 다른 사장");
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
