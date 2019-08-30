//클래스 연습

package homestudy;

class Parent{
	String AA;
	
	public Parent(int BB) {
		System.out.println("BB");
	}
	
	public Parent() {
		
	}
	
	public void car() {
		System.out.println("부모");
	}
}

class Child extends Parent{
	protected int BB;
	
	public Child(String AA, int BB) {
		super(BB);
		this.BB = BB;
		this.AA = AA;
	}
	public Child() {
		
	}
	
	public void car() {
		System.out.println("자식");
	}
	
}


public class HomeExam02 {

	public static void main(String[] args) {
		
		Parent p1=new Parent();
		System.out.print("p1: ");
		p1.car();
		
		Child c1=new Child();
		System.out.print("c1: ");
		c1.car();
		
		Parent p2=new Child();
		System.out.print("p2: ");
		p2.car();
		
		Child c2=new Child("AA", 100);

	}

}
