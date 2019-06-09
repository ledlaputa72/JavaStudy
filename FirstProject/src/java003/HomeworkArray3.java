package java003;

public class HomeworkArray3 {

	public static void main(String[] args) {

		// 1)우상 0데이터   
		System.out.println("1)우상 0데이터  ");
		System.out.println();
		
		int[][] arr1=new int[3][3];
		int count1=0;
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < i+1; j++) {
				count1++;
				arr1[i][j]=count1;
			}
		}
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("================");
		
		// 2)우하 0데이터 
		System.out.println("2)우하 0데이터 ");
		System.out.println();
		
		int[][] arr2=new int[3][3];
		int count2=0;
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < 3-i; j++) {
				count2++;
				arr2[i][j]=count2;
			}
		}
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr2[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("================");
		
		// 3)좌상 0데이터  
		System.out.println("3)좌상 0데이터 ");
		System.out.println();
		
		int[][] arr3=new int[3][3];
		int count3=0;
		
		for (int i = 0; i < arr3.length; i++) {
			for (int j = arr3.length-1; j >= arr3.length-1-i; j--) {
				count3++;
				arr3[i][j]=count3;
			}
		}
		
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr3[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("================");
		
		// 4)좌하 0데이터  
		System.out.println("4)정좌하 0데이터 ");
		System.out.println();
		
		int[][] arr4=new int[3][3];
		int count4=0;
		
		for (int i = 0; i < arr4.length; i++) {
			for (int j = arr4.length-1; j >= i; j--) {
				count4++;
				arr4[i][j]=count4;
			}
		}
		
		for (int i = 0; i < arr4.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr4[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("================");
	}

}
