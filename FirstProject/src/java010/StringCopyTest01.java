package java010;

import java.io.*;

public class StringCopyTest01 {

	public static void main(String[] args) throws IOException {

		FileReader fr2=new FileReader("e:/copy.txt"); //������ ����
        BufferedReader br2=new BufferedReader(fr2); //���ۿ� ����
//        BufferedReader br2=new BufferedReader(new FileReader("e:/copy.txt")); //���
        
        FileWriter fw2=new FileWriter("e:/paste.txt", false); //���� ������ ����
        BufferedWriter bw2=new BufferedWriter(fw2); //���ۿ� ����
        PrintWriter pw2=new PrintWriter(bw2, true); 
//        PrintWriter pw2 = new PrintWriter(new BufferedWriter (new FileWriter("e:/paste.txt", false)),true); //���
        
        String st2 =null;
        while ((st2=br2.readLine())!=null) { //br2 ������ ������ �ҷ��� st2�� �ϳ��� �����Ѵ�. 
             pw2.println(st2); //st2�� ����� ������ pw2 ���۸� ���� ���Ͽ� ����Ѵ�. 
             System.out.println(st2); //������ Ȯ���� ���� ���ؼ� 
        }
        
        br2.close(); fw2.close();pw2.close();
        
	}

}
