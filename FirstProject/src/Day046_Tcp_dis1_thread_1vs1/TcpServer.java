package Day046_Tcp_dis1_thread_1vs1;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
//접근지정자에서 default - 같은 package scope를 갖는다.
class ThreadSend extends Thread {//주거니


    Socket s1;//from Client
    DataOutputStream dos1;//out -> 방가방가를 보낼것이므로
    //기본데이터타입별로 처리하기 (예) writeInt, writeUTF(문자열처리)
    String what1;


    ThreadSend(Socket s1) throws IOException {//생성자
        this.s1 = s1;
        dos1 = new DataOutputStream(s1.getOutputStream());
          // send를 위한 i/o 스트림
        what1 = "미팅중==>"; //대화시 앞에 항상 붙는 단어
         }
    
    public void run() {
        Scanner sc1 = new Scanner(System.in);//화면입력받아
        while (dos1 != null) {//chat 있으면
            try {
                dos1.writeUTF(what1 + sc1.nextLine());
                   //io 스트림을 통해 상대에게 chat 보내기
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }//while-end
    }//run-end
}//threadSend-end






class ThreadRcv extends Thread { //받거니
    Socket s1;
    DataInputStream dis1;
    //what1 = "미팅중==>" ---------> 보내는쪽이 처리하므로 안씀   
    ThreadRcv(Socket s1) throws IOException {
        this.s1 = s1;
        dis1 = new DataInputStream(s1.getInputStream());
    }
    public void run() {
        while (dis1 != null) {
            try {
                System.out.println(dis1.readUTF());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}


public class TcpServer {
    public static void main(String args[]) throws IOException {
         if(args.length !=1) {
             System.out.println("사용법은 java 파일명 포트번호");
             System.exit(1);
         }
         
         //listen
        ServerSocket ss1 = new ServerSocket(Integer.parseInt(args[0]));
                                                //포트번호 넣자는~~~
        System.out.println("서버 잘 준비됨 ...");


        while (true) {


            System.out.println("미팅 대화 기다리는 중....");


            Socket s1 = ss1.accept(); //connect를 받자
            
            //원해 여기는 receive send가 오는자리 , 대신 thread를 사용  
            ////////////////////////////  무전기 방식 아님
            ThreadSend tsendSer1 = new ThreadSend(s1);//초기치 ///주거니
            ThreadRcv trcvSer1 = new ThreadRcv(s1);///받거니를 위해


            tsendSer1.start();
            trcvSer1.start();
            ///////////////////////////////


        }
    }//메인-end


}//메인클래스-end

