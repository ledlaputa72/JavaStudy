package Day023_String;

import java.util.Scanner;

public class SearchExamTest03 {

	public static void main(String[] args) {

		String[] book= {"java Programming","C# Programming" ,"easy Java Programming", 
				"Master of JAVA",				
				"C Language and java","Power Builder","Oracle and Java-JDBC"};
		
		//�˻� �ܾ �Է¹ޱ�
		System.out.println("�˻���  �ܾ �Է��ϼ���");
		Scanner sc=new Scanner(System.in);
		String search=sc.next();
		
		int sw=1;
		System.out.println("----�˻����-----------------------");
		for (int i = 0; i < book.length; i++) {
			if (book[i].toUpperCase().indexOf(search.toUpperCase())!= -1) { 
				//�迭�� �ִ� ��� å�� �빮�ڷ� �ٲٰ� �˻� �ܾ �빮�ڷ� �ٲ㼭 �� �˻��ϴ� ����
				System.out.println(book[i]); //���ǿ��� �˻��� å�� ���
				sw=1; //�˻����� ���� ��� sw=1�� �� 
			}
		} //for end
		if(sw==0) {
			System.out.println("��� �����ϴ�. ");
		}
	}// main end
}//class end
