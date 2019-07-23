package Day047_ImageIO_FILE_Load_Save;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;

 public class ImageIOFile_FO extends Frame {
		    BufferedImage bi = null;
		     
		    public ImageIOFile_FO(){
		        try{
		            bi = bufferedImage();
		        }catch(Exception e){
		            e.printStackTrace();
		        }
		    }
		     
		    private BufferedImage bufferedImage() throws Exception{
		        //ImageIO를 이용한 이미지 로딩
		        File file = new File("d:/aa.jpg");
		        BufferedImage bi = ImageIO.read(file);
		         
		        // ImageIO를 이용한 이미지 저장
		        File file1 = new File("d:/aa2.jpg");
		        ImageIO.write(bi, "jpg", file1);
		         
		        File file2 = new File("d://aa3.gif");
		        ImageIO.write(bi, "gif", file2);
		         
		        File file3 = new File("d://aa4.png");
		        ImageIO.write(bi, "png", file3);
		         
		        return bi;
		    }
		     
		    public void paint(Graphics g){
		        if(this.bi != null)
		            g.drawImage(this.bi, 0, 20, this);
		    }
		     
		    public static void main(String[] args){
		    	ImageIOFile_FO itm = new ImageIOFile_FO();
		        itm.setSize(330, 420);
		        itm.setVisible(true);
		    }
		}


		

		