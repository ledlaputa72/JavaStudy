package java003;

import java.util.Arrays;
import java.util.Scanner;

public class SearchTest01 {

	public static void main(String[] args) {
		
		// �迭
		System.out.println("===== ���� �˻� =====");
		int[] arr2= {11,84,45,78,34,9,2};
		Arrays.sort(arr2); // �迭 ����
		
		//���ĵ� �迭 ���
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		
		//ã�� ���� �Է� = ans
		Scanner sc1=new Scanner(System.in);
		System.out.print("ã�� ���ڸ� �Է��ϼ��� : ");
		int ans=sc1.nextInt();
		
		//�迭 ���� �˻����� ��ġ ���
		if (Arrays.binarySearch(arr2, ans)>=0) { // ans�� ã�� ��, >=0 : ���� �ִ� ��츦 �ǹ�
			System.out.print("ã�� �� "+ans+"��");
			System.out.println((Arrays.binarySearch(arr2,ans))+"��° �ִ�.");
		}
		else {
			System.out.println("ã�� ���� ���׿�");
		}
		
	}//main end

}//class end
