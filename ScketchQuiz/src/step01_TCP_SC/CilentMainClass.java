package step01_TCP_SC;

import java.net.*;
import java.io.*;

public class CilentMainClass {

	public static void main(String[] args) throws IOException {
		
		InetAddress ia=null;
		Socket soc=null;
		
		try {
			ia=InetAddress.getByName("localhost");
			soc=new Socket(ia, 12345);
			
			String msg="�ڹ� ��Ʈ��ũ ���α׷��Դϴ�."; //�������� ���� �� 
			
			//Ŭ���̾�Ʈ���� ������ �������� /////////////////////////////////////
			/*OutputStreamWriter osw=new OutputStreamWriter(soc.getOutputStream()); //soc(����)���� ������ ��������. 
			BufferedWriter bw=new BufferedWriter(osw); //���ۿ� ���� ������ ��Ʈ������ ������.  */	
					
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())); //soc�� ���� ��Ʈ��ũ�� ���� 
			bw.write(msg+"\n"); // ���� ������ ����Ѵ�. 
			bw.flush();//����ؼ� ������. 
			
			//�������� �� �޽��� //////////////////////////////////////////////
			BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String msg2=br.readLine();
			System.out.println("�������� ���۵� ���� : "+msg2); //���� ������ ����Ѵ�. 
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ŭ���̾�Ʈ ��");
	}

}
