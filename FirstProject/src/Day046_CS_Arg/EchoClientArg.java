package Day046_CS_Arg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClientArg {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		if(args.length != 2) { //������ڰ� 2�� IP/port 
			System.out.println("����: ��ɾ����ڷ� ��Ʈ��ȣ�� ��������");
			System.exit(0);
		}
		
		Scanner sc1=new Scanner(System.in);
		
		Socket s = new Socket(args[0], Integer.parseInt(args[1])); //IP/port ���ڸ� �޴´�. 
		
		BufferedReader br1= new BufferedReader(new InputStreamReader(s.getInputStream())); //���� �Է� --> ���� ������ 
		// ���۸��� ��ü = new ���۸���(new ��ǲ��Ʈ������(�ҽ�));

		BufferedWriter bw1= new BufferedWriter(new OutputStreamWriter(s.getOutputStream())); //���� ��� <-- �������� �޾ƿ��� 
		
		System.out.println(br1.readLine()); // �޾ƿ� br1�ҽ��� ��� 
		
		while (true) {
			//���� �Է� --> ������ ���� 
			System.out.println("���ڸ� �־��");
			String bada1forServer = sc1.nextLine(); //�Է��� ���ڸ� ���� 
			if(bada1forServer.length()==0)   break; //���� ���ڰ� ������ ������ 
			bw1.write(bada1forServer, 0, bada1forServer.length());
			//server�� ���� // Ű���� �������� 0��°���� ��� ���̸�ŭ ���δ� ���� 
			
			//���� ���<-- �������� �޾ƿ� 
			bw1.newLine();
			bw1.flush(); 
			String bada2fromServer = br1.readLine(); //serve�� ���� ����  (�� ���۵帮��) 
			System.out.println("�����κ��� �ٽ� �Դٴ� "+ bada2fromServer);
		}
		s.close();
		//���� ������ Ŭ���̾�Ʈ 
	}

}
