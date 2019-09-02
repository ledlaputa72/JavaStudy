package step01_TCP_SC;

import java.io.*;
import java.net.*;

public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=null;
		Socket soc=null;
		
		try {
			ss=new ServerSocket(12345);
			System.out.println("���� ����� ....");
			
			while(true) {
				soc=ss.accept();
				System.out.println("������ ���� : "+soc.toString());
				
				//���� �ޱ� /////////////////////////////////////////////////////////
				/*	InputStreamReader isr=new InputStreamReader(soc.getInputStream()); //���Ͽ��� ���� ������ �о�´�. 
					BufferedReader br=new BufferedReader(isr);  //�о�� ������ ���ۿ� ����Ѵ�. 
				*/		
				BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
				String msg=br.readLine();  //������ ������ �о msg�� �����ϱ� 
				System.out.println("Ŭ���̾�Ʈ���� ���۵� ���� : "+msg); //���� ������ ����Ѵ�. 
				
				//�������� ���� ������ �ٽ� Ŭ���̾�Ʈ�� �����ֱ� ///////////////////// msg  ������ ������. 
				BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())); //soc�� ���� ��Ʈ��ũ�� ���� 
				bw.write(msg+"\n"); // ���� ������ ����Ѵ�. 
				bw.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
