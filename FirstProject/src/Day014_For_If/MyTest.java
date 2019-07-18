package Day014_For_If;

public class MyTest {

	public static void main(String[] args) {
		// À§ »ï°¢Çü
		 for (int i = 0; i <= 5; i++) {
			 for (int j = 1; j <= 5-i; j++) {
				System.out.print(" ");
			}
			 for (int k = 1; k <= i*2+1; k++) {
					System.out.print("*");
				}
			 System.out.println();
		 }
		 
		 System.out.println("###########");
		 // ¿ª »ï°¢Çü 
		 for (int i = 5; i <= 0; i--) {
			 for (int j = 1; j >=5; j++) {
				System.out.print(" ");
			}
			 for (int k = 1; k >= i*2+1; k++) {
					System.out.print("*");
				}
			 System.out.println();
		 }
		
		 
	}

}
