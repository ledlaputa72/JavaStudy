//객체의 형변환
package java005;

class Parent{
	public void car() { //car1
		System.out.println("나는 부모-드라이브가자.");
	}
}

class Child extends Parent{
	public void car() { //car2, car1을 상속받아 재정의 된 car()
		System.out.println("나는 자녀-여행가자.");
	}
}

public class ClassTrans {

	public static void main(String[] args) {
		
		Parent p1=new Parent(); //부모 객체
		Child c1=new Child(); //자식 객체
		p1.car();
		c1.car(); //car2
		//---------------------------------------
		//Parent p2=c1; // 사용가능 
		Parent p2=new Child(); //Parent p2=c1;와 문법이 같다. 사용가능 
		
		//Child c2=p1; //형변환이 안된다. 
		//Child c2=new Parent(); //Child c2=p1;와 문법이 같다. 사용불가
		
		//아래 문장 정상
		Child c3=(Child)p2; // Child c3=new Child();
		//아래 문장 에러, Compile ok, Run err (자산이 틀리기 때문)
		//Child c4=(Child)p1; //빨간줄은 없으나 에러이다. 
	}

}
