package java_GUI01;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowDada extends WindowAdapter{ //�̺�Ʈ ó���� ���ؼ��� ��ӹ޾ƾ� �� 
	public void windowClosing(WindowEvent e) { //���� �޼ҵ� 
		System.exit(0); //â�� �ݱ� 
		//reture -> C��� : exit(0);, �ڹ� : System.exit(0);
	}
} //â�� ���� Ŭ���� 

public class Hello4 extends Frame {

	public static void main(String[] args) {
		
		GUI_Java03 h4=new GUI_Java03();
		h4.setSize(300, 300);
		h4.setTitle("����");
		h4.setCursor(new Cursor(Cursor.HAND_CURSOR)); //�ո�� Ŀ��
		h4.setVisible(true);
		h4.addWindowListener(new WindowDada());//â�� ���Ḧ ���� Ŭ���� , �̺�Ʈ
	}

}
