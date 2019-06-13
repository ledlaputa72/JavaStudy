package java005;
//상속 
class Boomo { // 부모 클래스
	String juso;
	public void don() {
		System.out.println("나 재산 많아~");
	}
}

class Janyu extends Boomo{ //자식 클래스
	int na2;
	
	public Janyu(String juso, int na2) {
		this.na2=na2;
		this.juso=juso;
	}
	
	public Janyu() {
		
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
	}

}
