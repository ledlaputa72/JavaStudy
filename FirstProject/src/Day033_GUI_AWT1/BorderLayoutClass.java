package Day033_GUI_AWT1;
//one class·Î ¼³¸í 
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutClass extends Frame{

	public BorderLayoutClass() {
		this.setLayout(new BorderLayout()); //µ¿,¼­,³²,ºÏ, Áß¾ÓÀ¸·Î ¹èÄ¡
		this.add(BorderLayout.EAST,new Button("´­·¯ºÁ1"));
		this.add(BorderLayout.WEST,new Button("´­·¯ºÁ2"));
		this.add(BorderLayout.SOUTH,new Button("´­·¯ºÁ3"));
		this.add(BorderLayout.NORTH,new Button("´­·¯ºÁ4"));
		this.add(BorderLayout.CENTER,new Button("´­·¯ºÁ5"));
		
		this.setSize(700, 700);
		this.setVisible(true);
		
		//´Ý±â
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); 
				System.exit(0);
			}
		});	//Ã¢ ´Ý±â
	}
	
	public static void main(String[] args) {

		BorderLayoutClass flc1=new BorderLayoutClass();
		
	}

}

