package server;

import java.util.ArrayList;

import protocol.CatchMindProtocol;

public class WaitingRoom {
	ArrayList<CopyClient> waitingRoomUsers;
	ArrayList<GameRoom> gameRoomList;
	
	public WaitingRoom(){
		waitingRoomUsers = new ArrayList<>();
		gameRoomList = new ArrayList<>();
	}
	public ArrayList<CopyClient> getWaitingRoomUsers() {
		return waitingRoomUsers;
	}
	public void setWaitingRoomUsers(ArrayList<CopyClient> waitingRoomUsers) {
		this.waitingRoomUsers = waitingRoomUsers;
	}
	public ArrayList<GameRoom> getGameRoomList() {
		return gameRoomList;
	}
	public void setGameRoomList(ArrayList<GameRoom> gameRoomList) {
		this.gameRoomList = gameRoomList;
	}
	
	public void sendUpdateUserInfo(){
		CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.UPDATE_WAIT_USER_LIST);
		cmp.setWaitingRoomUserList(getWaitingRoomUserList());
		for(CopyClient cc : waitingRoomUsers){
			try {
				cc.getOut().writeObject(cmp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void sendUpdateGameRoomInfo(){
		CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.UPDATE_GAME_ROOM_LIST);
		cmp.setGameRoomList(getGameRoomListToStr());
		for(CopyClient cc : waitingRoomUsers){
			try {
				cc.getOut().writeObject(cmp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void sendMsg(CatchMindProtocol cmp){
		for(CopyClient cc : waitingRoomUsers){
			try {
				cc.getOut().writeObject(cmp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public String[] getWaitingRoomUserList(){
		String[] v = null;
		if(waitingRoomUsers.size()>0){
			v = new String[waitingRoomUsers.size()];
			for(int i =0; i<waitingRoomUsers.size(); i++){
				v[i] = waitingRoomUsers.get(i).getUserInfo().getNickName();
			}
		} 
		return v;
	}
	public String[] getGameRoomListToStr(){
		String[] v = null;
		if(gameRoomList.size()>0){
			v = new String[gameRoomList.size()];
			for(int i =0; i<gameRoomList.size(); i++){
				v[i] = gameRoomList.get(i).getGameRoomName();
			}
		}
		return v;
	}
	
}
