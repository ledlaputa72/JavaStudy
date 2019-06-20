package java007_Date;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class CollectionStudy01 {

	public static void main(String[] args) {
		
		//선언 초기화//////////////
		Vector v7=new Vector(3); //3은 초기 값이나 가변적으로 조정된다.  
		
		//입력////////////////////
		v7.add(new Integer(100)); //wrapper //boxing 
		v7.add(new Integer(20));
		v7.add(new Integer(300));
		v7.add(new Integer(700));
		
		//출력/////////////////////
		for (int i = 0; i < v7.size(); i++) {
			System.out.print(v7.get(i)+"\t");
		}
		System.out.println();
		
		//정렬//////////////////////
		Object[] ob1=v7.toArray();//vector -> array. Sort 하기 위해 배열로 바꾸는 작업
		Arrays.sort(ob1); // 배열로 바꾼걸 정렬 
		for (int i = 0; i < ob1.length; i++) { //출력
			System.out.print(ob1[i]+"\t");
		}
		System.out.println();
		
		//종이상자/////////////////
		Enumeration e1=v7.elements(); //종이 박스 객체 
		
		while (e1.hasMoreElements()) {
			System.out.println(e1.nextElement());
		}
				
		
		
		
	}

}
