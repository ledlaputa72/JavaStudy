package Java011_Test;

public class ExamTest02 {

	public static void main(String[] args) {

		//random �Լ� ����
		int[] number=new int[10];
		
		for (int i = 0; i < number.length; i++) {
			number[i]=(int)(Math.random()*100);
			System.out.println(number[i]);
		}
		minNumberFind(number); //������ ã�� �޼ҵ�
	}//main end

	//�޼ҵ�/////////////////////////////////////////
	private static void minNumberFind(int[] number) {

		int minNumber=number[0];
		for (int i = 1; i < number.length; i++) {
			if(minNumber>number[i]) { //minNumber ���� ���� ���� ������ ��ü
				minNumber=number[i];
			}
		}//for end
		System.out.println("=============");
		System.out.println("���� ������ : "+minNumber);
		
	} //minNumberFind end

}//class end
