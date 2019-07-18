package Day017_Array_Sort;

public class ArrayTest021 {

	public static void main(String[] args) {

		// 3*3 배열 만들기 
		int[][] arr3=new int[3][3];
		int count1=0; // 
		
		// 문제 1- 배열 입력 방법
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				count++;
//				arr3[i][j]=count1; //
//			}
//		}// 문제1 배열 입력 완료
		
		// 문제 2 - 배열 입력 방법 
//		for (int j = 0; j < 3; j++) {
//			for (int i = 0; i < 3; i++) {
//				count++;
//				arr3[i][j]=count1; //
//			}
//		}// 문제2 배열 입력 완료
		
		// 문제3 - 배열 입력 방법
//		for (int i = 0; i < 3; i++) {
//			for (int j = 2; j >= 0; j--) {
//				count1++;
//				arr3[i][j]=count1; //
//			}
//		}// 문제3 배열 입력 완료
		
		// 문제4 - 배열 입력 방법
//		for (int j = 2; j >= 0; j--) {
//			for (int i = 2; i >= 0; i--) {
//				count1++;
//				arr3[i][j]=count1; //
//			}
//		}// 문제3 배열 입력 완료	
		
		// 문제5 - 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < i+1; j++) {
				count1++;
				arr3[i][j]=count1; //
			}
		}// 문제5 배열 입력 완료
		
		
		// 배열 출력//////////////////////////////////
		System.out.println("=====================");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr3[i][j]+"\t");
			}
			System.out.println();
		}// 배열 출력 완료 
		
	} //main end

} //class end
