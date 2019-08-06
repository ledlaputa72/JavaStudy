package protocol;

import java.io.Serializable;

public class GameRoomInfo implements Serializable{
	String roomName;
	boolean isPublicGameRoom;
	String gamePassword;
	int gameUserNum;
	boolean isPlayingGame;
	public GameRoomInfo(String roomName, boolean isPublicGameRoom,
			String gamePassword, int gameUserNum) {
		this.roomName = roomName;
		this.isPublicGameRoom = isPublicGameRoom;
		this.gamePassword = gamePassword;
		this.gameUserNum = gameUserNum;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public boolean isPublicGameRoom() {
		return isPublicGameRoom;
	}
	public void setPublicGameRoom(boolean isPublicGameRoom) {
		this.isPublicGameRoom = isPublicGameRoom;
	}
	public String getGamePassword() {
		return gamePassword;
	}
	public void setGamePassword(String gamePassword) {
		this.gamePassword = gamePassword;
	}
	public int getGameUserNum() {
		return gameUserNum;
	}
	public void setGameUserNum(int gameUserNum) {
		this.gameUserNum = gameUserNum;
	}
	public boolean isPlayingGame() {
		return isPlayingGame;
	}
	public void setPlayingGame(boolean isPlayingGame) {
		this.isPlayingGame = isPlayingGame;
	}
	
}
