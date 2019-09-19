package Day023_String;

import java.util.Scanner;

public class SearchExamTest03 {

	public static void main(String[] args) {

		String[] book= {"java Programming","C# Programming" ,"easy Java Programming", 
				"Master of JAVA",				
				"C Language and java","Power Builder","Oracle and Java-JDBC"};
		
		//검색 단어를 입력받기
		System.out.println("검색할  단어를 입력하세요");
		Scanner sc=new Scanner(System.in);
		String search=sc.next();
		
		int sw=1;
		System.out.println("----검색결과-----------------------");
		for (int i = 0; i < book.length; i++) {
			if (book[i].toUpperCase().indexOf(search.toUpperCase())!= -1) { 
				//배열에 있는 모든 책을 대문자로 바꾸고 검색 단어도 대문자로 바꿔서 비교 검색하는 조건
				System.out.println(book[i]); //조건에서 검색된 책을 출력
				sw=1; //검색에서 없는 경우 sw=1로 됨 
			}
		} //for end
		if(sw==0) {
			System.out.println("재고가 없습니다. ");
		}
	}// main end
}//class end
