package javastudy;

public class CastChange {

	public static void main(String[] args) {
		//Integer.paseInt(String��)
		//Integer.valueOf(String��)

		String s_num = "10";
		int i_num = Integer.parseInt(s_num); //String -> Int 1�����
		int i_num2 = Integer.valueOf(s_num); //String -> Int 2�����
		
		System.out.println(s_num);
		System.out.println(i_num);
		System.out.println(i_num2);
	}

}
