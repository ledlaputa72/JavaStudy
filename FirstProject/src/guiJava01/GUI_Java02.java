package guiJava01;

import java.awt.Frame;

class GUI_Java02 extends Frame{ 

	public GUI_Java02(String me) {
		super(me); //��ӿ����� ������ 
		//�θ�����ڸ� ã�ư�(Frame�� �θ��ε� �̹� ���� Ŭ�����̹Ƿ� ���� �θ� Ŭ������ ���� �ʿ䰡 ����) 
	}

	public static void main(String[] args) {

		GUI_Java02 h2=new GUI_Java02("����"); //���� ��ü�� �����(�Ϲ������� �ڱ� Ŭ���� �ۿ��� ���峪)
		// ��ü����+�ʱ�ġ => ������ �ʿ�  	//"����"�� Ÿ��Ʋ 
		h2.setSize(300,300);
		h2.setVisible(true);
		//Ctrl+Shift+Esc ==> �۾������� 
	}

}
