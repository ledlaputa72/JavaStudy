package java_GUI02;

import java.awt.*;
import java.awt.event.*;

class TextAreaClass extends Frame  {
	
	TextArea ta1=new TextArea("����� ������",5,50); //5�� 50��
	
	public TextAreaClass() {
//		ta1.setSize(100, 400);
		ta1.setFont(new Font("����",Font.BOLD, 20));
		ta1.append("(�߰��Ǵ±���)"); //���ڿ� �߰��� ���
		//String str1="�̰ɷ� ��� �⺻���� ����";
		//ta1.setText(str1);
		ta1.setVisible(true);
		this.add(ta1);
		this.setTitle("TextArea����");
		this.setSize(700, 700);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		
		//â�� �ݱ�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //�����ڰ� ���� �޸��� ������ ����� ���
				System.exit(0);
			}
		});
	}//������ end
}//class end


public class TextAreaEx01 {

	public static void main(String[] args) {
		TextAreaClass tac1=new TextAreaClass();
		
	}

}
