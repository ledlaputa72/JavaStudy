package java003;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {

		int[] k= {10,30,24,78,9}; //������ �迭 
		
		/*
	    // Bubble ���� ��� 1 - �⺻�� (16�� �ݺ�)
		for (int i = 0; i < 4; i++) { //�� �񱳸� ���� 4���� �� , i<k.length-1
			for (int j = 0; j < 4; j++) { // �� �񱳸� ���� 4���� �� , j<k.length-1
				if(k[j]<k[j+1]) { //�տ��� ũ�ų� ������ �ȹٲٳ�, �ڰ� ũ�� �ڸ��� �ٲ۴�. 
					int tmp=k[j]; //swap�ϱ� ���� ���� tmp ����
					k[j]=k[j+1];
					k[j+1]=tmp;
				}// if end
			}// for j end, if �񱳸� 4��(��)
		}//for i end, if �񱳸� 4*4��(��)
		*/
		
		/*
		//Bubble ���� ��� 2 - ���� �ߺ� ���� ��� ��� (10�� ���)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4-i; j++) {//������ ������ ���� ���� �ϳ��� ���ش�. 
                 if(k[j]<k[j+1]) {
                       int tmp=k[j];
                       k[j]=k[j+1];
                       k[j+1]=tmp;
                 }// if end
            }// for j end
       }//for i end
		*/
		
		/*
        //Bubble ���� ��� 3 - ����
        for (int i = 0; i < k.length-1; i++) {
            for (int j = 0; j < k.length-1-i; j++) {//������ ������ ���� ���� �ϳ��� ���ش�. 
                 if(k[j]<k[j+1]) {
                       int tmp=k[j];
                       k[j]=k[j+1];
                       k[j+1]=tmp;
                 }// if end
            }// for j end
       }//for i end
        */
		
		
        //�ڹٿ��� �����ϴ� sort �Լ� /////////////////
        int[] bae= {10,90,100,60,70}; 
        Arrays.sort(bae); // import Ŭ���� �ʿ� , import java.util.Arrays; ��������

        
        ///////////////////////////////////////
		//���ĵ� �迭 ��� - ��������
		for (int i = 0; i < bae.length; i++) {
			System.out.print(bae[i]+"\t");
		}
		System.out.println();
		
		// ������������ ������
		for (int i = bae.length-1; i>=0 ; i--) {
			System.out.print(bae[i]+"\t");
		}
		System.out.println();
		
		
	}// main end

}// class end
