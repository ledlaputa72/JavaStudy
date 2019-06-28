package Java011_Homework;

public class RainArray {

	public static void main(String[] args) {

		int num=1;
		int n=5;
		int[][] arr=new int[n][n]; 
		int h=0, y=0;
		
		arr[h][y] = num;
		for(num=2; num<=n*n; num++) { 
			if (h==(n-1)) {
				h=y+1;
				y=n-1;
			}
			else if (y==0) {
				y=h+1;
				h=0;
			}
			else {
				h++;
				y--;
			}
			arr[h][y]=num;
		}
		
		//Ãâ·Â
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
		
		
	}

}
