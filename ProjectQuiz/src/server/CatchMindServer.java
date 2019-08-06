package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import protocol.CatchMindProtocol;
import canvas.CanvasLine;
import canvas.CanvasLineSegment;

public class CatchMindServer extends Thread{
	ServerSocket ss;
	ArrayList<CopyClient> cArr;    //현재 서버를 사용하고 있는 모든 유저(대기실, 게임방)
	ArrayList<CanvasLineSegment> clsArr;  //TODO 나중에 게임방으로 옮겨야 할 것
	
	WaitingRoom waitingRoom = new WaitingRoom();
	
	public CatchMindServer(){
		clsArr = new ArrayList<>();
		clsArr.add(new CanvasLineSegment());
		cArr = new ArrayList<CopyClient>();
		try {
			ss = new ServerSocket(9997);
			//서버 시작
			System.out.println("서버 시작!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		new CatchMindServer().start();
	}
	@Override
	public void run() {
		while(true){
			try {
				Socket s = ss.accept();
				CopyClient cc = new CopyClient(s, this); 
				cc.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void sendProtocol(CatchMindProtocol p){
		try {
			for(CopyClient cc : cArr){
				cc.getOut().writeObject(p);
				cc.getOut().flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addCanvasLine(CanvasLine cl){
		clsArr.get(0).getCanArr().add(cl);
	}
	public ArrayList<CanvasLineSegment> getClsArr() {
		return clsArr;
	}
	public void setClsArr(ArrayList<CanvasLineSegment> clsArr) {
		this.clsArr = clsArr;
	}
	public ArrayList<CopyClient> getcArr() {
		return cArr;
	}
	public void setcArr(ArrayList<CopyClient> cArr) {
		this.cArr = cArr;
	}
	public WaitingRoom getWaitingRoom() {
		return waitingRoom;
	}
	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}
	
}