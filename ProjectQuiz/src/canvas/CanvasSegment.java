package canvas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

public class CanvasSegment implements Serializable {
	
	ArrayList<CanvasElement> canArr;
	
	// ������
	public CanvasSegment() {
		
		this.canArr = new ArrayList<>();
		
	}

	public ArrayList<CanvasElement> getCanArr() {
		return canArr;
	}

	public void setCanArr(ArrayList<CanvasElement> canArr) {
		this.canArr = canArr;
	}
	
	public void drawLineSegment(Graphics g){
		
		try {
			
			for(int i=0; i<canArr.size() - 1; i++) {
				
				g.setColor(canArr.get(i).getColor());
				
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setStroke(new BasicStroke(canArr.get(i).getLineThick()));
				g.drawLine(canArr.get(i).getStartX(), canArr.get(i).getStartY(), canArr.get(i+1).getStartX(), canArr.get(i+1).getStartY());
			
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
