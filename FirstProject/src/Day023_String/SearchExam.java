package Day023_String;

import java.util.Scanner;

public class SearchExam {

	public static void main(String[] args) {

		String[] book= {"Apple and Jobs","American Dreams" ,"Book of Science", 
				"Computer Programming","Cooking for Dummy" ,
				"Naruto Mangga", "Music in My Life"};
		
		Scanner sc=new Scanner(System.in);
		System.out.println("ã�� å�� ù �ܾ �� �ܾ �Է��ϼ���");
		String search1=sc.next();
		//search1=search1.toUpperCase(); //�Է� �ܾ �빮�ڷ� �ٲ۴�. 
		
		for (int i = 0; i < book.length; i++) {
			//book[i]=book[i].toUpperCase(); //�迭�� å�̸��� �빮�ڷ� �ٲ۴�. 
			if(book[i].startsWith(search1))
			System.out.println("==>"+book[i]);
			if(book[i].endsWith(search1))
			System.out.println("==>"+book[i]);
				
		}
		
	}

}
