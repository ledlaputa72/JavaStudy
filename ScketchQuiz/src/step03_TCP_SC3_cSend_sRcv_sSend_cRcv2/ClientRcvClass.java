package step03_TCP_SC3_cSend_sRcv_sSend_cRcv2;

import java.awt.AWTException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientRcvClass {

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub
		
		Socket s1=new Socket("127.0.0.1", 7777);
		System.out.println("���ӿϷ� - Ŭ���̾�Ʈ");
		
		TestFrameClass ClientRcv=new TestFrameClass(); //�׸� �׸��� �۵�
		ClientRcv.setVisible(true);
		
		while(true) {
			ThreadRcv tr = new ThreadRcv(s1,ClientRcv);
			tr.start();
		}

	}

}
