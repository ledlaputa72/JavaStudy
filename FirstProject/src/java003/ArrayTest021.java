package java003;

public class ArrayTest021 {

	public static void main(String[] args) {

		// 3*3 �迭 ����� 
		int[][] arr3=new int[3][3];
		//int count=0; // ���� �࿡ ���� ������ �߰�, 1,2�� ������ 
		int count=4; // ���� �࿡ ���� ������ �߰� , 3�� ������

		
		/*
		// ���� 1- �迭 �Է� ���2
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				count++;
				arr3[i][j]=count; //
			}
		}
		*/
		
		/*
		// ���� 2 - �迭 �Է� ��� 
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				count++;
				arr3[i][j]=count; //
			}
		}
		*/
		
		// ����3 - �迭 �Է� ���� 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				count--;
				arr3[i][j]=count; //
			}
			count+=6;
		}		
		
		// �迭 ���
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr3[i][j]+"\t");
			}
			System.out.println();
		}// �迭 ��� �Ϸ� 
		
	} //main end

} //class end
