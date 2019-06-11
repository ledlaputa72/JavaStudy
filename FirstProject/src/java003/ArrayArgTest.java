package java003;

public class ArrayArgTest {

	public static void main(String[] args) {
		
        //��ɾ��� ���� �޾��ֱ�
        if (args.length != 2) { //args �迭�� ���̰� 3���� ����  ������  
             System.out.println("���� ���� ���� �ʽ��ϴ�. ");
             System.out.println("������ : ��ɾ� [����1]  [����2] ");
             System.exit(1); //���� ����
             // return; // return�ڿ� �ƹ��͵� ������ ���� ����  C, Java, C# ���
             // C��� : exit(1); ���� ���Ḧ �ǹ�, (0)��������
             // C# : Environment.Exit(1); ���� ����
        }
		
        System.out.println("�Է¹��� ���� 1 = "+args[0]+", �Է¹��� ���� 2 = "+args[1]);
        
        starPrint(args[0]);// ����� �޼ҵ� 
        strPrint(args[1]);// �ؽ�Ʈ ����Ʈ �޼ҵ�         
		
	}//main end

	private static void strPrint(String str1) {

		int str=Integer.parseInt(str1); // ���ڸ� ���ڷ� �ٲ��ֱ� 
		
		for (int i = 0; i < str+1; i++) {
			System.out.println("�Ƹ��ٿ� ���Դϴ�.!!");
		} // 2nd ���� ó�� end
	}

	private static void starPrint(String star1) {
		
        int star=Integer.parseInt(star1); // ���ڸ� ���ڷ� �ٲ��ֱ�
        
		for (int i = 0; i < star; i++) {
			
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		} // 1st ���� ó�� end
		
	}
	
	

}//class end
