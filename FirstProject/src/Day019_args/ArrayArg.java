package Day019_args;

public class ArrayArg {
	//명령어와 명령행 인자 만들기 
	//명령어 30 80 >> args[0]="30", args[1]="80"
	
	public static void main(String[] args) {
		//명령어의 설명 달아주기
		if (args.length != 3) { //args 배열의 길이가 3으로 맞지 않으면  
			System.out.println("인자 수가 맞지 않습니다. ");
			System.out.println("사용법은 : 명령어 [숫자1] [숫자2] [숫자3] ");
			System.exit(1); //강제 종료 
			// return; // return뒤에 아무것도 없으면 강제 종료 C, Java, C# 등에서
			// C언어 : exit(1); 강제 종료를 의미, (0)정상종료
			// C# : Environment.Exit(1); 강제 종료 
		}
		 //String -> Int로 형변환
		System.out.println(Integer.parseInt(args[0])
				+Integer.parseInt(args[1])
				+Integer.parseInt(args[2]));
	}

}
