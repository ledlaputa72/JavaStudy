package Day031_Test02;

public class ExamTest04 {

	public static void main(String[] args) {

		int num1=1; //ù ���� 1
		int n=3; // ����
		int[][] arr=new int[n][n]; //ó���� �迭
		int h=0, y=n/2; //�߾� ��� ��
		
		arr[h][y]=num1; //1�� �� (�߾�)
		for (num1 = 2; num1 <= n*n; num1++) {//2����
			//�ش� ���ڸ� � �࿭�� ������ �Ǵ�
			if(num1%n==1) {//���� ó�� ����%����==1
				h++; //1�� �Ʒ���
			}
			else if(h==0) {//�� �� �� 
				h=n-1;//�� �Ʒ� ������ 
				y++;//1����
			}
			else if(y==(n-1)) {//�� ������ ��
				h--; //1�� ����
				y=0;//�� �տ�
			}
			else {//�׿ܿ� 
				h--; //1�� ���� 
				y++; //1�� ������ 
			}
			//���� �࿭�� �ش�� ���ڸ� �Է� 
			arr[h][y]=num1;
		}		
		//���
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}

}
