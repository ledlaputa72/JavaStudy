package java003;

public class ArrayTest02 {

	public static void main(String[] args) {

		int [][] arr2=new int[2][3];
		arr2[0][0]=10;
		arr2[1][2]=30;
		//arr2[2][3]=50; //����
		System.out.println(arr2[1][1]); // ���� 0����, 
		
		for (int i = 0; i < 2; i++) { 
			for (int j = 0; j < 3; j++) { 
				System.out.print(arr2[i][j]+"\t"); // \t�� ������ ����
			}
			System.out.println(); //�ٹٲ�
		}
		
	}// main end

}// class end
