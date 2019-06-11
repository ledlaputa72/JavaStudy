package study01;

public class Variable1 {

	public static void main(String[] args) {
		int level; // 정수형 변수 level 선
		level = 10; // level 변수에 값 10을 대입 
		System.out.println(level); // level 값 출
		
		short sVal = 10;
		byte bVal = 20;
		System.out.println(sVal + bVal);
		
		char ch1 ='A';
		System.out.println(ch1); // 문자 출력 
		System.out.println((int)ch1); // 문자에 해당하는 정수값 출력 
		
		char ch2 = 66;
		System.out.println(ch2);
		
		int ch3 = 67;
		System.out.println(ch3);
		System.out.println((char)ch3);
		
		int a = 65;
		int b = -65;
		
		char a2 = 65;
		
		System.out.println((char)a);
		System.out.println((char)b);
		System.out.println(a2);
	}
}
