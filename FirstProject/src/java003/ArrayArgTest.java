package java003;

public class ArrayArgTest {

	public static void main(String[] args) {
		
        //명령어의 설명 달아주기
        if (args.length != 2) { //args 배열의 길이가 3으로 맞지  않으면  
             System.out.println("인자 수가 맞지 않습니다. ");
             System.out.println("사용법은 : 명령어 [숫자1]  [숫자2] ");
             System.exit(1); //강제 종료
             // return; // return뒤에 아무것도 없으면 강제 종료  C, Java, C# 등에서
             // C언어 : exit(1); 강제 종료를 의미, (0)정상종료
             // C# : Environment.Exit(1); 강제 종료
        }
		
        System.out.println("입력받은 인자 1 = "+args[0]+", 입력받은 인자 2 = "+args[1]);
        
        starPrint(args[0]);// 별찍기 메소드 
        strPrint(args[1]);// 텍스트 프린트 메소드         
		
	}//main end

	private static void strPrint(String str1) {

		int str=Integer.parseInt(str1); // 인자를 숫자로 바꿔주기 
		
		for (int i = 0; i < str+1; i++) {
			System.out.println("아름다운 밤입니다.!!");
		} // 2nd 인자 처리 end
	}

	private static void starPrint(String star1) {
		
        int star=Integer.parseInt(star1); // 인자를 숫자로 바꾸주기
        
		for (int i = 0; i < star; i++) {
			
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		} // 1st 인자 처리 end
		
	}
	
	

}//class end
