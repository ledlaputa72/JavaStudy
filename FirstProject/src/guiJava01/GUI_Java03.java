package guiJava01;

import java.awt.Cursor;
import java.awt.Frame;

public class GUI_Java03 extends Frame{

	public static void main(String[] args) {
		GUI_Java03 h3=new GUI_Java03();
		h3.setSize(300, 300);
		h3.setTitle("����");
		h3.setCursor(new Cursor(Cursor.HAND_CURSOR)); //�ո�� Ŀ��
		h3.setVisible(true);
	}

}
