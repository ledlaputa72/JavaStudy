package guiJava01;

import java.awt.Frame;

public class GUI_Java01 {

	public static void main(String[] args) {
		Frame f1=new Frame(); //���� Ŭ���� import java.awt
		f1.setTitle("����ϱ�"); //��ü.�޼ҵ� ������ Ÿ��Ʋ ��� 
//		Frame f1=new Frame("����ϱ�"); //�� ������ ��ģ�� 
		f1.setSize(700, 700); //pixel = picture element
		f1.setVisible(true); 
		//ctrl+alt+del���� �ش� ���μ��� stop
	}

}
