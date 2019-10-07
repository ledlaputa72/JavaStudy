package step01_TCP_SC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
  
public class EchoServer {
  
 public static void main(String[] args) {
   
  ServerSocket serverSocket = null;
  BufferedReader br = null;
  BufferedWriter bw = null;
  Socket socket = null;
  int portNumber = 9999; // Port ��ȣ
  
   
  try {
   /////////////////////////////////////////////////////////////////////////////
   //            1. portNumber �� ������� �ϴ� ���� ����                    //
   /////////////////////////////////////////////////////////////////////////////
   serverSocket = new ServerSocket(portNumber);
    
   System.out.println("Server �غ� �Ϸ�");
   /////////////////////////////////////////////////
    
    
    
   ////////////////////////////////////////////////////////////////////////////////////////////
   //    2. Client�� �����û ���, ����Ǹ� Client Socket �� ������� - ���� ���    //
   ////////////////////////////////////////////////////////////////////////////////////////////
   while(true) {
    socket = serverSocket.accept();
    System.out.println("Client�� ����Ǿ����ϴ�.");
     
    //////////////////////////////////////////////////////////////////////////
    //                   3. Client ���� ������ �޽��� �ޱ�                       //
    //////////////////////////////////////////////////////////////////////////
    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    //////////////////////////////////////////////////////////////////////////
  
     
    ///////////////////////////////////////////////////////////////////
    //                   4. Client ���� ������ �޽��� ���              //
    ///////////////////////////////////////////////////////////////////
    String msg = br.readLine();
     
    System.out.println("Client ���� ���� �޽��� : " + msg);
    ///////////////////////////////////////////////////////////////////
  
  
    ///////////////////////////////////////////////////////////////////////////
    //  5. Client ���� ������ �޽��� Client �� ������(Server->Client)   //
    ///////////////////////////////////////////////////////////////////////////
    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
     
    bw.write(msg + "\n"); // \n : �ٹٲ�
    bw.flush(); // ��� ���۸� ���� �޼���
    ///////////////////////////////////////////////////////////////////////////
  
   }
   /////////////////////////////////////////////////////////////////////////////  
    
  } catch (IOException e) {
   e.printStackTrace();
  } finally {
   try {
    br.close();
   } catch (IOException e) {
    e.printStackTrace();
   }
   try {
    bw.close();
   } catch (IOException e) {
    e.printStackTrace();
   }
   try {
    socket.close();
   } catch (IOException e) {
    e.printStackTrace();
   }
  }
 }
  
}

