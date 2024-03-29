package Day024_Class_Inter_Abst;

interface Samchon{
	public void boat(); //추상 클래스와 형식이 비슷하다. {} 내용을 못적는다. 선언만 가능하고 구현이 안된다. 
	// interface도 구현은 자식에서 해야한다. 
}

interface Bestfreind{
	public void motocycle();
}

class Parent{
	public void car() {
		System.out.println("부모 차 타고 드라이브 가자");
	}
}

class Child extends Parent implements Samchon,Bestfreind{
	public void car() {
		System.out.println("자녀 차 타고 드라이브 가자");
	}
	@Override
	public void boat() {
		System.out.println("삼촌 보드 타고 가자");
	}
	@Override
	public void motocycle() {
		System.out.println("베프 오토바이 타고 가자");
	}
}

public class InterfaceStudy01 {
	public static void main(String[] args) {
		Child c1=new Child();
		Parent p1=c1;
		p1.car(); //자녀의 car
		c1.car(); //자녀의 car
		c1.boat(); //삼촌한테 상속
		c1.motocycle(); //친구한테 상속

	}
}
