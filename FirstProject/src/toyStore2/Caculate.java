package toyStore2;

import java.util.ArrayList;

public class Caculate extends Toys {

	//ǰ�� ��� �޼ҵ�
	public void printList(ArrayList<Toys> toyArr) {
		System.out.println("  ID |  �̸�     |  ����     |  ���� ");
		System.out.println("------------------------------");
		 for (int i = 0; i < toyArr.size(); i++) {
	            System.out.println(toyArr.get(i));
	       }
		 System.out.println("==============================");
	}
	//���հ� �޼ҵ�
	public void sumTotal(ArrayList<Toys> toyArr) {
		 int sumToy=0;
		 int imsi=0;
		 for (int i = 0; i < toyArr.size(); i++) {
			 imsi=toyArr.get(i).gettPrice();
			 sumToy=sumToy+imsi;
		}
		 System.out.println("�峲�� �뿩�� �� �հ� : "+sumToy+"��");
	}

	//������ �հ� �޼ҵ�
	public void typeSum2(ArrayList<Toys> toyArr, String type) {
		
        int sumSearch=0;
        int imsi1=0;
        for (int i = 0; i < toyArr.size(); i++) {
       	if((toyArr.get(i).gettType())==type){
       		imsi1=toyArr.get(i).gettPrice();
               sumSearch=sumSearch+imsi1;
       		}  	
        }
        System.out.println(type+" �հ� : "+sumSearch);
		
	}//typeSum end
	
}
