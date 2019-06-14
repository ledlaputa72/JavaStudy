package java005;

class AA{
	public void car() {
		System.out.println("클래스 AA Car");
	}
}

class BB extends AA{
	public void car() { //AA의 car()를 상속 +a
		System.out.println("클래스 BB Car");
	}
	
}

class CC extends BB{
	public void car() { //BB의 car()를 상송 +a
		System.out.println("클래스 CC Car");
	}
}

public class ClassExam {

	public static void main(String[] args) {
		
		AA a1=new AA(); //AA의 객체 a1
		BB b1=new BB(); //BB의 객체 b1
		CC c1=new CC(); //CC의 객체 c1
		//출력
		a1.car(); //AA car출력
		b1.car(); //BB car출력
		c1.car(); //CC car출력
		
		//-------------------
		AA a2=b1; //AA a2=new BB();
		BB b2=c1; //BB b2=new CC()
		//출력
		a2.car(); //BB car출력
		b2.car(); //CC car출력
		
		//--------------------
		BB b3=(BB)a2; //BB b3=new BB(), a2=new BB()이므로
		CC c3=(CC)b2; //CC c3=new CC(), b2=new CCC()이므로
		//출력
		b3.car(); //BB car출력
		c3.car(); //AA car출력
		
	}

}
