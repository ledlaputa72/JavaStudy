package Day027_Hash;

import java.util.*;

public class StackExamTest01 {

	public static void main(String[] args) {

        int num=13; //나눠지는 값 10진수
        int m,n;
        
        Stack<Integer> st1=new Stack<Integer>();
        
        //나머지와 몫을 st1에 차례대로 넣기
        while (num!=0) {
             m=num/2;
             n=num%2;
             st1.push(n); // st1.push(num%2);
             num=m; // num=num/2; ==> num/=2;
        }
        //st1의 값을 위에서부터 꺼내와 출력하기
        while (!st1.isEmpty()) {
             System.out.print(st1.pop());
        }
	}

}
