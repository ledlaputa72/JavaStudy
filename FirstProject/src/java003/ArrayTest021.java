package java003;

public class ArrayTest021 {

	public static void main(String[] args) {

		// 3*3 배열 만들기 
		int[][] arr3=new int[3][3];
		//int count=0; // 다음 행에 다음 증가값 추가, 1,2번 문제용 
		int count=4; // 다음 행에 다음 증가값 추가 , 3번 문제용

		
		/*
		// 문제 1- 배열 입력 방법2
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				count++;
				arr3[i][j]=count; //
			}
		}
		*/
		
		/*
		// 문제 2 - 배열 입력 방법 
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				count++;
				arr3[i][j]=count; //
			}
		}
		*/
		
		// 문제3 - 배열 입력 문제 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				count--;
				arr3[i][j]=count; //
			}
			count+=6;
		}		
		
		// 배열 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr3[i][j]+"\t");
			}
			System.out.println();
		}// 배열 출력 완료 
		
	} //main end

} //class end
