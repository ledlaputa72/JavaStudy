package Day044_Thread;

class ThreeThreadClass1 extends Thread {
	
	private String kwail;
	
	//생성자
	public ThreeThreadClass1(String kwail) {
		this.kwail=kwail;
	}
	
	//run 메소드
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(this.kwail+"\t"+i+"개 주세요");
		}
	}
}

public class ThreeThreadMainClass1 {

	public static void main(String[] args) {
		//생성자 사용으로 처리 
		ThreeThreadClass1 ttc11 = new ThreeThreadClass1("사과");
		ThreeThreadClass1 ttc12 = new ThreeThreadClass1("배");
		ThreeThreadClass1 ttc13 = new ThreeThreadClass1("감");
		
		//우선순위 : priority // 자바쓰레드 1-10범위
		ttc11.setPriority(ttc11.MIN_PRIORITY); //1
		//ttc11.setPriority(2); //1~10
		ttc12.setPriority(ttc12.NORM_PRIORITY); //default 5
		ttc13.setPriority(ttc13.MAX_PRIORITY); //10
		
		System.out.println(ttc11.getPriority()+"\t"+ttc12.getPriority()+"\t"+ttc13.getPriority());
		
		ttc11.start();
		ttc12.start();
		ttc13.start();
	}

}
