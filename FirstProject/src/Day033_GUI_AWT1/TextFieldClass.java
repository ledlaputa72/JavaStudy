package Day033_GUI_AWT1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFieldClass extends Frame {

	public TextFieldClass() { //������
		this.setLayout(new FlowLayout()); //this �ڱ��ڽ��� �����ϴ� ��ü, FlowLayoutMainClass�� ����
		//���� �߾�����, �����¿� 5�ȼ�����
		//��, �¿��� ��� ��ġ, �ٽ� ������ �¿��� ��� ��ġ
		//���� �ٿ����� ��� ����
		//������ �����츦 ũ�⸦ ���̰ų� �÷����� �ڵ����� 
		//setLayout(null)�� ������ ���Ǵ��
		
		this.add(new Button("������")); //Button ���� Ŭ���� , ���ο� Button ��ü�� �����, add�� ȭ�鿡 ���δ�. 
		this.add(new Button("����"));
		this.add(new Button("����?�帳�ǵ�ġ����"));
		this.add(new Button("�o��?"));
		this.add(new Button("�� ����?"));
		this.add(new Button("�ƹ��ų�"));
		this.setSize(300, 300);
		this.setVisible(true);
		
		//â�� �ݱ� �����/////////////////////////////////////////
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //�����ڰ� ���� �޸��� ������ ����� ���
				System.exit(0);
			}
		});
		/////////////////////////////////////////////////////
	}//������ end
	
	public static void main(String[] args) {

		TextFieldClass tfc1=new TextFieldClass(); //����������
		tfc1.setSize(500, 500);	
		tfc1.setTitle("�ؽ�Ʈ�ʵ��");
		tfc1.setLayout(new FlowLayout()); //������� �߰��� 
		
		//TextField(�ۻ���)///////////////////////////////////////
		TextField tf1=new TextField("�浿ȫ���� �Է�",20);
		//tf1.setEchoChar('*'); //ȭ�鿡 ó�� *�� ��µǸ� �ڷḦ �Է�
		tf1.setFont(new Font("����",Font.BOLD, 24));
		
		tf1.setSize(200, 200);
		tf1.setVisible(true);
		
		tfc1.add(tf1);
		tfc1.setVisible(true);
		tfc1.addWindowListener(new WindowDada());
	}
}

