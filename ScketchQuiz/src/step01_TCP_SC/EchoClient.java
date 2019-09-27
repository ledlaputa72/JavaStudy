package step01_TCP_SC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
 
 
public class EchoClient {
 
 /**
  * @param args
  */
 public static void main(String[] args) {
  Socket socket = null;
  BufferedWriter bw = null; // ������ ����
  BufferedReader br = null; // ������ �б�
  String ipNumber = "127.0.0.1"; // ������ IP
  int portNumber = 9999; // ������ Port ��ȣ
  String msg = ""; // BufferedReader �� ����Ͽ� ���� �޽��� ����
   
  try {
    
   ////////////////////////////////////////////////////
   //           1. IP �ּ� �Է� ���� Ȯ��              //
   ////////////////////////////////////////////////////
			/* if(args.length != 2) {
			  System.out.println("Server IP, Port �Է� �ٶ��ϴ�.");
			  System.out.println("�߸��� �����̿��� ���α׷��� �����մϴ�.");
			  System.exit(0);
			 }
			 else {
			  ipNumber = args[0];
			  portNumber = Integer.parseInt(args[1]);
			 }*/
   ////////////////////////////////////////////////////
    
 
   System.out.println(ipNumber + " Server ���� ��");
 
    
   ////////////////////////////////////////////////
   //  2. Server ���� ������� Port �� ����   //
   ////////////////////////////////////////////////
   socket = new Socket(ipNumber, portNumber);
   ////////////////////////////////////////////
    
   System.out.println("Server ���� ����");
    
    
   ////////////////////////////////////////////////////////////////////////////
   //                             3. Server �� ������ ����                           //
   ////////////////////////////////////////////////////////////////////////////
   bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    
    

//   br = new BufferedReader(new InputStreamReader(System.in));
   msg = "������ �޽��� from Ŭ���̾�Ʈ";
   System.out.println("Client send message : "+msg);
   bw.write(msg + "\n");
   bw.flush(); // ��� ���۸� ���� �޼���(�ݵ�� ����� ��� ��)
    
   ////////////////////////////////////////////////////////////////////////////
    
 
   ////////////////////////////////////////////////////////////////////////////
   //         4. Server �� ���� �޽��� �ٽ� �ޱ�(Server -> Client)         //
   ////////////////////////////////////////////////////////////////////////////
   br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
   System.out.print("Server send message : " + br.readLine());
   ////////////////////////////////////////////////////////////////////////////
   System.out.println("");
    
    
    
  } catch (UnknownHostException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  } finally {
   try {
    br.close();
    bw.close();
    socket.close();
   } catch (IOException e) {
    e.printStackTrace();
   }
  }
 
 }
 
}


