package java003;

public class ArrayTest03 {

	public static void main(String[] args) {

		// int [][] k = new int[2][3];
		
		int[][] k = {
				{10,20,30},
				{40,50,60}
				}; //int[][]k √ ±‚»≠
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(k[i][j]+"\t");
			}
			System.out.println();
		}//for end
		
	}// main end

}//lass end
