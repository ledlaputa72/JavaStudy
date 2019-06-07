package java003;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {

		int[] k= {10,30,24,78,9}; //정렬한 배열 
		
		/*
	    // Bubble 정렬 방법 1 - 기본형 (16번 반복)
		for (int i = 0; i < 4; i++) { //행 비교를 위해 4번을 비교 , i<k.length-1
			for (int j = 0; j < 4; j++) { // 열 비교를 위해 4번을 비교 , j<k.length-1
				if(k[j]<k[j+1]) { //앞에가 크거나 작으면 안바꾸나, 뒤가 크면 자리를 바꾼다. 
					int tmp=k[j]; //swap하기 위해 변수 tmp 생성
					k[j]=k[j+1];
					k[j+1]=tmp;
				}// if end
			}// for j end, if 비교를 4번(열)
		}//for i end, if 비교를 4*4번(행)
		*/
		
		/*
		//Bubble 정렬 방법 2 - 뒤쪽 중복 제거 계산 방법 (10번 방법)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4-i; j++) {//열에서 행으로 갈때 마다 하나씩 빼준다. 
                 if(k[j]<k[j+1]) {
                       int tmp=k[j];
                       k[j]=k[j+1];
                       k[j+1]=tmp;
                 }// if end
            }// for j end
       }//for i end
		*/
		
		/*
        //Bubble 정렬 방법 3 - 공식
        for (int i = 0; i < k.length-1; i++) {
            for (int j = 0; j < k.length-1-i; j++) {//열에서 행으로 갈때 마다 하나씩 빼준다. 
                 if(k[j]<k[j+1]) {
                       int tmp=k[j];
                       k[j]=k[j+1];
                       k[j+1]=tmp;
                 }// if end
            }// for j end
       }//for i end
        */
		
		
        //자바에서 제공하는 sort 함수 /////////////////
        int[] bae= {10,90,100,60,70}; 
        Arrays.sort(bae); // import 클래스 필요 , import java.util.Arrays; 오름차순

        
        ///////////////////////////////////////
		//정렬된 배열 출력 - 오름차순
		for (int i = 0; i < bae.length; i++) {
			System.out.print(bae[i]+"\t");
		}
		System.out.println();
		
		// 내림차순으로 찍을땐
		for (int i = bae.length-1; i>=0 ; i--) {
			System.out.print(bae[i]+"\t");
		}
		System.out.println();
		
		
	}// main end

}// class end
