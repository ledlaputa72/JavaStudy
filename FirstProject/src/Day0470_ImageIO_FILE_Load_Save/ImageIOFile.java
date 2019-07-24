package Day0470_ImageIO_FILE_Load_Save;


import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

 public class ImageIOFile  {
		   
		    public static void main(String[] args) throws IOException{
		    	 File file1 = new File("e:/aa.jpg");//원본
			      BufferedImage buffimage1= ImageIO.read(file1); 
			                   //기존 파일 read하여   이미지화 한다음 
		        // 종류별 이미지 저장               //사본
			        File file2 = new File("e:/aa2.jpg"); //.jpg에 이미지를 write
			        ImageIO.write(buffimage1, "jpg", file2);
			        System.out.println("jpg 저장됨"); 
			        
			        File file3 = new File("e:/aa3.gif");
			        ImageIO.write(buffimage1,"gif", file3);
			        System.out.println("gif 저장됨"); 
			         
			        File file5 = new File("e:/aa5.png");
			        ImageIO.write(buffimage1, "png", file5);
			        System.out.println("png 저장됨"); 
		    }
		}


		

		