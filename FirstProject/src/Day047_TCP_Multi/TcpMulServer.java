package Day047_TCP_Multi;

public class TcpMulServer {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("���� : ���������� "+" \'java ��Ű����.���ϸ� ��Ʈ��ȣ\' �������� �Է�");
		}
		
		//new ServeClass()
		new ServerClass(Integer.parseInt(args[0]));
		//��ü���� - �ʱ�ġ ������ 
	}

}

