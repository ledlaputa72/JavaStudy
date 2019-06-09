package java003;

public class HomeworkArray2 {

	public static void main(String[] args) {
		// 3)역열 정행  - 2중 배열 		
		System.out.println("3)역열 정행 - 2중 배열 ");
		System.out.println();

		int[][] arr3=new int[3][3];
		int count3=0;
		
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 2; j >= 2-i ; j--) {
				count3++;
				arr3[i][j]=count3;
			}
		}
		
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.print(arr3[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("================");
		
		// 7) 역열 역행 - 2중 배열
		System.out.println("7) 역열 역행 - 2중 배열 ");
		System.out.println();
		
		int[][] arr7=new int[3][3];
		int count7=0;
		
		for (int i = 2; i >=0 ; i--) {
			for (int j = 2; j >=i; j--) {
				count7++;
				arr7[i][j]=count7;
			}
		}
		
		for (int i = 0; i < arr7.length; i++) {
			for (int j = 0; j < arr7.length; j++) {
				System.out.print(arr7[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("================");
	}

}
