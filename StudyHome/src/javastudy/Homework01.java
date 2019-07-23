package javastudy;

public class Homework01 {

	public static void main(String[] args) {
		
		// 모래시계 만들기 
		// 역 정삼각형
        for (int i = 5; i >= 1; i--) {
            for (int j = 0; j < 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k<= i*2-1; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }
        // 정삼각형
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k <= i*2-1; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }
        

        // 다이아몬드 만들기 
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k <= i*2-1; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }
        
        for (int i = 5; i >= 1; i--) {
            for (int j = 0; j < 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k<= i*2-1; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }
        
        
        
	}

}
