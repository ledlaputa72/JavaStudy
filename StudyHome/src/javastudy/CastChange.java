package javastudy;

public class CastChange {

	public static void main(String[] args) {
		//Integer.paseInt(String값)
		//Integer.valueOf(String값)

		String s_num = "10";
		int i_num = Integer.parseInt(s_num); //String -> Int 1번방식
		int i_num2 = Integer.valueOf(s_num); //String -> Int 2번방식
		
		System.out.println(s_num);
		System.out.println(i_num);
		System.out.println(i_num2);
	}

}
