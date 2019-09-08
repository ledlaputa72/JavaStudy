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
  int portNumber = 9999; // Port 번호
  
   
  try {
   /////////////////////////////////////////////////////////////////////////////
   //            1. portNumber 를 기반으로 하는 소켓 생성                    //
   /////////////////////////////////////////////////////////////////////////////
   serverSocket = new ServerSocket(portNumber);
    
   System.out.println("Server 준비 완료");
   /////////////////////////////////////////////////
    
    
    
   ////////////////////////////////////////////////////////////////////////////////////////////
   //    2. Client의 연결요청 대기, 연결되면 Client Socket 이 만들어짐 - 무한 대기    //
   ////////////////////////////////////////////////////////////////////////////////////////////
   while(true) {
    socket = serverSocket.accept();
    System.out.println("Client가 연결되었습니다.");
     
    //////////////////////////////////////////////////////////////////////////
    //                   3. Client 에서 보내온 메시지 받기                       //
    //////////////////////////////////////////////////////////////////////////
    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    //////////////////////////////////////////////////////////////////////////
  
     
    ///////////////////////////////////////////////////////////////////
    //                   4. Client 에서 보내온 메시지 출력              //
    ///////////////////////////////////////////////////////////////////
    String msg = br.readLine();
     
    System.out.println("Client 에서 보낸 메시지 : " + msg);
    ///////////////////////////////////////////////////////////////////
  
  
    ///////////////////////////////////////////////////////////////////////////
    //  5. Client 에서 보내온 메시지 Client 로 보내기(Server->Client)   //
    ///////////////////////////////////////////////////////////////////////////
    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
     
    bw.write(msg + "\n"); // \n : 줄바꿈
    bw.flush(); // 출력 버퍼를 비우는 메서드
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

