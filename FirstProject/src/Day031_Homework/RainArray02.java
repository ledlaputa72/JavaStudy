package Day031_Homework;

public class RainArray02 {

	public static void main(String[] args) {
		
		int num=0;
		int n=5;
		int[][] arr=new int[n][n]; 
		
        for(int SPIN=0;SPIN < 9;SPIN++ ){  //0~8 : 9회전 : 대각선
            for(int i=0;i < arr.length;i++){ //0~4 : 5회전 : 행
                int j=SPIN-i; //열                
                if(j>=0&&j<5){ //0보다 크거나 같고 5보다 작은 경우에
                    num=num+1;
                    arr[i][j] = num;
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
