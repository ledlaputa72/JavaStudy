package Day018_Search_Hangman;

import java.util.Scanner;

public class hangman_test02 {

	 public static void main(String[] args) { 
         
		 //���� Ǭ ���� Ǯ�� 
		 
         //1. �迭�� picture �Է�
         char[] arr1={'p', 'i', 'c', 't', 'u', 'r', 'e'}; //  �迭�� �Է�
         char[] arr2= {'_','_','_','_','_','_','_'}; //����  ǥ��
         
         //2. �õ� Ƚ�� ī��Ʈ
         int count=0; //Ƚ�� �õ� ī��Ʈ
         int success=7; //���� Ƚ�� �Ǵ� 0�̸� ����
         
         //3. ���� ��
         for (int i = 0; i < 13; i++) { // ��ü �õ� Ƚ��
              
              if (success!=0) { //���� ���� �Ǵ�.
                   
                   // ���� ��
                   for (int j = 0; j < arr2.length; j++) {
                         System.out.print(arr2[j]+" "); //����  ���(���� ����)
                   }
                   System.out.println();
              
                   //3. �Է� ���� �ޱ�
                   Scanner sc1=new Scanner(System.in);
                   
                   System.out.print("������ �Է��ϼ��� : ");
                   String answer1=sc1.next();
                   char answer2 =answer1.charAt(0); //�Է¹���  ����
                   
                   //4. search�� �迭�� �Է� ���� ���� ��   arr1[0~7] == answer2
                   for (int  k= 0; k < arr1.length; k++) {  //���� ���ڿ� ������ ��
                         if (arr1[k]==answer2) { // �迭�� �Է�  ���� ���ڰ� ������
                              arr2[k]=arr1[k];
                              success--;
                              break;
                         }
                   }
                   count++;
                   System.out.println(count+"��  �õ��߽��ϴ�.");
                   // ���� �� ��
                   
              } // if success !=0 �ݺ�
              else {
                   System.out.println("�����߽��ϴ�.");        
                   break;
              } //if end �������� �Ǵ�.
         } // for end ��ü �õ� Ƚ��
         
         if (count==13) {
              System.out.println("�õ�Ƚ���� ��� �������ϴ�.");                
         }
   } //main end

}
