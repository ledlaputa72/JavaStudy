package java006_Class2;

abstract class Kwail{ //추상 클래스 
	public void good()
	{
		System.out.println("먹으면 좋아");
	}
	public abstract void mukja(); //추상 메소드
	//구현X, 선언O, 구현은 자녀쪽에서 한다. 
}

class Sakwa extends Kwail{
	@Override
	public void mukja() {
		System.out.println("사과를 사각사각 먹자"); //먹자에 대한 내용을 써줘야 한다. 
	}
}

class Bae extends Kwail{
	@Override
	public void mukja() {
		System.out.println("배를 아삭아삭 먹자");
	}
}

class Kam extends Kwail{
	@Override
	public void mukja() {
		System.out.println("감을 오독오독 먹자");
	}
}

public class ClassStudy201 {

	public static void main(String[] args) {
		
		Kwail k1=new Sakwa(); //객체의 형변환
		k1.mukja();
		
		Kwail k2=new Bae(); //k1,k2가 자녀(사과,배)를 가리키고 있다. 
		k2.mukja();
		
		Kwail k3=new Kam(); //K3가 자녀(감)을 가리키고 있다.  
		k3.mukja();

	}

}
