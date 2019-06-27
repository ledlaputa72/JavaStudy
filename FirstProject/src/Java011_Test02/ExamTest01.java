package Java011_Test02;

import java.util.Scanner;

public class ExamTest01 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String sc1="I-love-You";
		StringBuffer str=new StringBuffer(sc1);
		
		System.out.println("숫자를 입력하세요 1~3");
		int num=sc.nextInt();
		
		switch (num) {
		case 1:
			str.replace(0, 1, "You");
			str.replace(9, 12, "Me");
			break;
		case 2:
			str.replace(2, 6, "hate");
			break;
		case 3:
			str.append("-So-Much");
			break;
		default:
			str.reverse();
			break;
		}
		System.out.println(str);
	}

}
