package java003;

public class SortTest {

	public static void main(String[] args) {

		int[] k= {10,30,24,78,9}; //������ �迭 
		
		for (int i = 0; i < 4; i++) { //�� �񱳸� ���� 4���� ��  
			for (int j = 0; j < 4; j++) { // �� �񱳸� ���� 4���� �� 
				if(k[j]<k[j+1]) { //�տ��� ũ�ų� ������ �ȹٲٳ�, �ڰ� ũ�� �ڸ��� �ٲ۴�. 
					int tmp=k[j]; //swap�ϱ� ���� ���� tmp ����
					k[j]=k[j+1];
					k[j+1]=tmp;
				}// if end
			}// for j end, if �񱳸� 4��(��)
		}//for i end, if �񱳸� 4*4��(��)
		
		//���ĵ� �迭 ���
		for (int i = 0; i < k.length; i++) {
			System.out.print(k[i]+"\t");
		}
		System.out.println();
	}// main end

}// class end
