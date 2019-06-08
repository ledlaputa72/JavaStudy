package study01;

import java.util.Scanner;

public class CalJinso {

	public static void main(String[] args) {
		// int 숫자 받음 num1
		Scanner sc1=new Scanner(System.in); 
		System.out.println("변환할 숫자를 입력하세요.");
		int num1 = sc1.nextInt();
		
		System.out.println("변환할 숫자는 : "+num1);
		
		// 변환하고 싶은 진수 입력 = num2
		System.out.println("변환할 진수를 입력하세요.");
		int num2 = sc1.nextInt();
		
		System.out.println("변환할 진수는 : "+num2);
		
		// 값과 나머지를 담을 배열을 생성
		int [] aa= new int[10]; // 나눈 값을 담을 배열 
		int [] bb= new int[10]; // 나머지를 담을 배열 
		int count=0; 
		//double cc=Math.pow(num1, num2);// for 문 반복 횟수 
		
		// aa/bb 값(aa1)을 나누고 aa%bb = (bb1)
		aa[0]=num1;
		bb[0]=num2;
		
		//배열의 길이는 확정되면 변경되지 않는다. 

		System.out.println(aa[0]+", "+bb[0]);
		
		for (int i = 1; i<6; i++) {
			aa[i]=aa[i-1]/bb[0];
			bb[i]=aa[i-1]%bb[0];
			//System.out.println("aa["+i+"]: "+aa[i]);
			//System.out.println("bb["+i+"]: "+bb[i]);
			count+=1;
			//System.out.println("count : "+count);
			}
		System.out.println(count);
		
		for (int j = 0; j < count; j++) {
			System.out.print(bb[count-j]);
		}
		
		
	}

}
