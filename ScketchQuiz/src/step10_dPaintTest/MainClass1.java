package step10_dPaintTest;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
  
public class MainClass1 {    
    
    public static void main(String[] a) {
        
        JFrame f = new JFrame();
        f.setSize(200,240);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible( true );
                
        BufferedImage bi = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB );
        
        JLabel l = new JLabel(new ImageIcon(bi) );
        l.setBounds(20,20,160,160);
        f.add(l);
        
        // �귯����� Ŭ������ �����Ѵ�. �Ʒ��ʿ� ������.
        Brush1 b = new Brush1();
        b.setBounds(20,20,160,160); //ũ�Ⱑ l�� ���ƾ� �Ѵ�.
        f.add(b);
        
        // ���콺 ��� �̺�Ʈ
        l.addMouseMotionListener( new MouseMotionListener() {
            
            public void mouseDragged(MouseEvent e) {
                
                b.xx=e.getX();
                b.yy=e.getY();
                b.repaint();                            
                b.printAll(  bi.getGraphics() ); //�귯���� BufferedImage �� �׸���.                
            }
            
            public void mouseMoved(MouseEvent e) {

            }           
        });
        
        JButton bt = new JButton("����");
        bt.setBounds(20, 180, 160, 30);
        f.add(bt);
        
        bt.addActionListener( new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {

               try { ImageIO.write(bi, "PNG", new File("c:\\abc\\yourImageName.PNG")); }
               catch (IOException e1) { e1.printStackTrace(); }               
            }            
        });
        
    }   
}


class Brush1 extends JLabel{
        
    public int xx, yy;
    public Color col=new Color(255,0,0);
    
    public void paint(Graphics g) {     
    
        g.setColor( col );
        g.fillOval( xx-10, yy-10, 20, 20);
        
    }   
}