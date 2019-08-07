package canvas;

import java.awt.Color;
import java.io.Serializable;

public class CanvasElement implements Serializable {
	
	int startX, startY;
	int endX, endY;
	
	Color color;
	
	int lineThick;
	
	// 持失切
	public CanvasElement(int startX, int startY, int endX, int endY) {
		
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		
	}
	
	// 持失切
	public CanvasElement(int startX, int startY, int endX, int endY, Color color, int lineThick) {
		
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.color = color;
		this.lineThick = lineThick;
		
	}

	public int getStartX() {
		return startX;
	}
	
	public void setStartX(int startX) {
		this.startX = startX;
	}
	
	public int getStartY() {
		return startY;
	}
	
	public void setStartY(int startY) {
		this.startY = startY;
	}
	
	public int getEndX() {
		return endX;
	}
	
	public void setEndX(int endX) {
		this.endX = endX;
	}
	
	public int getEndY() {
		return endY;
	}
	
	public void setEndY(int endY) {
		this.endY = endY;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getLineThick() {
		return lineThick;
	}

	public void setLineThick(int lineThick) {
		this.lineThick = lineThick;
	}
	
}
