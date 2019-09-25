package main;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import protocol.SketchQuiz;
import server.AllClient;
import server.RoomListInfo;
import canvas.CanvasElement;
import canvas.CanvasSegment;

public class MainServer extends Thread {
	
	ServerSocket ss;
	
	ArrayList<AllClient> clientArr; // 현재 서버를 사용하고 있는 모든 유저 리스트
	ArrayList<CanvasSegment> clsArr;
	
	RoomListInfo waitingRoom = new RoomListInfo();
	
	public MainServer() {
		
		clsArr = new ArrayList<>();
		clsArr.add(new CanvasSegment());
		clientArr = new ArrayList<AllClient>();
		
		try {
			
			ss = new ServerSocket(5000);
			
			System.out.println("서버 시작!");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void main(String[] args) {
		
		new MainServer().start();
		
	}
	
	@Override
	public void run() {
		
		while (true) {
			
			try {
				
				Socket s = ss.accept();
				
				AllClient cc = new AllClient(s, this); 
				
				cc.start();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public void sendProtocol(SketchQuiz s) {
		
		try {
			
			for (AllClient ac : clientArr) {
				
				ac.getOut().writeObject(s);
				ac.getOut().flush();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void addCanvasLine(CanvasElement cl) {
		
		clsArr.get(0).getCanArr().add(cl);
		
	}
	
	public ArrayList<CanvasSegment> getClsArr() {
		return clsArr;
	}
	
	public void setClsArr(ArrayList<CanvasSegment> clsArr) {
		this.clsArr = clsArr;
	}
	
	public ArrayList<AllClient> getClinetArr() {
		return clientArr;
	}
	
	public void setClinetArr(ArrayList<AllClient> clientArr) {
		this.clientArr = clientArr;
	}
	
	public RoomListInfo getWaitingRoom() {
		return waitingRoom;
	}
	
	public void setWaitingRoom(RoomListInfo waitingRoom) {
		this.waitingRoom = waitingRoom;
	}
	
}