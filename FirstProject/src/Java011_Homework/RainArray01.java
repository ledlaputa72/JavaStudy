package Java011_Homework;

public class RainArray01 {

	public static void main(String[] args) {

		int[][] arr=new int[5][5]; 
		int n=0;
		for (int b = 0; b < 9; b++) { //빗줄기 갯수
			for (int i = 0; i < 5; i++) { //행
				for (int j = 0; j < 5; j++) { //열
					if (i+j==b) { //행+열 = 빗줄기 인경우만 n++로 하고 행열에 대입 
						n++;
						arr[i][j]=n;
					}
				}
			}
		}
		//출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}

}
