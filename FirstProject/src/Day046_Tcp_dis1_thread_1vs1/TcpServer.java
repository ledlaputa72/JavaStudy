package Day046_Tcp_dis1_thread_1vs1;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
//���������ڿ��� default - ���� package scope�� ���´�.
class ThreadSend extends Thread {//�ְŴ�


    Socket s1;//from Client
    DataOutputStream dos1;//out -> �氡�氡�� �������̹Ƿ�
    //�⺻������Ÿ�Ժ��� ó���ϱ� (��) writeInt, writeUTF(���ڿ�ó��)
    String what1;


    ThreadSend(Socket s1) throws IOException {//������
        this.s1 = s1;
        dos1 = new DataOutputStream(s1.getOutputStream());
          // send�� ���� i/o ��Ʈ��
        what1 = "������==>"; //��ȭ�� �տ� �׻� �ٴ� �ܾ�
         }
    
    public void run() {
        Scanner sc1 = new Scanner(System.in);//ȭ���Է¹޾�
        while (dos1 != null) {//chat ������
            try {
                dos1.writeUTF(what1 + sc1.nextLine());
                   //io ��Ʈ���� ���� ��뿡�� chat ������
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }//while-end
    }//run-end
}//threadSend-end






class ThreadRcv extends Thread { //�ްŴ�
    Socket s1;
    DataInputStream dis1;
    //what1 = "������==>" ---------> ���������� ó���ϹǷ� �Ⱦ�   
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
             System.out.println("������ java ���ϸ� ��Ʈ��ȣ");
             System.exit(1);
         }
         
         //listen
        ServerSocket ss1 = new ServerSocket(Integer.parseInt(args[0]));
                                                //��Ʈ��ȣ ���ڴ�~~~
        System.out.println("���� �� �غ�� ...");


        while (true) {


            System.out.println("���� ��ȭ ��ٸ��� ��....");


            Socket s1 = ss1.accept(); //connect�� ����
            
            //���� ����� receive send�� �����ڸ� , ��� thread�� ���  
            ////////////////////////////  ������ ��� �ƴ�
            ThreadSend tsendSer1 = new ThreadSend(s1);//�ʱ�ġ ///�ְŴ�
            ThreadRcv trcvSer1 = new ThreadRcv(s1);///�ްŴϸ� ����


            tsendSer1.start();
            trcvSer1.start();
            ///////////////////////////////


        }
    }//����-end


}//����Ŭ����-end

