package java003;

import java.util.Arrays;
import java.util.Random;

public class SearchTest02 {

	public static void main(String[] args) {
		 Random r1=new Random(); //2)Random Ŭ���� 
		int [] roto=new int[6];//�迭�� 6�� ���� ���
		
		for (int i = 0; i < 6; i++) { //�ߺ� ���� ����
			roto[i]=r1.nextInt(44)+1; //2)Random Ŭ����
//			roto[i]=(int)Math.ceil(45*Math.random()); // 1) Random �Լ� 
			for (int j = 0; j < i; j++) { 
				if(roto[i]==roto[j])
					i--;
			}
		} // for end
			
			Arrays.sort(roto);//��Ʈ ����
			for (int j = 0; j < roto.length; j++) {
				System.out.print(roto[j]+"\t");
			}
			System.out.println();
			
	} //main end

} //class end
