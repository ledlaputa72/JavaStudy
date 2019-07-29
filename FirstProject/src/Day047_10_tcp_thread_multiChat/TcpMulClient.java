package Day047_10_tcp_thread_multiChat;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//Client Send Class/////////////////////////////////////////////
class ThreadClientSendClass extends Thread {
	
	Socket socket;
	DataOutputStream outputStream;
	String nickname;
	
	// �ʱ�ġ�� ���� ��ü, �г����� �Ѿ�´�.
	public ThreadClientSendClass(Socket socket, String nickname) throws IOException {

		this.socket = socket;
		this.nickname = nickname;
		
		outputStream = new DataOutputStream(socket.getOutputStream());
		
	}
	
	public void run() {
			
		Scanner in1 = new Scanner(System.in);
			
		try {
				
			if (outputStream != null)
				outputStream.writeUTF(nickname); // �г��� send
				
			while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io ��Ʈ���� ���� ���濡�� chat ������.
				
		} catch (IOException e) {
				
			e.printStackTrace();
		}
	}
		
}
	
//Client RCV Class////////////////////////////////////////
class ThreadClientRcvClass extends Thread {

	Socket socket;
	DataInputStream inputStream;
	JTextArea textArea;

	
	// ������
	public ThreadClientRcvClass(Socket socket, JTextArea textArea ) throws IOException {
		
		this.socket = socket;
		this.textArea =  textArea;
		
		inputStream = new DataInputStream(socket.getInputStream()); // read
		
	}
	
	public void run() {
		
		while (inputStream != null) {
			
			try {
				
				System.out.println(inputStream.readUTF());
				//textArea�� �����ֱ� ///////////////////////////////////////////
				
				textArea.setText(inputStream.readUTF());
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}

//main class
public class TcpMulClient extends JFrame{
	
	private JPanel contentPane;
	static JTextField textField;
	static JTextArea textArea; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		/*if (args.length != 3) {
			
			System.out.println("���� : Ŭ���̾�Ʈ������ \'java ��Ű����.���ϸ� ip�ּ� ��Ʈ��ȣ �г��� \' �������� �Է�");
			
			System.exit(1);
		}*/
		TcpMulClient jfmc = new TcpMulClient();
		jfmc.setVisible(true);
		
			
		try {

			
//			Socket s1 = new Socket(args[0], Integer.parseInt(args[1])); // ip �ּ�, ��Ʈ ��ȣ
			Socket s1 = new Socket("127.0.0.1", 9999); // ip �ּ�, ��Ʈ ��ȣ
			
			System.out.println("������ ����...");
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, "Test"); // �г���
			ThreadClientRcvClass tcr1 = new ThreadClientRcvClass(s1,textArea);
			
			Thread tsend1 = new Thread(tcc1); // ������ chat ����
			Thread trcv1 = new Thread(tcr1); // �޴� chat ����
			
			tsend1.start();
			trcv1.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}//main end
	
	//������ /////////////////////////////////////////////////
	public TcpMulClient() {
		
			JPanel panelTop = new JPanel();
			panelTop.setBackground(Color.CYAN);
			panelTop.setBounds(0, 0, 1184, 60);
			contentPane.add(panelTop);
			
			JPanel panelCanvas = new JPanel();
			panelCanvas.setBackground(Color.LIGHT_GRAY);
			panelCanvas.setBounds(0, 60, 800, 702);
			contentPane.add(panelCanvas);
			
			JPanel panelChat = new JPanel();
			panelChat.setBackground(Color.GRAY);
			panelChat.setBounds(800, 60, 384, 702);
			contentPane.add(panelChat);
			panelChat.setLayout(null);
			
			//////////////////////////////////////////
			
			textField = new JTextField();
			textField.setBounds(0, 664, 384, 38);
			panelChat.add(textField);
			textField.setColumns(10);
			
			textArea = new JTextArea();
			textArea.setBounds(0, 0, 384, 664);
			panelChat.add(textArea);
			////////////////////////////////////////////
			
			JPanel panelUsers = new JPanel();
			panelUsers.setBackground(Color.ORANGE);
			panelUsers.setBounds(0, 759, 1184, 180);
			contentPane.add(panelUsers);
		}//������ ����Ʈ 
}

