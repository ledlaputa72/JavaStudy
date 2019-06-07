package java002;

public class OverloadingTest {

	public static void main(String[] args) { //main method (사장)
		kaja();
//		kaja2(300,200,500); //가독성 문제 발생
		kaja(300,200,500); // 함수 이름을 kaja로 동일하게 사용 , 메소드(함수) 중복 : method overloading
		kaja(32.6, 78.7, 8); // 함수 이름이 kaja로 동일하고, 인자의 수가 3개로 동일하나, 타입이 틀리다. 
	}// main-end

	private static void kaja() { //kaja method (비서) - 1형식
		System.out.println("오늘도 열공");
	}

//	private static void kaja2(int i, int j, int k) { // kaja2 method - 2형식
	private static void kaja(int i, int j, int k) { // kaja로 이름이 같으나 인자가 3개로 틀림
		System.out.println(i+j+k);
	}

	private static void kaja(double d, double e, int k) { //이름과 인자가 동일하나 타입이 틀리다.  
		System.out.println(d+e+k);
	}

}// class-end
