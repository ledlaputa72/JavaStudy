package Day031_Test02;

import java.util.Arrays;
import java.util.Scanner;

public class ExamTest02 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("put number for make random numbers");
		int[] number=new int[Integer.parseInt(sc.next())];
		
		for (int i = 0; i < number.length; i++) {
			number[i]=(int) (Math.random()*100);
			if(number[i]==0) { //���� 0�̸� �ٽ� 
				i--;
			}
			System.out.print(number[i]+",");
		}
		System.out.println();
		int[] arr1=min(number); //���� ���͸� �ϱ� (¦��)
		Arrays.sort(arr1); // �迭 ���� 
		
		//0�� ���� ��� ���� 
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i]!=0) {
				System.out.print(arr1[i]+",");
			}
		}
		System.out.println();
		
	}

	private static int[] min(int[] number) {

		int min=number[0];
		int count=0;
		int[] arr1=new int[number.length];
		
		for (int i = 0; i < number.length; i++) {
			if(number[i]%2==0) { //¦���� 
				count++;
				arr1[count-1]=number[i];
				System.out.print(number[i]+",");
			}
		}
		System.out.println();
		System.out.println("----------------------------");
		for (int i = 0; i < count; i++) {
			System.out.print(arr1[i]+",");
		}
		System.out.println();
		System.out.println("----------------------------");
//		System.out.println("min number : "+min);
		return arr1;
	}

}
