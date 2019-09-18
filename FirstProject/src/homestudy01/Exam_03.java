package homestudy01;

import java.text.*;
import java.util.*;

class TimeThread extends Thread{
		
	public void run() {
		while(true) {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		System.out.println("현재시간 : " + sdf.format(date));
		try {
			Thread.sleep(1000);
			}catch(InterruptedException e) {}
		}
	}
}

public class Exam_03 {

	public static void main(String[] args) throws InterruptedException {
		TimeThread tt=new TimeThread();
		tt.setDaemon(true);
		tt.start();
		try {
			tt.join(5000);
			Thread.sleep(5000);
		}catch(InterruptedException e) {}
	}
}
