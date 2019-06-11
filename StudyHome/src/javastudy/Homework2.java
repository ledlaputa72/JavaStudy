package javastudy;

public class Homework2 {

	public static void main(String[] args) {

		
		// 직삼각형 기본
		System.out.println("직사각형 기본");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
           }
            System.out.println();
       }   
        
        System.out.println(" ");
        
        //직삼각형 확장
		System.out.println("직사각형 확장");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k <= i; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }
  
        System.out.println(" ");
        
        
        // 역 직삼각형 기본 
		System.out.println("역직사각형 기본");
		for (int i = 5; i >= 1; i--) {
            for (int k = 1; k<= i; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }        
        
        System.out.println(" ");
        
		// 역 직삼각형 확장
		System.out.println("역사각형 확장");
		for (int i = 5; i >= 1; i--) {
            for (int j = 0; j < 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k<= i; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }
		

        
	}

}
