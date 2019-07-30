package Test;
import javax.imageio.ImageIO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
  
public class MainTest extends JFrame{    
    
    public static void main(String[] a) throws IOException {
    	//�⺻ ������
        JFrame f = new JFrame();
        f.setSize(240,440);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible( true );
        
        //�׸� �׸��� �� �ޱ� 
        BufferedImage biIn = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB );
        //�׸� �׸��� �׸��� 
        JLabel jl1 = new JLabel(new ImageIcon(biIn) );
        jl1.setBounds(20,20,160,160);
        f.add(jl1);
        
        BufferedImage biOut = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB );
        //�׸� ���۸� �޾ƿ��� ������
        JLabel jl2 = new JLabel(new ImageIcon(biOut));
        jl2.setBounds(20,180,160,160);
        f.add(jl2);

        // �귯����� Ŭ������ �����Ѵ�. �Ʒ��ʿ� ������.///////////////////////
        Brush2 b = new Brush2();
        b.setBounds(20,20,160,160); //ũ�Ⱑ jl1 �� ���ƾ� �Ѵ�.
        f.add(b);
        
        // ���콺 ��� �̺�Ʈ/////////////////////////////////////
        jl1.addMouseMotionListener( new MouseMotionListener() {
            
            public void mouseDragged(MouseEvent e) {
                b.xx=e.getX();
                b.yy=e.getY();
                b.repaint();                            
                b.printAll(  biIn.getGraphics() ); //�귯���� BufferedImage �� �׸���.                
            }
            
            public void mouseMoved(MouseEvent e) {
            }           
        });
        
    }   
}


class Brush extends JLabel{
        
    public int xx, yy;
    public Color col=new Color(255,0,0);
    
    public void paint(Graphics g) {     
    
        g.setColor( col );
        g.fillOval( xx-10, yy-10, 20, 20);
        
    }   
}