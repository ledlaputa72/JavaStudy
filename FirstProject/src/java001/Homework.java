package java001;

public class Homework {

	public static void main(String[] args) {
		// 역삼각형
        for (int i = 5; i >= 1; i--) {
            for (int j = 0; j < 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k<= i; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }
        //모래시계
        for (int i = 5; i >= 1; i--) {
            for (int j = 0; j < 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k<= i*2-1; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5-i; j++) {
                System.out.print(" ");
           }
            for (int k = 1; k <= i*2-1; k++) {
                      System.out.print("*");
                }
            System.out.println();
       }
		
	}

}
