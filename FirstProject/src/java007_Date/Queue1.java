package java007_Date;

import java.util.*;

public class Queue1 {

	public static void main(String[] args) {
		// Collection 인터페이스 
		// -->Queue(큐) 인터페이스 --> 상속받아 만든 LinkedList 클래스 
		
		Queue q1=new LinkedList(); //(o)
		
		q1.offer("바보");
		q1.offer("온달");
		q1.offer("평강공주");
		System.out.println(q1.size()); //3
		
		Iterator itr1=q1.iterator();
		while (itr1.hasNext()) {
			String name1=(String) itr1.next();
			System.out.println(name1);
		}
		
		
		if (!q1.isEmpty()) {//q1이 비어있지 않나?
			q1.poll();
		}
		if (!q1.isEmpty()) {
			q1.poll();
		}
		q1.offer("홍길동");
		System.out.println(q1.size()); //2 , 바보, 온달은 나가고 평강공주 + 뒤에  홍길동이 있다. 
		
	}

}
