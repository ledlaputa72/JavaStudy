package Day018_Search_Hangman;

public class SearchAndArray {

	public static void main(String[] args) {

		int[] k1= {100,200,300,55,78,97,67};
		int[] k2= {100,200,300,55,78,97,67};
		
		// �޼ҵ� 2�������� 
		kaja1(k1[0],k1[1]); //������ ������ ������ ��� ������ �� - call by value
		
		// �迭�� ��ǥ���� �� �迭�� ���� �����̴�. 
		kaja2(k2); // call by reference - k[0]��° �ּҸ� �����Ѵ�. 
	}

	// Call by Value �޼��� ���� �ޱ� 
	private static void kaja1(int i, int j) { // call by value ��� 
		int tot1=i+j;
		System.out.println(tot1);
	}
	
	// Call by Reference �޼��� ���� �ޱ� 
	private static void kaja2(int[] k2) {
		int tot2=0;
		for (int i = 0; i < k2.length; i++) {
			tot2+=k2[i];	
			System.out.print(k2[i]+"+");
		}
		System.out.println();
		System.out.println(tot2);
	}


}
