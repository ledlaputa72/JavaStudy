package java001;

public class MethodTest { // class 시작

		// 메소드 호출문
		public static void main(String[] args) {
		kaja(); // 메소드 1형식 (되돌아 올때 출발 뒤로 온다)
		kaja2(300); // 메소드 2형식, 인자,인수, argument가 포함되면 2형식, (되돌아 올때 출발 뒤로 온다)
		//String bada=kaja3();// 메소드 3형식 (되돌아 올때 출발한 그자리로 돌아온다)
		//System.out.println("역시"+bada);
		System.out.println(kaja3()); //3형식의 경우 반환값 변수 설정 후 출력의 2문장을 한 문장으로 줄일 수 있다.
	    } // main끝
		
		// 메소드 3형식 - return이 있다. 
		private static String kaja3() { // 여기서 String을 반환형이라고 한
			String moo="무조건";
			System.out.println("자바와 우리반에 대하여말한다면");
			return "최고야~~"+moo; // 값을 가지고 가게 한다. 대신 값을 종류를 알아야 한다. 
		} // 메소드 3형식 끝

		// 메소드 2형식 - 인자, 인수 값이 있다. 
		private static void kaja2(int don) { //매개변수, parameter
			System.out.println(don+"만원 입금하러 간다.");
		} // 메소드 2형식 끝
		
		
	    // 메소드(함수) 정의문 - 메소드 1형식
		public static void kaja() {
		int y=2019;
		if (y%4==0 && y%100!=0 || y%400==0) //윤년 확인  
			System.out.println("윤년");
		else
		System.out.println("평년");
		} // 메소드 3형식

}// class 끝
