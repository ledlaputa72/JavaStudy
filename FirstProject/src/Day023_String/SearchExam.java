package Day023_String;

import java.util.Scanner;

public class SearchExam {

	public static void main(String[] args) {

		String[] book= {"Apple and Jobs","American Dreams" ,"Book of Science", 
				"Computer Programming","Cooking for Dummy" ,
				"Naruto Mangga", "Music in My Life"};
		
		Scanner sc=new Scanner(System.in);
		System.out.println("찾을 책의 첫 단어나 끝 단어를 입력하세요");
		String search1=sc.next();
		//search1=search1.toUpperCase(); //입력 단어를 대문자로 바꾼다. 
		
		for (int i = 0; i < book.length; i++) {
			//book[i]=book[i].toUpperCase(); //배열의 책이름을 대문자로 바꾼다. 
			if(book[i].startsWith(search1))
			System.out.println("==>"+book[i]);
			if(book[i].endsWith(search1))
			System.out.println("==>"+book[i]);
				
		}
		
	}

}
