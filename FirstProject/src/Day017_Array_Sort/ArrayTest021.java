package Day017_Array_Sort;

public class ArrayTest021 {

	public static void main(String[] args) {

		// 3*3 �迭 ����� 
		int[][] arr3=new int[3][3];
		int count1=0; // 
		
		// ���� 1- �迭 �Է� ���
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				count++;
//				arr3[i][j]=count1; //
//			}
//		}// ����1 �迭 �Է� �Ϸ�
		
		// ���� 2 - �迭 �Է� ��� 
//		for (int j = 0; j < 3; j++) {
//			for (int i = 0; i < 3; i++) {
//				count++;
//				arr3[i][j]=count1; //
//			}
//		}// ����2 �迭 �Է� �Ϸ�
		
		// ����3 - �迭 �Է� ���
//		for (int i = 0; i < 3; i++) {
//			for (int j = 2; j >= 0; j--) {
//				count1++;
//				arr3[i][j]=count1; //
//			}
//		}// ����3 �迭 �Է� �Ϸ�
		
		// ����4 - �迭 �Է� ���
//		for (int j = 2; j >= 0; j--) {
//			for (int i = 2; i >= 0; i--) {
//				count1++;
//				arr3[i][j]=count1; //
//			}
//		}// ����3 �迭 �Է� �Ϸ�	
		
		// ����5 - 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < i+1; j++) {
				count1++;
				arr3[i][j]=count1; //
			}
		}// ����5 �迭 �Է� �Ϸ�
		
		
		// �迭 ���//////////////////////////////////
		System.out.println("=====================");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr3[i][j]+"\t");
			}
			System.out.println();
		}// �迭 ��� �Ϸ� 
		
	} //main end

} //class end
