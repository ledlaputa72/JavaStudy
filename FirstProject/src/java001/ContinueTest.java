package java001;

public class ContinueTest {

	public static void main(String[] args) {

		// continue문 연습 
		int flag=0;
		int cnt=0;
		while (flag==0) {
			cnt++;
			if(cnt==10) { // break 조건
			System.out.println("오늘 그만팔고 장사 끝~");	
				break; // 반복문을 완전히 빠져 나간다.
			}
			if(cnt==3) {
			System.out.println("가자 while문으로 ");	
				continue; // 취소하고 다시 반복문 처음으로 돌아간다.
			}
			System.out.println("커피한잔"+ cnt);
		}
		
	}

}
