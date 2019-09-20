package step01_TCP_SC3_Thread;

import java.io.*;
import java.net.*;

public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		
		
		try {
			ServerSocket ss1=new ServerSocket(9999);
			System.out.println("���� ����� ....");
			
			while(true) {
				Socket s1=ss1.accept();
				System.out.println("������ ���� : "+s1.toString());
				
				//�̹��� �ޱ� <--  ���� //////////////////////////////////////////
				DataInputStream dis1=new DataInputStream(s1.getInputStream()); //��Ʈ�p���� �̹��� �ޱ� 
				
				int len1=dis1.readInt(); //������ ���� ���� ���� ����  �޾ƿ�
				byte[] byteArr1=new byte[len1]; //���̸�ŭ �迭�� ����
				dis1.readFully(byteArr1); //dis1���� ���� ������ byteArr�� ���� 
				System.out.println("�̹��� ����....");
				
				System.out.println("Ŭ�󿡼� ���� ���� : "+ byteArr1); //��Ʈ������ ���� Ŭ���̾�Ʈ�� ���� ��� 		
				/////////////////////////////////////////////////////////////////
				
				//�̹��� ������ --> Ŭ�� /////////////////////////////////////////
				DataOutputStream dos1=new DataOutputStream(s1.getOutputStream()); //��Ʈ�p���� �̹��� ������
				
				//������ ó�� - byte �迭 �̿� //////////////////////
//				byteArr2= new byte[byteArr1.length];	//���� ���̸�ŭ �迭 ���� 
				
				//�ڷ� ������ 
				dos1.writeInt(byteArr1.length);
				dos1.write(byteArr1);
				System.out.println("�̹��� ����....");
				
				System.out.println("������ ���� ���� : "+ byteArr1); //��Ʈ������ Ŭ�󿡼� �޾� �ٽ� �������� Ŭ��� ���� ���� 
				////////////////////////////////////////////////////////////////				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
