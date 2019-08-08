package info;

import java.util.ArrayList;

public class RoomListInfo {
	
	ArrayList<AllClient> waitingRoomUsers;
	ArrayList<GameRoom> gameRoomList;
	
	public RoomListInfo() {
		
		waitingRoomUsers = new ArrayList<>();
		gameRoomList = new ArrayList<>();
		
	}
	
	public ArrayList<AllClient> getWaitingRoomUsers() {
		return waitingRoomUsers;
	}
	
	public void setWaitingRoomUsers(ArrayList<AllClient> waitingRoomUsers) {
		this.waitingRoomUsers = waitingRoomUsers;
	}
	
	public ArrayList<GameRoom> getGameRoomList() {
		return gameRoomList;
	}
	
	public void setGameRoomList(ArrayList<GameRoom> gameRoomList) {
		this.gameRoomList = gameRoomList;
	}
	
	public void sendUpdateUserInfo() {
		
		SketchQuiz sq = new SketchQuiz(SketchQuiz.UPDATE_WAIT_USER_LIST);
		
		sq.setWaitingRoomUserList(getWaitingRoomUserList());
		
		for (AllClient cc : waitingRoomUsers) {
			
			try {
				
				cc.getOut().writeObject(sq);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public void sendUpdateGameRoomInfo() {
		
		SketchQuiz sq = new SketchQuiz(SketchQuiz.UPDATE_GAME_ROOM_LIST);
		
		sq.setGameRoomList(getGameRoomListToStr());
		
		for (AllClient cc : waitingRoomUsers) {
			
			try {
				
				cc.getOut().writeObject(sq);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public void sendMsg(SketchQuiz sq) {
		
		for (AllClient cc : waitingRoomUsers) {
			
			try {
				
				cc.getOut().writeObject(sq);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public String[] getWaitingRoomUserList() {
		
		String[] v = null;
		
		if (waitingRoomUsers.size() > 0) {
			
			v = new String[waitingRoomUsers.size()];
			
			for (int i=0; i<waitingRoomUsers.size(); i++)
				v[i] = waitingRoomUsers.get(i).getUserInfo().getNickName();
			
		} 
		
		return v;
		
	}
	
	public String[] getGameRoomListToStr() {
		
		String[] v = null;
		
		if (gameRoomList.size() > 0) {
			
			v = new String[gameRoomList.size()];
			
			for(int i=0; i<gameRoomList.size(); i++)
				v[i] = gameRoomList.get(i).getGameRoomName();
			
		}
		
		return v;
		
	}
	
}
