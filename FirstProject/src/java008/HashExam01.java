package java008;

import java.util.*;

public class HashExam01 {

	public static void main(String[] args) {
		/*Map map22=new HashMap(); //HashMap은 구조적으로 Map 아래에 위치해 있다. 에러 안남 
		
		HashMap hmap1 = new HashMap(); //key, value 사용 빠른 검색 
		         //key  //value  
		hmap1.put("id", "111"); //"id"가 key, "111"은 value
		hmap1.put("irum", "choi");
		hmap1.put("ipsail", new Date());
		hmap1.remove("ipsail");
		
		System.out.println(hmap1.get("irum"));*/
		
		//Genric을 사용한 예시 
		HashMap <Integer,String> hm1 = new HashMap <Integer,String>(); 
		//      <앞에는 정수, 뒤에는 스트링>
		System.out.println(hm1.size()); //0
					//key		//value
		hm1.put(new Integer(100), "멋쟁이"); //객체화 시킨 Integer를 사용 
		hm1.put(new Integer(300), "공주");
		hm1.put(new Integer(200), "왕자");
		
		System.out.println(hm1.get(300)); //value가 출력
		/*String s1=hm1.get(100);
		System.out.println(s1);*/
		System.out.println(hm1.get(100));
		System.out.println(hm1.get(200));
		
		hm1.remove(300);
		if (hm1.size()>0) {
			System.out.println(hm1.size()); //2, 하나 지워서 
		}
		
		
		//----------------------------------------
		//key 모음 출력
		Set<Integer> s1=hm1.keySet();
		System.out.println(s1);
		
		//value 모음 출력
		Collection <String> v1=hm1.values();
		System.out.println(v1);
		
		
		
	}
}
