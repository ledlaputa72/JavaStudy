package study01;

import java.util.Scanner;

public class GetMinMax {

	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Eng=");
		int eng = sc1.nextInt();
		
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
		int max = score[0]; //79 저장 
		int min = score[0]; //79 저장 
		
		for (int i = 1; i < score.length; i++) {
			if(score[i] > max) { // 79와 다음 88부터 비교 
				max = score[i];
			}
			else if (score[i] < min){ // 79와 다음 88부터 비교 
				min = score[i];
			}
		}// end for
		
		System.out.println("max : "+max);
		System.out.println("min : "+min);
		
	} //end main

} // end class 
