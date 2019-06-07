package java003;

public class ArrayTest021 {

	public static void main(String[] args) {

		// 3*3 배열 만들기 
		int[][] arr3=new int[3][3];
		int count=0; // 다음 행에 다음 증가값 추가 
		
		// 배열 입력 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr3[i][j]=(i+count)+j+1; //
			}
			count+=2; // i(행)에 대한 증가 값을 추가 
		}// 배열 입력 완료 		
		
		
		// 배열 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr3[i][j]+"\t");
			}
			System.out.println();
		}// 배열 출력 완료 
		
	} //main end

} //class end
