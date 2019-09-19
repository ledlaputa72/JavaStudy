package step01_TCP_SC3_Thread;

import java.net.*;
import java.io.*;

public class CilentMainClass {

	public static void main(String[] args) throws IOException {
		
		File file1=new File("aa.png");
		File file2=new File("aa10.png");
		
		try {
			Socket s1=new Socket("127.0.0.1", 9999);
			
			//���� �̹��� �Է� (�Է� �ҽ��� �ޱ�) ���� Ȥ�� ȭ��
			DataInputStream dis1=new DataInputStream(new  FileInputStream(file1)); //������
			
			//Ŭ���̾�Ʈ���� ������ �������� /////////////////////////////////////
			DataOutputStream dos1=new DataOutputStream(s1.getOutputStream()); //��Ʈ�p���� �̹��� ������
			
			//������ ó�� - byte �迭 �̿� ///
			byte[] byteArr1=new byte[(int)file1.length()];
			System.out.println("file ---> byte��...");
			
			//�ڷ� �ޱ� 
			dis1.readFully(byteArr1); //���ϳ��� -->����Ʈ�迭
			
			//�ڷ� ������ 
			dos1.writeInt(byteArr1.length);
			dos1.write(byteArr1);
			System.out.println("���ۿϷ�...");
			
			System.out.println("������ ���� ���� : "+ byteArr1); //Ŭ�󿡼� ������ ���� ����  
			////////////////////////////////////////////////////////////////
			
			
			//�������� �� �޽��� //////////////////////////////////////////////
			//DataInputStream dis1=new  DataInputStream(s1.getInputStream());
			DataInputStream dis2=new  DataInputStream(s1.getInputStream());
			
			int len1=dis2.readInt(); //������ ���� ���� ���� ����  �޾ƿ�
			byte[] byteArr2=new byte[len1]; //���̸�ŭ �迭�� ����
			dis2.readFully(byteArr2); //�׸��� ������ �޾� ����Ʈ�迭��
			
			FileOutputStream fos1=new FileOutputStream(file2);
			fos1.write(byteArr2);
			System.out.println("����Ϸ�...");
			
			System.out.println("�������� ���� ���� : " + byteArr2);
			///////////////////////////////////////////////////////////////////
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ŭ���̾�Ʈ ��");
	}

}
