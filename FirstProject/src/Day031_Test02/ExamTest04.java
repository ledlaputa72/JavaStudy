package Day031_Test02;

public class ExamTest04 {

	public static void main(String[] args) {

		int num1=1; //첫 숫자 1
		int n=3; // 차수
		int[][] arr=new int[n][n]; //처리할 배열
		int h=0, y=n/2; //중앙 행과 열
		
		arr[h][y]=num1; //1번 값 (중앙)
		for (num1 = 2; num1 <= n*n; num1++) {//2부터
			//해당 숫자를 어떤 행열에 넣을지 판단
			if(num1%n==1) {//예외 처리 차수%차수==1
				h++; //1행 아래로
			}
			else if(h==0) {//젤 윗 행 
				h=n-1;//맨 아래 행으로 
				y++;//1증가
			}
			else if(y==(n-1)) {//젤 마지막 열
				h--; //1행 위로
				y=0;//맨 앞열
			}
			else {//그외에 
				h--; //1행 위로 
				y++; //1열 옆으로 
			}
			//계산된 행열에 해당된 숫자를 입력 
			arr[h][y]=num1;
		}		
		//출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}

}
