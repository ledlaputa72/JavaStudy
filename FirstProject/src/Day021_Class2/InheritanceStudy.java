package Day021_Class2;
//상속 
class Boomo { // 부모 클래스
	String juso; //부모의 속성(필드), 접근지정자의 Default(앞에 public 같은게 없음)  
	public Boomo() { //생성자1 오버로딩
		System.out.println("나 나이는 젊어 100살 아래야");
	}
	public Boomo(int na2) { //생성자2 오버로딩
		System.out.println("에이 그래도"+na2+"살 보다는 말지~");
	}
	public void don() { // 부모의 메소드
		System.out.println("나 재산 많아~");
	}
}

class Janyu extends Boomo{ //자식 클래스
	protected int na2; // 자식의 속성(필드), 상속된 것들 끼리만 통할 수 있는 접근지정자 : protected
	
	public Janyu(String juso, int na2) { //생성자1
	  super(na2); //명시적으로 부모를 찾는 방법, Boomo 생성자2로 찾아감 
	  //super() //-> Boomo생성자 1로 찾아감
	  this.na2=na2;
	  this.juso=juso; //부모의 juso를 상속 받아옴
	  System.out.println("나는 자녀 생성자");
	}
	 
	public Janyu() { //생성자2
		
	}
	
	public void car() {
		System.out.println("중형차 있음~");
	}
}

public class InheritanceStudy {

	public static void main(String[] args) {
		Boomo b1=new Boomo();
		b1.don();
		// b1.car()는 안된다. 
		Janyu j1=new Janyu();
		j1.don(); // Boomo 클래스에서 상속 받은 내용
		j1.car();
		Janyu j2=new Janyu("종로",30);
		
		System.out.println(j2.na2+"\t"+j2.juso);
	}

}
