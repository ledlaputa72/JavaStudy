package Day018_Search_Hangman;

public class SearchAndArray {

	public static void main(String[] args) {

		int[] k1= {100,200,300,55,78,97,67};
		int[] k2= {100,200,300,55,78,97,67};
		
		// 메소드 2형식으로 
		kaja1(k1[0],k1[1]); //인자의 갯수가 많을때 방법 문제가 됨 - call by value
		
		// 배열의 대표명은 그 배열의 시작 번지이다. 
		kaja2(k2); // call by reference - k[0]번째 주소를 전달한다. 
	}

	// Call by Value 메서드 인자 받기 
	private static void kaja1(int i, int j) { // call by value 방식 
		int tot1=i+j;
		System.out.println(tot1);
	}
	
	// Call by Reference 메서드 인자 받기 
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
