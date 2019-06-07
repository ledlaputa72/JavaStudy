package java003;

public class ArrayTest03 {

	public static void main(String[] args) {
		// 배열과 초기화를 동시에 할때 
		// int [][] k = new int[2][3];
		
		int[][] k = {
				{10,20,30},
				{40,50,60}
				}; //int[][]k 초기화
		// int[][] k = {{10,20,30},{40,50,60}}; // 원래 이렇게 한 문장으로도 가능하다. 
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(k[i][j]+"\t");
			}
			System.out.println();
		}//for end
		
		System.out.println("length를 이용한 행열 길이 파악");
		// 배열의 길이 
		for (int i = 0; i < k.length; i++) { // 행의 길이 파악
			for (int j = 0; j < k[i].length; j++) { // 열의 길이 파악
				System.out.print(k[i][j]+"\t");
			}
			System.out.println();
		}//for end
		
	}// main end

}//lass end
