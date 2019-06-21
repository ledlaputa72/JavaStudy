package java008_Stack;

import java.util.*;

public class StackExamTest01 {

	public static void main(String[] args) {

		Stack<Integer> st1=new Stack<Integer>();
		
		int num=13; //�������� �� 10����
		int div=2; //������ �� 2���� 
		
		//�������� ���� st1�� ���ʴ�� �ֱ� 
		while (num!=0) {
			st1.push(num%div);
			num/=div;
		}
		//st1�� ���� ���������� ������ ����ϱ� 
		while (!st1.isEmpty()) {
			System.out.print(st1.pop());
		}
	}

}
