package Java011_Test;

public class MagicSquareEx {

	public static void main(String[] args) {
		
		int num=1;
		int n=3;//3���� �迭
		int[][] arr=new int[n][n]; //3 * 3
		int h=0, y=n/2; //0�� ����� (0,1) h�� ��, y�� ��
		
		arr[h][y] = num; //1�ֱ� (0,1)�� 1�ֱ�
		for(num=2; num<=n*n; num++) { //1�� �־����� 2���� 
			if (num%n==1) {//���� ��Ģ���� ���� �����. �� ���� ������ ���� �������� 1�ΰ� "��%n==1"
				h++; //���� 1����
			}else if (h==0) { //������ ��(ù��), 1->2, 8->9 
				h=n-1; //���� n(3)-1=2��(����)
				y++; //�� 1����
			}else if (y==(n-1)) { //�� �����ʿ� ��(����), 2->3, 7->8
				h--; 
				y=0;
			}else { //�׿��� �Ϲ� ��Ģ, ���� -1, ���� +1�̵�  
				h--; 
				y++;
			}
			arr[h][y]=num;
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
