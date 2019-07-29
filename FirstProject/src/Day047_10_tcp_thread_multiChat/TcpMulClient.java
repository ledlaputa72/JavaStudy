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
	
	// 초기치로 소켓 객체, 닉네임이 넘어온다.
	public ThreadClientSendClass(Socket socket, String nickname) throws IOException {

		this.socket = socket;
		this.nickname = nickname;
		
		outputStream = new DataOutputStream(socket.getOutputStream());
		
	}
	
	public void run() {
			
		Scanner in1 = new Scanner(System.in);
			
		try {
				
			if (outputStream != null)
				outputStream.writeUTF(nickname); // 닉네임 send
				
			while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io 스트림을 통해 상대방에게 chat 보낸다.
				
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

	
	// 생성자
	public ThreadClientRcvClass(Socket socket, JTextArea textArea ) throws IOException {
		
		this.socket = socket;
		this.textArea =  textArea;
		
		inputStream = new DataInputStream(socket.getInputStream()); // read
		
	}
	
	public void run() {
		
		while (inputStream != null) {
			
			try {
				
				System.out.println(inputStream.readUTF());
				//textArea로 보내주기 ///////////////////////////////////////////
				
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
			
			System.out.println("사용법 : 클라이언트실행은 \'java 패키지명.파일명 ip주소 포트번호 닉네임 \' 형식으로 입력");
			
			System.exit(1);
		}*/
		TcpMulClient jfmc = new TcpMulClient();
		jfmc.setVisible(true);
		
			
		try {

			
//			Socket s1 = new Socket(args[0], Integer.parseInt(args[1])); // ip 주소, 포트 번호
			Socket s1 = new Socket("127.0.0.1", 9999); // ip 주소, 포트 번호
			
			System.out.println("서버에 연결...");
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, "Test"); // 닉네임
			ThreadClientRcvClass tcr1 = new ThreadClientRcvClass(s1,textArea);
			
			Thread tsend1 = new Thread(tcc1); // 보내는 chat 위해
			Thread trcv1 = new Thread(tcr1); // 받는 chat 위해
			
			tsend1.start();
			trcv1.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}//main end
	
	//생성자 /////////////////////////////////////////////////
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
		}//생성자 디폴트 
}

