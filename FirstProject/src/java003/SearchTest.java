package java003;

import java.util.Arrays;
import java.util.Scanner;

public class SearchTest {

	public static void main(String[] args) {

		//���� �˻�
		System.out.println("===== ���� �˻� =====");
		int[] arr={10,20,30,40,50};
		int findsoo=30; //ã�� ��, Scanner�� �Է� �޾Ƶ� �ȴ�. 
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==findsoo) {
				System.out.println(i+"�� °");
			}
		} //for end
		// ���� �˻� �Ϸ� 

		
		// ���� �˻�
		System.out.println("===== ���� �˻� =====");
		int[] arr2= {11,84,45,78,34,9,2};
		Arrays.sort(arr2); // �迭 ����
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		
		//ã�� ���� �Է� 
		Scanner sc1=new Scanner(System.in);
		System.out.print("ã�� ���� ���� �Է� : ");
		int soo=Integer.parseInt(sc1.next()); //�Է� ���� ���ڸ� int������ 
		
		//�迭�� ����� ã�� ���
		int f=0;//first ����
		int l=arr2.length-1; //last ���� , arr2[6]���� ������ 0�� �����̴� ��ü ���� -1
		int m; //���
		
		int sw=0; // ����ġ ��� 
		int cnt=1;
		
		while (f<=l) { //f(����)�� l(��)���� �۰ų� ���� �������� ã�� (�����Ǹ� ���� ����) 
			m=(f+l)/2;
			if(soo==arr2[m]) {
				System.out.println(soo+"�� �迭"+m+" ��° �ִ�. ");
				sw=1; //ã���� sw�� �ٲ� �ڿ� ǥ�ø� ���� �ʴ´� 
				break;
			}
			else if(soo<arr2[m]) {
				l=m-1;				
			}
			else if(soo>arr2[m]) {
				f=m+1;
			}
			cnt++;
		}//while end
		System.out.println(cnt+"��° ã��");
		
		if(sw==0) { //���� ���� ��� ǥ��, ������ sw=1�� �Ǿ� �� if���� ǥ������ �ʴ´�. 
			System.out.println(soo+"�� ����");
		}
		// ���� �˻� �Ϸ�
		
	} //main end

}//class end
