package Java011_Test;

public class ExamTest01 {

	public static void main(String[] args) {
		
		/*String love=args[0]; //ù��° ����
		System.out.println("ù���� ���ڴ� ");
		System.out.println(love);
		String[] loveArr=love.split("-"); //���ڷ� ���� String�� �迭�� ������. 
		
		int star=Integer.parseInt(args[1]); //�ι��� ���ڸ� star ������ �ְ� if ����
		if (star==1) {
			loveArr[2]="LEE"; //3��° �ܾ ��ü
		}else if(star==2) {
			loveArr[1]="loves-sm-than"; //2��° �ܾ ��ü
		}
		else {
			loveArr[2]="LEE";
		}
		System.out.println("�ι�° ���ڴ� : "+star);
		System.out.println(loveArr[0]+"-"+loveArr[1]+"-"+loveArr[2]);*/
		
		
		 //stringBuffer�� ���� �ذ� ��� 
		StringBuffer s = new StringBuffer(args[0]);
		switch(Integer.valueOf(args[1]))
		{
		case 1:
			s.replace(9, 11,"LEE");
			break;
		case 2:
			s.replace(3, 8, "loves-sm-than");
			break;
		default:
			s.append(" LEE");
			break;				
		}
		System.out.println(s);
		
	}

}
