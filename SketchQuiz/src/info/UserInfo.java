package info;

import java.io.Serializable;

public class UserInfo implements Serializable {
	
	public static final int WAIT_STATE = 0;
	public static final int GAME_SOLVER_STATE = 1;
	public static final int GAME_TESTER_STATE = 2;
	
	String nickName;

	String hitCount; // 정답 카운트
	
	boolean isOwner; //방의 주인인지 판별
	
	int gameSlotIndex;
	int state; //현재상태, 0:대기 1:게임중-참여자 2:게임중-출제자
	
	// 생성자
	public UserInfo(String nick){
		this.nickName = nick;
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public int getGameSlotIndex() {
		return gameSlotIndex;
	}

	public void setGameSlotIndex(int gameSlotIndex) {
		this.gameSlotIndex = gameSlotIndex;
	}

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHitCount() {
		return hitCount;
	}
	
	public void setHitCount(String hitCount) {
		this.hitCount = hitCount;
	}
	
	public boolean isOwner() {
		return isOwner;
	}
	
	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}
	
}
