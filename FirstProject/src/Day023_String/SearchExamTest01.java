package Day023_String;

public class SearchExamTest01 {

	public static void main(String[] args) {
		String moonja="loVE";
		kaja(moonja);
		
		char ch1=moonja.charAt(1);
		if(Character.isDigit(ch1))
			System.out.println("숫자네");
		else
			System.out.println("숫자 아니네");
	}

	//문제 풀이
	  private static void kaja(String moonja) {
		  for (int i = 0; i < 4; i++) {
			  if (i<2) {
				  String bb=moonja.toUpperCase();
				  System.out.print(bb.charAt(i)+"\t");
			  }
		  else if(i>=2){
			  String cc=moonja.toLowerCase();
			  System.out.print(cc.charAt(i)+"\t");
			  }
		  }
	  }
	 
	/*	
		// 선생님 문제 풀이
		  private static void kaja(String moonja) {
		      for(int i=0; i < moonja.length(); i++){
		            if(Character.isLowerCase(moonja.charAt(i)))
		                 Character.toUpperCase(moonja.charAt(i));
		            else
		                 Character.toLowerCase(moonja.charAt(i));
		            }
		      System.out.println(moonja);
		   }
	 */
	
}
