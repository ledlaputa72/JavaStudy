package Day023_String;

import java.util.Scanner;

public class StringTest01 {

	public static void main(String[] args) {

		//���� ����//////////////////////////////////////
		kajalnit("i love you");
		kajalnit("you LOVE Me");
		kajalnit("Have a nice DAY");
		
		//���� �Է� �޾� �����ϱ�//////////////////////////////
		Scanner sc=new Scanner(System.in);
		System.out.println("����� �� ������ �Է��ϼ��� ");
		String text=sc.nextLine(); // �ٲٰ� ���� ���� �Է�
		
		System.out.println("==�Է¹��� ������ : "+text+" �Դϴ�.==");
		kajalnit(text); //�Է� ���� ������ �ٲ��ش�. 
    }

	private static void kajalnit(String changeText ) {
		//��ȯ�ϱ� ���� ���� �и��� ��ҹ��� �ҽ� �����/////////////////
		String[] arr=changeText.split(" "); //�ܾ� ����
		String[] arr1=new String[arr.length]; //�ҹ��ڿ� �迭
		String[] arr2=new String[arr.length]; //�빮�ڿ� �迭
				
		for (int i = 0; i < arr.length; i++) { //�ҹ��� �����
			arr1[i]=arr[i].toLowerCase(); //arr1���� �ҹ���
		}
		for (int i = 0; i < arr.length; i++) { //�빮�� �����
			arr2[i]=arr[i].toUpperCase(); //arr2���� �빮�� 
		}
		
		//ù���� �ٲٱ� //////////////////////////////////////
		StringBuffer[] result =new StringBuffer[arr1.length]; 
		
		for (int i = 0; i < arr2.length; i++) {
			StringBuffer str=new StringBuffer(arr1[i]);
			str.replace(0,1, arr2[i].substring(0, 1));
			result[i]=str; //�ϼ��� �ܾ result�迭�� ������� �Ű� �ִ´�.
		}
		
		//�ϼ��� ���� ���/////////////////////////////////////
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}
		
}
