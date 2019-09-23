package Day018_Search_Hangman;

public class HomeworkArray {

	public static void main(String[] args) {
		// 1)정열 정행 - 2중 배열  
		System.out.println("1)정열 정행 - 2중 배열");
		System.out.println();
		
		int[][] arr1=new int[3][3];
		int count1=0;
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
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
		
		//2)정행 정열 - 2중 배열 
		System.out.println("2)정행 정열 - 2중 배열 ");
		System.out.println();

		int [][] arr2=new int[3][3];
		int count2=0;
		
		for (int j = 0; j < arr2.length; j++) {
			for (int i = 0; i < arr2.length; i++) {
				count2++;
				arr2[i][j]=count2;
			}
		}
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("================");
		
		// 3)역열 정행  - 2중 배열 		
		System.out.println("3)역열 정행 - 2중 배열 ");
		System.out.println();

		int[][] arr3=new int[3][3];
		int count3=0;
		
		for (int i = 0; i < arr3.length; i++) {
			for (int j = arr3[i].length-1; j >= 0 ; j--) {
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

		// 4)역행 정열  - 2중 배열 
		System.out.println("4) 역행 정열 - 2중 배열 ");
		System.out.println();

		int[][] arr4=new int[3][3];
		int count4=0;
		
		for (int j = 0 ; j < arr4.length ; j++) {
			for (int i = arr4.length-1; i >= 0; i--) {
				count4++;
				arr4[i][j]=count4;
			}
		}
	
		for (int i = 0; i < arr4.length; i++) {
			for (int j = 0; j < arr4.length; j++) {
				System.out.print(arr4[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("================");
		
		// 5) 정열 역행  - 2중 배열 
		System.out.println("5) 정열 역행 - 2중 배열 ");
		System.out.println();
		
		int[][] arr5= new int[3][3];
		int count5=0;
		
		for (int i = arr5.length-1; i >= 0 ; i--) {
			for (int j = 0; j < arr5[i].length; j++) {
				count5++;
				arr5[i][j]=count5;
			}
		}
		
		for (int i = 0; i < arr5.length; i++) {
			for (int j = 0; j < arr5[i].length; j++) {
				System.out.print(arr5[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("================");
		
		// 6) 정행 역열  - 2중 배열 
		System.out.println("6) 정행 역열  - 2중 배열 ");
		System.out.println();
		
		int[][] arr6=new int[3][3];
		int count6=0;
		
		for (int j = arr6.length-1; j >=0 ; j--) {
			for (int i = 0; i < arr6.length; i++) {
				count6++;
				arr6[i][j]=count6;
			}
		}
		
		for (int i = 0; i < arr6.length; i++) {
			for (int j = 0; j < arr6.length; j++) {
				System.out.print(arr6[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("================");

		// 7) 역열 역행 - 2중 배열
		System.out.println("7) 역열 역행 - 2중 배열 ");
		System.out.println();
		
		int[][] arr7=new int[3][3];
		int count7=0;
		
		for (int i = arr7.length-1; i >=0 ; i--) {
			for (int j = arr7[i].length-1; j >=0; j--) {
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
		
		
		// 8) 역행 역열 - 2중 배열 
		System.out.println("8) 역행 역열 - 2중 배열 ");
		System.out.println();
		
		int[][] arr8=new int[3][3];
		int count8=0;
		
		for (int j = arr8.length-1; j >=0 ; j--) {
			for (int i = arr8.length-1; i >=0; i--) {
				count8++;
				arr8[i][j]=count8;
			}
		}
		
		for (int i = 0; i < arr8.length; i++) {
			for (int j = 0; j < arr8.length; j++) {
				System.out.print(arr8[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("================");
	}

}
