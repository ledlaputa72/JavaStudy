package Day030_Test;

import java.util.Arrays;

public class ChangeCharTest {

	public static void main(String[] args) {
		char[] ch1={'S','u','N','n','Y'};
		charPrint(ch1); //���� ���
		change(ch1); //��ҹ��� ��ȯ, sort �Լ� 
		charPrint(ch1); //���� ���
		
	}//main end

	private static void change(char[] ch1) {
		//��ҹ��� ���� +32 -32
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i]>='A' && ch1[i]<='Z') { //�빮�� �ľ� 
				//ascii �����ڸ� ���ڷ� ǥ�� if(97<=ch1[i] && ch1[i]<=122){
                 ch1[i]=(char)(ch1[i]+32); //�빮�� -> �ҹ���
			}
			else { //�̿��� ����(�ҹ���)
        	   ch1[i]=(char)(ch1[i]-32); //�ҹ��� -> �빮��
			}
		}
		Arrays.sort(ch1); //����
	}//change() end

	private static void charPrint(char[] ch1) {
		System.out.println("---------------------");
		for (int i = 0; i < ch1.length; i++) {
			System.out.print(ch1[i]+"\t");
		}
		System.out.println();
	}//charPrint() end

}//class end
