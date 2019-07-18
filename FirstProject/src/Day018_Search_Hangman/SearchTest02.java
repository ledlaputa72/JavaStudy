package Day018_Search_Hangman;

import java.util.Arrays;
import java.util.Random;

public class SearchTest02 {

	public static void main(String[] args) {
		 Random r1=new Random(); //2)Random 클래스  1)2)번중 아무거나 사용해도 무관
		int [] roto=new int[6];//배열에 6개 숫자 담기
		
		for (int i = 0; i < 6; i++) { //중복 배제 로직
			roto[i]=r1.nextInt(44)+1; //2)Random 클래스
//			roto[i]=(int)Math.ceil(45*Math.random()); // 1) Random 함수 
			for (int j = 0; j < i; j++) { 
				if(roto[i]==roto[j])
					i--;
			}
		} // for end
			
			Arrays.sort(roto);//소트 로직
			for (int j = 0; j < roto.length; j++) {
				System.out.print(roto[j]+"\t");
			}
			System.out.println();
			
	} //main end

} //class end
