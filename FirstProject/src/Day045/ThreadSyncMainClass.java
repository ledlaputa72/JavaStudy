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
			//���� ���� �����ϴ� ���� ���� �� lock(����ȭ)
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
	}//������ end 

	public static void main(String[] args) {
		tsc1 = new ThreadSyncClass();
		
		ThreadSyncMainClass smc1 = new ThreadSyncMainClass("����");
		ThreadSyncMainClass smc2 = new ThreadSyncMainClass("����");
		ThreadSyncMainClass smc3 = new ThreadSyncMainClass("����");
		smc1.start(); //main�� Thread�� 
		smc2.start();
		smc3.start();
	}//main end
	
	public void run() { //run()
		if (irum.equals("����")) {
			try {
				tsc1.kaja1("�氡�氡",irum);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (irum.equals("����")) {
			try {
				tsc1.kaja2("�ȳ��ϼ���",irum);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (irum.equals("����")) {
			try {
				tsc1.kaja3("�ݰ�����",irum);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}//run end
	
}//main class end
