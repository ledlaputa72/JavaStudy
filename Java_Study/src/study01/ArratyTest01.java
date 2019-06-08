package study01;

import java.util.Scanner;

public class ArratyTest01 {

	public static void main(String[] args) {
		
		int sum = 0;
		float average = 0f;
		
		System.out.println("Please fill up your scores.");
		System.out.println("###########################");

		Scanner sc1 = new Scanner(System.in);
		System.out.println("Eng=");
		int eng = sc1.nextInt();
		System.out.println("Kor=");
		int kor = sc1.nextInt();
		System.out.println("Mat=");
		int mat = sc1.nextInt();
		System.out.println("Sic=");
		int sic = sc1.nextInt();
		
		int[] score = {eng,kor, mat, sic};
		
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		
		average = sum / (float)score.length ;
		
		System.out.println("Sum="+sum+"point");
		System.out.println("Average="+average+"point");
		
	}

}
