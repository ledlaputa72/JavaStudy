package step10_dPaintTest;

import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class TcpClientIMG  { //extends JFrame { ////////////////
	public static void main(String args[]) 
			    throws UnknownHostException, IOException {
		Socket s1 = new Socket("127.0.0.1", 9999);
	        
        //////////////////////////////////////////////////////////
		//�⺻ ������
		JFrame f = new JFrame();
		f.setSize(240,440);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible( true );
        
        BufferedImage biOut;
        BufferedImage biIn;
        
       
		//�޾� ���� ///////////////////////////////////////////
		biIn = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB );
		biIn = ImageIO.read(s1.getInputStream());////// �������� ������ �̹����� ����
		
        JLabel jl2 = new JLabel(new ImageIcon(biIn)); //�޾ƿ� �̹����� �׸� 
        jl2.setBounds(20,180,160,160);
        f.add(jl2);
	        
	}
}

