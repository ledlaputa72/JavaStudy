package java008;

import java.util.*;

public class HashExam01 {

	public static void main(String[] args) {
		//Map map1=new HashMap();
		HashMap hmap1 = new HashMap(); //key, value ��� ���� �˻� 
		         //key  //value  
		hmap1.put("id", "111");
		hmap1.put("irum", "choi");
		hmap1.put("ipsail", new Date());
		hmap1.remove("ipsail");
		
		System.out.println(hmap1.get("irum"));
	}

}
