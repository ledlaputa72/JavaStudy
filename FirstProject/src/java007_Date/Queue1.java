package java007_Date;

import java.util.*;

public class Queue1 {

	public static void main(String[] args) {
		// Collection �������̽� 
		// -->Queue(ť) �������̽� --> ��ӹ޾� ���� LinkedList Ŭ���� 
		
		Queue q1=new LinkedList(); //(o)
		
		q1.offer("�ٺ�");
		q1.offer("�´�");
		q1.offer("�򰭰���");
		System.out.println(q1.size()); //3
		
		Iterator itr1=q1.iterator();
		while (itr1.hasNext()) {
			String name1=(String) itr1.next();
			System.out.println(name1);
		}
		
		
		if (!q1.isEmpty()) {//q1�� ������� �ʳ�?
			q1.poll();
		}
		if (!q1.isEmpty()) {
			q1.poll();
		}
		q1.offer("ȫ�浿");
		System.out.println(q1.size()); //2 , �ٺ�, �´��� ������ �򰭰��� + �ڿ�  ȫ�浿�� �ִ�. 
		
	}

}
