package java008;

import java.util.*;

public class HashExam01 {

	public static void main(String[] args) {
		Map map22=new HashMap(); //HashMap은 구조적으로 Map 아래에 위치해 있다. 에러 안남 
		
		HashMap hmap1 = new HashMap(); //key, value 사용 빠른 검색 
		         //key  //value  
		hmap1.put("id", "111"); //"id"가 key, "111"은 value
		hmap1.put("irum", "choi");
		hmap1.put("ipsail", new Date());
		hmap1.remove("ipsail");
		
		System.out.println(hmap1.get("irum"));
	}
}
