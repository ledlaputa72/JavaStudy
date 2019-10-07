package Day027_Hash;

import java.util.*;
//재귀 알고리즘 - 하노이 타워 - 스택 
public class StackExam01 {

	public static void main(String[] args) {
		
		Stack <String> st1 = new Stack <String>();
		
		//Stack 구조의 입력 push
		st1.push("카레");
		st1.push("볶음밥");
		st1.push("뚝불고기");
		System.out.println(st1.size());
		
		//Stack 구조가 아닌 일반 출력 결과
		System.out.println("====== Iterator 로 출력");
		Iterator <String> itr1= st1.iterator(); //Iterator는 Stack 구조가 아니다. 
		while (itr1.hasNext()) {
			System.out.println(itr1.next()); //카레- 볶음밥 - 뚝불고기로 나온다. 
		}
		
		//Stack 구조로 출력되는 pop 출력
		System.out.println("====== pop으로 출력");
		while(!st1.isEmpty()) {
			System.out.println(st1.pop());
		}
		
	}

}
