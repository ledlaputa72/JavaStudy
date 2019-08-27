package Day027_Hash;

import java.util.*;
//��� �˰��� - �ϳ��� Ÿ�� - ���� 
public class StackExam01 {

	public static void main(String[] args) {
		
		Stack <String> st1 = new Stack <String>();
		
		//Stack ������ �Է� push
		st1.push("ī��");
		st1.push("������");
		st1.push("�ҺҰ��");
		System.out.println(st1.size());
		
		//Stack ������ �ƴ� �Ϲ� ��� ���
		System.out.println("====== Iterator �� ���");
		Iterator <String> itr1= st1.iterator(); //Iterator�� Stack ������ �ƴϴ�. 
		while (itr1.hasNext()) {
			System.out.println(itr1.next()); //ī��- ������ - �ҺҰ��� ���´�. 
		}
		
		//Stack ������ ��µǴ� pop ���
		System.out.println("====== pop���� ���");
		while(!st1.isEmpty()) {
			System.out.println(st1.pop());
		}
		
	}

}
