package java003;

public class ArrayTest03 {

	public static void main(String[] args) {
		// �迭�� �ʱ�ȭ�� ���ÿ� �Ҷ� 
		// int [][] k = new int[2][3];
		
		int[][] k = {
				{10,20,30},
				{40,50,60}
				}; //int[][]k �ʱ�ȭ
		// int[][] k = {{10,20,30},{40,50,60}}; // ���� �̷��� �� �������ε� �����ϴ�. 
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(k[i][j]+"\t");
			}
			System.out.println();
		}//for end
		
		System.out.println("length�� �̿��� �࿭ ���� �ľ�");
		// �迭�� ���� 
		for (int i = 0; i < k.length; i++) { // ���� ���� �ľ�
			for (int j = 0; j < k[i].length; j++) { // ���� ���� �ľ�
				System.out.print(k[i][j]+"\t");
			}
			System.out.println();
		}//for end
		
	}// main end

}//lass end
