package Day045;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPMainClass {

	public static void main(String[] args) throws UnknownHostException {
		//Domain Adrress /////////////////////////////////////
		String juso="www.naver.com";
		InetAddress inet1=InetAddress.getByName(juso); //domain name���� �ּ� get 
		
		//IP address�� ����Ʈ �迭�� ��ȯ�ϰ� 255������ 10������ �ٲ��� 
		byte[] byte4=inet1.getAddress(); //11100111011100
		String change1="";
		for (int i = 0; i < byte4.length; i++) {
			if(byte4[i] < 0){
				change1=change1+(""+(byte4[i]+256));
	//			System.out.print((int)byte4[i]+""+"\t");
			}
			else {
				change1=change1+(""+byte4[i]);
			}
			change1=change1+".";
		}
		System.out.println(change1);
		System.out.println("------------------------------");
		//Domain Name���� ��� ���� ��� IP Adrress�� �˻��Ͽ� ��� 
		InetAddress [] inetArr1=InetAddress.getAllByName("www.naver.com");
		for (int i = 0; i < inetArr1.length; i++) {
			System.out.println(inetArr1[i]);
			System.out.println(inetArr1[i].getHostAddress());
			System.out.println(inetArr1[i].getHostName());
			System.out.println("------------------------------");
		}
	}
}
