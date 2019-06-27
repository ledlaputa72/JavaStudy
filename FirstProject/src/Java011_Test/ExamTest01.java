package Java011_Test;

public class ExamTest01 {

	public static void main(String[] args) {
		
		/*String love=args[0]; //첫번째 인자
		System.out.println("첫번쨰 인자는 ");
		System.out.println(love);
		String[] loveArr=love.split("-"); //인자로 받은 String을 배열로 나눈다. 
		
		int star=Integer.parseInt(args[1]); //두번쨰 인자를 star 변수로 넣고 if 조건
		if (star==1) {
			loveArr[2]="LEE"; //3번째 단어를 교체
		}else if(star==2) {
			loveArr[1]="loves-sm-than"; //2번째 단어를 교체
		}
		else {
			loveArr[2]="LEE";
		}
		System.out.println("두번째 인자는 : "+star);
		System.out.println(loveArr[0]+"-"+loveArr[1]+"-"+loveArr[2]);*/
		
		
		 //stringBuffer를 통해 해결 방안 
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
