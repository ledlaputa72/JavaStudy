package toyStore2;

import java.util.ArrayList;

public class Caculate extends Toys {

	//품목 출력 메소드
	public void printList(ArrayList<Toys> toyArr) {
		System.out.println("  ID |  이름     |  종류     |  가격 ");
		System.out.println("------------------------------");
		 for (int i = 0; i < toyArr.size(); i++) {
	            System.out.println(toyArr.get(i));
	       }
		 System.out.println("==============================");
	}
	//총합게 메소드
	public void sumTotal(ArrayList<Toys> toyArr) {
		 int sumToy=0;
		 int imsi=0;
		 for (int i = 0; i < toyArr.size(); i++) {
			 imsi=toyArr.get(i).gettPrice();
			 sumToy=sumToy+imsi;
		}
		 System.out.println("장남감 대여금 총 합계 : "+sumToy+"원");
	}

	//종류별 합계 메소드
	public void typeSum2(ArrayList<Toys> toyArr, String type) {
		
        int sumSearch=0;
        int imsi1=0;
        for (int i = 0; i < toyArr.size(); i++) {
       	if((toyArr.get(i).gettType())==type){
       		imsi1=toyArr.get(i).gettPrice();
               sumSearch=sumSearch+imsi1;
       		}  	
        }
        System.out.println(type+" 합계 : "+sumSearch);
		
	}//typeSum end
	
}
