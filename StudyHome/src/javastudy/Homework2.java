package javastudy;

public class Homework2 {

	public static void main(String[] args) {

		
		// ���ﰢ�� �⺻
		System.out.println("���簢�� �⺻");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
           }
            System.out.println();
       }   
        
        System.out.println(" ");
        
        //���ﰢ�� Ȯ��
		System.out.println("���簢�� Ȯ��");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k <= i; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }
  
        System.out.println(" ");
        
        
        // �� ���ﰢ�� �⺻ 
		System.out.println("�����簢�� �⺻");
		for (int i = 5; i >= 1; i--) {
            for (int k = 1; k<= i; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }        
        
        System.out.println(" ");
        
		// �� ���ﰢ�� Ȯ��
		System.out.println("���簢�� Ȯ��");
		for (int i = 5; i >= 1; i--) {
            for (int j = 0; j < 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k<= i; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }
		

        
	}

}
