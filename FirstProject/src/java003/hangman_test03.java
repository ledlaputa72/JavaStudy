package java003;

import java.util.Scanner;

public class hangman_test03 {

	public static void main(String[] args) { 
		
		// ����� ���� �ܾ ���� �Է��ϰ�, �ܾ� ��*2��ŭ�� �õ��ȿ� �ܾ ��� ���߾�� 
		
		 //���� Ǭ ���� Ǯ�� + ���� �ܾ� �Է�
        Scanner sc1=new Scanner(System.in);
		
        System.out.println("���� �ܾ �Է��ϼ��� ");
        
        String q1=sc1.next(); // �ܾ� �Է�
        // System.out.println(q1); 
        
        // ���� �Է� string�� char�� ����  
        char[] arr1=q1.toCharArray();//String arr1�� char�� ��ȯ
        
        for (int i = 0; i < arr1.length; i++) { // �ܾ� ���
        	System.out.print(arr1[i]+",");
		}
        System.out.println();
        System.out.println("�ܾ��� ����"+arr1.length); // �ܾ��� ���� 
        System.out.println("�õ� ��ȸ : "+arr1.length*2);
        
        char[] arr2=new char[arr1.length]; //String arr2�� char�� ��ȯ
        for (int i = 0; i < arr2.length; i++) {
			arr2[i]='_';
		}
//        for (int i = 0; i < arr2.length; i++) { // �ܾ� ���
//        	System.out.print(arr2[i]+",");
//		}
//        System.out.println();
        
        //2. �õ� Ƚ�� ī��Ʈ
        int count=0; //Ƚ�� �õ� ī��Ʈ
        int success=arr2.length; //���� Ƚ�� �Ǵ� 0�̸� ����, �迭 ������ �ι�
        
        //3. ���� ��
        for (int i = 0; i < arr2.length*2; i++) { // ��ü �õ� Ƚ��
             
             if (success!=0) { //���� ���� �Ǵ�.
                  
                  // ���� ��
                  for (int j = 0; j < arr2.length; j++) {
                        System.out.print(arr2[j]+" "); //����  ���(���� ����)
                  }
                  System.out.println();
             
                  //3. �Է� ���� �ޱ�
                  
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
            	 //���� ��� Ȯ��
                  for (int j = 0; j < arr2.length; j++) {
                	  System.out.print(arr2[j]);
				}
                  System.out.println();                  
            	  System.out.println("�����߽��ϴ�.");        
                  break;
             } //if end �������� �Ǵ�.
        } // for end ��ü �õ� Ƚ��
        
        if (count==arr2.length*2) {
             System.out.println("�õ�Ƚ���� ��� �������ϴ�.");                
        }
        
        
	}//main end

}//class end
