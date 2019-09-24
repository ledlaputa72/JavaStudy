package step03_TCP_SC3_cSend_sRcv_sSend_cRcv2;

import java.awt.AWTException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientRcvClass {

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub
		
		Socket s1=new Socket("127.0.0.1", 7777);
		System.out.println("접속완료 - 클라이언트");
		
		TestFrameClass ClientRcv=new TestFrameClass(); //그림 그리기 작동
		ClientRcv.setVisible(true);
		
		while(true) {
			ThreadRcv tr = new ThreadRcv(s1,ClientRcv);
			tr.start();
		}

	}

}
