package java008;

import java.util.*;

public class HashMapEx1 {

	public static void main(String[] args) {
		
		//����� �� ������
		HashMap map=new HashMap();
		        //key		//value
		map.put("ledlaputa","1234");
		map.put("Jay","1111");
		map.put("yuniluv","1015");
		
		Scanner s=new Scanner(System.in);
		 
		while (true) { //���ѷ��� 
			System.out.println("id��  password�� �Է��� �ּ���");
			System.out.println("id : ");
			String id=s.nextLine().trim();
			
			System.out.println("Password : ");
			String password=s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) { //key���� �� 
				System.out.println("�Է��Ͻ�  id�� �������� �ʽ��ϴ�." + "�ٽ� �Է��� �ּ��� ");
				continue; //�ٽ� ó������ 
			}
			else { // key���� ������ 
				if(!(map.get(id)).equals(password)){ //value�� �� 
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ��Է��� �ּ���");
				}
				else {
					System.out.println("id��  ��й�ȣ�� ��ġ�մϴ�.");
					 break;
				}
			}			
		} //while end
	} //main end
}
