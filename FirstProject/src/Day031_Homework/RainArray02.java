package Day031_Homework;

public class RainArray02 {

	public static void main(String[] args) {
		
		int num=0;
		int n=5;
		int[][] arr=new int[n][n]; 
		
        for(int SPIN=0;SPIN < 9;SPIN++ ){  //0~8 : 9ȸ�� : �밢��
            for(int i=0;i < arr.length;i++){ //0~4 : 5ȸ�� : ��
                int j=SPIN-i; //��                
                if(j>=0&&j<5){ //0���� ũ�ų� ���� 5���� ���� ��쿡
                    num=num+1;
                    arr[i][j] = num;
                }
            }  
        }
		//���
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
		
	}

}
