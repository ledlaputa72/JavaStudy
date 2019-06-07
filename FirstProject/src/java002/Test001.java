package java002;

import java.util.Scanner;

public class Test001 {

	public static void main(String[] args) {
		
		int sec=kaja(); //입력 받기 
		kaja(sec); //초 계산하기 
	}
	
	//초 계산하기 메소드
	private static void kaja(int sec) {
		
		int min=sec/60; // 시간을 구하기 위해 분을 구함
		int hr=min/60; // 분을 60으로 나눠 시간을 구한다. 실제 시간
		int sec1=sec%60; // 분을 구하고 남은 초의 수로. 실제 초 
		int min1=min%60; // 시간을 구하고 남은 분의 수로. 실제 분
		
		System.out.println(sec+"초는 ");
		if (hr==0 && min1!=0) { //시간이 0인 경우
			System.out.print(min1+"분 "+sec1+"초");
		}
		else if (hr==0 && min1==0) { // 시간과 분이 0인 경우
			System.out.print(sec1+"초");
		}
		else { //모두 나오는 경우 
			System.out.print(hr+"시간 "+min1+"분 "+sec1+"초");
		}
		System.out.println("입니다.");
	}
	
	// 초 입력받기 메소드
	private static int kaja() {
		Scanner sc1= new Scanner(System.in);
		
		System.out.println("초를 입력하세요");
		int sec1=sc1.nextInt();
		return sec1;
	}

}
