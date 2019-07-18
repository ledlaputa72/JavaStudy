package Day033_GUI_AWT1;
//one class�� ���� 
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutClass extends Frame{

	public BorderLayoutClass() {
		this.setLayout(new BorderLayout()); //��,��,��,��, �߾����� ��ġ
		this.add(BorderLayout.EAST,new Button("������1"));
		this.add(BorderLayout.WEST,new Button("������2"));
		this.add(BorderLayout.SOUTH,new Button("������3"));
		this.add(BorderLayout.NORTH,new Button("������4"));
		this.add(BorderLayout.CENTER,new Button("������5"));
		
		this.setSize(700, 700);
		this.setVisible(true);
		
		//�ݱ�
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	}
	
	public static void main(String[] args) {

		BorderLayoutClass flc1=new BorderLayoutClass();
		
	}

}

