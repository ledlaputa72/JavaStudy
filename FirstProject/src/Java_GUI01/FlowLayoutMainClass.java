package Java_GUI01;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

class FlowLayoutMainClass extends Frame{
	
	public FlowLayoutMainClass() { //������
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
		
	}

	public static void main(String[] args) {
		//FlowLayoutMainClass.java
		FlowLayoutMainClass flc1=new FlowLayoutMainClass(); //one class���
		//��ü ���� �� ���ϸ��� ���� >> ������ 
		//�����ڸ� �� ����ϴ� ���� �߿�
		//���� ����Ʈ�����ڴ� �ڵ����� ������� �ִ�.
		//������ �����ڴ� ó���� ������ �����Ƿ� ���⼭��  �����ڰ� ���� ����
	}

}
