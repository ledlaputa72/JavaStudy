package Java011_Homework;

public class RainArray01 {

	public static void main(String[] args) {

		int[][] arr=new int[5][5]; 
		int n=0;
		for (int b = 0; b < 9; b++) { //���ٱ� ����
			for (int i = 0; i < 5; i++) { //��
				for (int j = 0; j < 5; j++) { //��
					if (i+j==b) { //��+�� = ���ٱ� �ΰ�츸 n++�� �ϰ� �࿭�� ���� 
						n++;
						arr[i][j]=n;
					}
				}
			}
		}
		//���
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}

}
