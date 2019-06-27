package Java011_Test;

public class ExamTest02 {

	public static void main(String[] args) {

		//random 함수 생성
		int[] number=new int[10];
		
		for (int i = 0; i < number.length; i++) {
			number[i]=(int)(Math.random()*100);
			System.out.println(number[i]);
		}
		minNumberFind(number); //작은수 찾기 메소드
	}//main end

	//메소드/////////////////////////////////////////
	private static void minNumberFind(int[] number) {

		int minNumber=number[0];
		for (int i = 1; i < number.length; i++) {
			if(minNumber>number[i]) { //minNumber 보다 작은 값이 나오면 교체
				minNumber=number[i];
			}
		}//for end
		System.out.println("=============");
		System.out.println("가장 작은수 : "+minNumber);
		
	} //minNumberFind end

}//class end
