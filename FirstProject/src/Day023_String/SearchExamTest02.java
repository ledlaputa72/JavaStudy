package Day023_String;

import java.util.Scanner;

public class SearchExamTest02 {

	public static void main(String[] args) {

		String s1 ="babooondal,Baeyul,�����ٴ�,kongjoo,Marry,blue,������ ";
		
		kaja(s1); //1)String s1�� ����
		//4)��µǰ� ���� ����
	}// main end

	private static void kaja(String s1) {
		
		String[] arr1=s1.split(","); //2) ���� s1�� �ܾ �и��� �࿭�� ����

		String words="b"; //3a) "b"�� ã�� words (���ڿ� ã��)
		char ch='��'; //3b) '��'�� ã�� char (���� ã��)
		
		// 3a1)startsWith�� ���ڿ����� ���� �ܾ� �˻�
		System.out.println("--- b�� �����ϴ� �ܾ� �˻� - startsWith");
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i].startsWith(words)||arr1[i].startsWith(words.toUpperCase())) { //3a2) �˻�
				System.out.println(arr1[i]); //3a3) ���
			}
		}
		
		// 3b1)charAt()���� ���� �˻�
		System.out.println("--- ������ �����ϴ� �ܾ� �˻� - charAt()");
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i].charAt(0)==ch) // 3b2) �˻�
				System.out.println(arr1[i]); //3b3)���
		}
	}// kaja end
}//class end
