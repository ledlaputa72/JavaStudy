package java003;

public class ArrayTest021 {

	public static void main(String[] args) {

		// 3*3 �迭 ����� 
		int[][] arr3=new int[3][3];
		int count=0; // ���� �࿡ ���� ������ �߰� 
		
		// �迭 �Է� 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr3[i][j]=(i+count)+j+1; //
			}
			count+=2; // i(��)�� ���� ���� ���� �߰� 
		}// �迭 �Է� �Ϸ� 		
		
		
		// �迭 ���
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr3[i][j]+"\t");
			}
			System.out.println();
		}// �迭 ��� �Ϸ� 
		
	} //main end

} //class end
