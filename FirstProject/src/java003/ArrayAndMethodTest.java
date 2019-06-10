package java003;

import java.util.Arrays;

public class ArrayAndMethodTest {

	public static void main(String[] args) {

		String[] kwamok ={"Java", "C", "Python", "Oracle", "ResWEB", "Algo", "BigBATA"};
		kaja(kwamok);
	} //main end

	private static void kaja(String[] kwamok) {
		Arrays.sort(kwamok); // 정렬 함수 
		for (int i = kwamok.length-1; i >=0 ; i--) {
			System.out.print(kwamok[i]+"\t");
		}
		System.out.println();
	} //kaja end

}//class end
