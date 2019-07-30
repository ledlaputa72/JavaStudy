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
    	//기본 프레임
        JFrame f = new JFrame();
        f.setSize(240,440);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible( true );
        
        //그림 그리기 와 받기 
        BufferedImage biIn = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB );
        //그림 그리는 그림판 
        JLabel jl1 = new JLabel(new ImageIcon(biIn) );
        jl1.setBounds(20,20,160,160);
        f.add(jl1);
        
        BufferedImage biOut = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB );
        //그림 버퍼를 받아오는 보기판
        JLabel jl2 = new JLabel(new ImageIcon(biOut));
        jl2.setBounds(20,180,160,160);
        f.add(jl2);

        // 브러쉬라는 클래스를 생성한다. 아래쪽에 정의함.///////////////////////
        Brush2 b = new Brush2();
        b.setBounds(20,20,160,160); //크기가 jl1 과 같아야 한다.
        f.add(b);
        
        // 마우스 모션 이벤트/////////////////////////////////////
        jl1.addMouseMotionListener( new MouseMotionListener() {
            
            public void mouseDragged(MouseEvent e) {
                b.xx=e.getX();
                b.yy=e.getY();
                b.repaint();                            
                b.printAll(  biIn.getGraphics() ); //브러쉬를 BufferedImage 에 그린다.                
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