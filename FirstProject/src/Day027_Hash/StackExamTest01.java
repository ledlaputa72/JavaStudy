package Day027_Hash;

import java.util.*;

public class StackExamTest01 {

	public static void main(String[] args) {

        int num=13; //�������� �� 10����
        int m,n;
        
        Stack<Integer> st1=new Stack<Integer>();
        
        //�������� ���� st1�� ���ʴ�� �ֱ�
        while (num!=0) {
             m=num/2;
             n=num%2;
             st1.push(n); // st1.push(num%2);
             num=m; // num=num/2; ==> num/=2;
        }
        //st1�� ���� ���������� ������ ����ϱ�
        while (!st1.isEmpty()) {
             System.out.print(st1.pop());
        }
	}

}
