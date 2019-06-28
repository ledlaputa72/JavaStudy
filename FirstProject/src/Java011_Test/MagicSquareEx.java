package Java011_Test;

public class MagicSquareEx {

	public static void main(String[] args) {
		
		int num=1;
		int n=3;//3차수 배열
		int[][] arr=new int[n][n]; //3 * 3
		int h=0, y=n/2; //0행 가운데열 (0,1) h는 행, y는 열
		
		arr[h][y] = num; //1넣기 (0,1)에 1넣기
		for(num=2; num<=n*n; num++) { //1은 넣었으니 2부터 
			if (num%n==1) {//예외 규칙부터 먼저 물어본다. 들어갈 수를 차수로 나눠 나머지가 1인것 "수%n==1"
				h++; //행을 1증가
			}else if (h==0) { //맨위의 수(첫행), 1->2, 8->9 
				h=n-1; //끝행 n(3)-1=2행(끝행)
				y++; //열 1증가
			}else if (y==(n-1)) { //맨 오른쪽에 수(끝열), 2->3, 7->8
				h--; 
				y=0;
			}else { //그외의 일반 규칙, 행은 -1, 열은 +1이동  
				h--; 
				y++;
			}
			arr[h][y]=num;
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
