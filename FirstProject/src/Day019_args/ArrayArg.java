package Day019_args;

public class ArrayArg {
	//��ɾ�� ����� ���� ����� 
	//��ɾ� 30 80 >> args[0]="30", args[1]="80"
	
	public static void main(String[] args) {
		//��ɾ��� ���� �޾��ֱ�
		if (args.length != 3) { //args �迭�� ���̰� 3���� ���� ������  
			System.out.println("���� ���� ���� �ʽ��ϴ�. ");
			System.out.println("������ : ��ɾ� [����1] [����2] [����3] ");
			System.exit(1); //���� ���� 
			// return; // return�ڿ� �ƹ��͵� ������ ���� ���� C, Java, C# ���
			// C��� : exit(1); ���� ���Ḧ �ǹ�, (0)��������
			// C# : Environment.Exit(1); ���� ���� 
		}
		 //String -> Int�� ����ȯ
		System.out.println(Integer.parseInt(args[0])
				+Integer.parseInt(args[1])
				+Integer.parseInt(args[2]));
	}

}
