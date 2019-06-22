package java008;

import java.util.*;

public class HashMapEx1 {

	public static void main(String[] args) {
		
		//저장된 쌍 데이터
		HashMap map=new HashMap();
		        //key		//value
		map.put("ledlaputa","1234");
		map.put("Jay","1111");
		map.put("yuniluv","1015");
		
		Scanner s=new Scanner(System.in);
		 
		while (true) { //무한루프 
			System.out.println("id와  password를 입력해 주세요");
			System.out.println("id : ");
			String id=s.nextLine().trim();
			
			System.out.println("Password : ");
			String password=s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) { //key값을 비교 
				System.out.println("입력하신  id가 존재하지 않습니다." + "다시 입력해 주세요 ");
				continue; //다시 처음으로 
			}
			else { // key값이 맞으면 
				if(!(map.get(id)).equals(password)){ //value값 비교 
					System.out.println("비밀번호가 일치하지 않습니다. 다시입력해 주세요");
				}
				else {
					System.out.println("id와  비밀번호가 일치합니다.");
					 break;
				}
			}			
		} //while end
	} //main end
}
