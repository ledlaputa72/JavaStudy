package java008;

import java.util.*;

public class HashExam01 {

	public static void main(String[] args) {
		/*Map map22=new HashMap(); //HashMap�� ���������� Map �Ʒ��� ��ġ�� �ִ�. ���� �ȳ� 
		
		HashMap hmap1 = new HashMap(); //key, value ��� ���� �˻� 
		         //key  //value  
		hmap1.put("id", "111"); //"id"�� key, "111"�� value
		hmap1.put("irum", "choi");
		hmap1.put("ipsail", new Date());
		hmap1.remove("ipsail");
		
		System.out.println(hmap1.get("irum"));*/
		
		//Genric�� ����� ���� 
		HashMap <Integer,String> hm1 = new HashMap <Integer,String>(); 
		//      <�տ��� ����, �ڿ��� ��Ʈ��>
		System.out.println(hm1.size()); //0
					//key		//value
		hm1.put(new Integer(100), "������"); //��üȭ ��Ų Integer�� ��� 
		hm1.put(new Integer(300), "����");
		hm1.put(new Integer(200), "����");
		
		System.out.println(hm1.get(300)); //value�� ���
		/*String s1=hm1.get(100);
		System.out.println(s1);*/
		System.out.println(hm1.get(100));
		System.out.println(hm1.get(200));
		
		hm1.remove(300);
		if (hm1.size()>0) {
			System.out.println(hm1.size()); //2, �ϳ� ������ 
		}
		
		
		//----------------------------------------
		//key ���� ���
		Set<Integer> s1=hm1.keySet();
		System.out.println(s1);
		
		//value ���� ���
		Collection <String> v1=hm1.values();
		System.out.println(v1);
		
		
		
	}
}
