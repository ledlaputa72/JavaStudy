package Day016_Method_Overload;

import java.util.Scanner;

public class MethodTest2 {

	public static void main(String[] args) {
		// 메소드
		double ki=kaja1(); // 키입력 받기 
		double mom=kaja2(); // 몸무게 입력 받기 
		int bmi=(int)kaja3(ki, mom); // BMI 계산하기
        String printBmi=kaja4(bmi); // BMI로 출력 내용 만들기
        //결과 출력물 
		System.out.println("당신의 몸무게는 "+mom+"kg이며, 당신의 키는 "+(ki*100)+"cm입니다.");
		System.out.println("당신의 BMI수치는 "+bmi+" 입니다.");
        System.out.println("당신의 BMI는 "+printBmi+" 입니다.");  // 최종 결과 출력하기 
	}
	
	// BMI 출력 메소드
	private static String kaja4(double bmi) {
		
		String result; 
		if ( 30<= bmi) {
			result = "비만";
       }
       else if (25 <= bmi && bmi < 30)
       {
    	   result = "과체중";
       }
       else if(20 <= bmi && bmi < 25 )
       {
    	   result = "정상";
       }
       else
       {
    	   result = "저체중 ";
       }
		return result;
	}
	
	// BMI 계산 메소드
	private static double kaja3(double ki, double mom) {
		 double bmi = mom / (ki*ki); // mom / Math.pow(ki, 2); pow()함수 = power(지수)를 의미
		 return bmi;
	}

	// 몸무게 입력 메소드
	private static double kaja2() {  
		Scanner sc1 = new Scanner(System.in);

		System.out.println("당신의 몸무게를 입력하세요 : ");
        double ki= sc1.nextFloat();
        return ki;
	}
	
	// 키 입력 메소드
	private static double kaja1() {  
		Scanner sc2 = new Scanner(System.in);

		System.out.println("당신의 키를 미터로 입력하세요 : ");
        double mom= (sc2.nextFloat()/100);
        return mom;
	}
}
