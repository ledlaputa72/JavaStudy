package java001;

public class ContinueTest {

	public static void main(String[] args) {

		// continue�� ���� 
		int flag=0;
		int cnt=0;
		while (flag==0) {
			cnt++;
			if(cnt==10) { // break ����
			System.out.println("���� �׸��Ȱ� ��� ��~");	
				break; // �ݺ����� ������ ���� ������.
			}
			if(cnt==3) {
			System.out.println("���� while������ ");	
				continue; // ����ϰ� �ٽ� �ݺ��� ó������ ���ư���.
			}
			System.out.println("Ŀ������"+ cnt);
		}
		
	}

}
