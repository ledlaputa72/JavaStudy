package java008_Stack;

import java.util.*;

public class StackExamTest01 {

	public static void main(String[] args) {

		Stack<Integer> st1=new Stack<Integer>();
		
		int num=13; //나눠지는 값 10진수
		int div=2; //나누는 수 2진수 
		
		//나머지와 몫을 st1에 차례대로 넣기 
		while (num!=0) {
			st1.push(num%div);
			num/=div;
		}
		//st1의 값을 위에서부터 꺼내와 출력하기 
		while (!st1.isEmpty()) {
			System.out.print(st1.pop());
		}
	}

}
