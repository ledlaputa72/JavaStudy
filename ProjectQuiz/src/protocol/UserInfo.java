package protocol;

import java.io.Serializable;

public class UserInfo implements Serializable{
	public static final int WAIT_STATE= 0;
	public static final int GAME_SOLVER_STATE= 1;
	public static final int GAME_QUESTIONER_STATE= 2;
	String nickName;  //��ȭ��
	String imageURL; //Ŭ���̾�Ʈ���� �������� ������ ���� �̹������� ����ڰ� ������ �̹����� ���
	String hitCount; //���� ī��Ʈ
	boolean isOwner; //���� �������� �Ǻ�
	int gameSlotIndex;
	int state; //�������, 0:��� 1:������-������ 2:������-������
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public UserInfo(String nick){
		this.nickName = nick;
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
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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
