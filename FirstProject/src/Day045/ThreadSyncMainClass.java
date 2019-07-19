package Day045;

class ThreadSyncClass{
	
	synchronized void kaja1(String insa, String irum) throws InterruptedException{
//	public void kaja1(String insa, String irum) throws InterruptedException{
		System.out.print(irum+" : ");
		char[] insaCH=insa.toCharArray();
		for (int i = 0; i < insaCH.length; i++) {
			System.out.print(insaCH[i]);
			Thread.sleep(100);
		}
		System.out.println();
	}//kaja1 end

	synchronized void kaja2(String insa, String irum) throws InterruptedException{
//	public void kaja2(String insa, String irum) throws InterruptedException{
		System.out.print(irum+" : ");
		char[] insaCH=insa.toCharArray();
		for (int i = 0; i < insaCH.length; i++) {
			System.out.print(insaCH[i]);
			Thread.sleep(100);
		}
		System.out.println();
	}//kaja2 end

//	synchronized void kaja3(String insa, String irum) throws InterruptedException{
	public void kaja3(String insa, String irum) throws InterruptedException{
		synchronized(this) { //synchronized block 
			//지금 블럭을 실행하는 동안 지금 블럭 lock(동기화)
		System.out.print(irum+" : ");
		char[] insaCH=insa.toCharArray();
		for (int i = 0; i < insaCH.length; i++) {
			System.out.print(insaCH[i]);
			Thread.sleep(100);
		}
		System.out.println();
		} //synchronized end
	}//kaja3 end
} // ThreadSyncClass end

public class ThreadSyncMainClass extends Thread{
	
	String irum;
	static ThreadSyncClass tsc1;
	
	public ThreadSyncMainClass(String string) {
		this.irum=string;
	}//생성자 end 

	public static void main(String[] args) {
		tsc1 = new ThreadSyncClass();
		
		ThreadSyncMainClass smc1 = new ThreadSyncMainClass("유은");
		ThreadSyncMainClass smc2 = new ThreadSyncMainClass("태희");
		ThreadSyncMainClass smc3 = new ThreadSyncMainClass("현정");
		smc1.start(); //main도 Thread임 
		smc2.start();
		smc3.start();
	}//main end
	
	public void run() { //run()
		if (irum.equals("유은")) {
			try {
				tsc1.kaja1("방가방가",irum);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (irum.equals("태희")) {
			try {
				tsc1.kaja2("안녕하세요",irum);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (irum.equals("현정")) {
			try {
				tsc1.kaja3("반가워용",irum);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}//run end
	
}//main class end
