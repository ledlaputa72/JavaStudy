package Java011_Homework;

public class RainArray02 {

	public static void main(String[] args) {
		
		int num=1;
		int n=5;
		int[][] arr=new int[n][n]; 
		
		for (int Spin = 0; Spin < n*2-1; Spin++) {
			for (int i = 0; i < arr.length; i++) { //�౸�ϱ�
				int j=Spin-i;
				
				num++;
				arr[i][j]=num;
			}
		}
		
	}

}
