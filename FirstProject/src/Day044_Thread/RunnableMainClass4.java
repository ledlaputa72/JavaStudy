package Day044_Thread;

class RunnableClass40 implements Runnable{
	
	private String str;

	//������
	public RunnableClass40() {
		this.str="����Ѵ�";
	}
	
	public RunnableClass40(String str) {
		this.str=str;
	}
	
	@Override
	public void run() {
		 for (int i = 1; i <= 10; i++) {
             System.out.println(i+"�� " + this.str);
             //�Ʒ� �����̸� �� ��� ��� ���̰� �߻�
             int time=((int)Math.ceil(Math.random()*5000));
			try {
			Thread.sleep(time);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			
        }
	}
}

public class RunnableMainClass4 {

	public static void main(String[] args) {
		Thread th41=new Thread(new RunnableClass40());//����Ʈ ������
		
		Thread th42=new Thread(new RunnableClass40("���̴�")); //������ �̿�
		
		th41.start();
		th42.start();
	}
}
