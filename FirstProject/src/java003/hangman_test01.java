package java003;

import java.util.Scanner;

public class hangman_test01 {

	public static void main(String[] args) {
		
		// ������ ���� Ǯ�� - �Ʒ� �ٽ� Ȯ�� �ʿ� ����� �� �޾� �� 
		
		String [] moonja={"p","i","c","t","u","r","e"};
       String [] jool={"_","_","_","_","_","_","_"};
	   String ip;
         
	   int cnt,sw=0;
	   
       for(int j=0; j<7;j++) //ó�� �� ���
           System.out.print(jool[j]);
       System.out.println();
       
       Scanner scan1=new Scanner(System.in);
       
       for(int i=1;i<=13;i++){ //13�� üũ 
    	 cnt=0;  
   	     System.out.println("��������Է�:"); 
         ip=scan1.next(); //////// 	 
   
	     for(int j=0; j<7;j++){ //������ڰ� �����ܾ �־�?
       	   if(ip.equals(moonja[j])) 
       		        jool[j]=moonja[j];
         }
	     
         for(int j=0; j<7;j++) //�ְ� ���� ���� �����
              System.out.print(jool[j]);//�����	
         System.out.println("\t"+i+"���õ�");
        
         for(int j=0; j<7;j++){ //�����ܾ�� �ٱ��ڰ�  7�� ����? 
        	   if(jool[j].equals(moonja[j]))
        		        cnt++;
         }
         
         if(cnt == 7){ //�׷��� �� ���߾����� ������
              System.out.println("�µ�");
              sw=1;/////////////////
        	  break;	   
         }
         
      }//13-for-end 
       
         if(sw==0)
              System.out.print("������ȸ��");
		
	}//main end
}// class end
