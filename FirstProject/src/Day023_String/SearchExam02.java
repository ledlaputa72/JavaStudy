package Day023_String;

import java.util.Scanner;

public class SearchExam02 {

	public static void main(String[] args) {
	
		String[] arr1= {"aa.html","bb.html","cc.html","j1.java","j2.java","j3.java",
				"js1.js","js2.js","js3.js"}; //������ �迭
		
		Scanner sc=new Scanner(System.in);
		System.out.println("ã�� ���� Ȯ���ڴ� [.html] [.java] [.js]");
		
		String[] arr2=kaja(arr1, sc.next()); //kaja(arr1, )�� �迭 ��ü�� �޾ƿ���, return�� arr3�� �޴´�. 
		
		for (int i = 0; i < arr2.length; i++) { //return���� arr2�� ���
			if(arr2[i] != null)
				System.out.println(arr2[i]);
		}
		
	}

	private static String[] kaja(String[] arr1, String next) { //��ȯ���� String[] �迭
		
		String[] arr3=new String[arr1.length]; //����� ���� �迭�� ����� ũ�⸦ �Ѿ�� �迭 arr1���� �Ѵ�. 
		
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i].endsWith(next))
				arr3[i]=arr1[i]; //���ǿ� �´� �迭�� ������ arr3�� ����
		}
		return arr3; //arr3�� return�Ѵ�. 
	}

}
