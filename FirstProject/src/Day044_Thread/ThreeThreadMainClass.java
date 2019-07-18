package Day044_Thread;

class ThreeThreadClass extends Thread {
	
	private String kwail;
	
	//생성자
	public ThreeThreadClass(String kwail) {
		this.kwail=kwail;
	}
	
	//run 메소드
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(this.kwail+"\t"+i+"개 주세요");
		}
	}
}

public class ThreeThreadMainClass {

	public static void main(String[] args) {
		//생성자 사용으로 처리 
		ThreeThreadClass ttc1 = new ThreeThreadClass("사과");
		ThreeThreadClass ttc2 = new ThreeThreadClass("배");
		ThreeThreadClass ttc3 = new ThreeThreadClass("감");
		
		ttc1.start();
		ttc2.start();
		ttc3.start();
	}

}
