package study01;

public class Flaot01 {

	public static void main(String[] args) {
		double dnum = 3.14;
		float fnum = 3.14f;
		
		System.out.println(dnum);
		System.out.println(fnum);
		
		double dnum2 = 1;
		
		for(int i=0; i < 10000; i++) {
			dnum2 = dnum2 + 0.1;
		}
		System.out.println(dnum2);
	}

}
