package info;

import java.util.ArrayList;

public class GameRoom {
	
	AllClient[] gameRoomUsers;
	GameRoomInfo gri;
	
	int isJoined = -1;
	int userNum = 0;
	
	boolean inGame = false;
	
	String question;
	
	int testerIndex = 0;   
	
	boolean timeout;
	boolean starter_out;
	
	// 생성자
	public GameRoom(GameRoomInfo gri) {
		
		this.gri = gri;
		
		gameRoomUsers = new AllClient[gri.getGameUserNum()];
		
	}
	
	public String getGameRoomName() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(gri.getRoomName() + " ( " + userNum + " / " + gri.getGameUserNum() + " )");
		
		return sb.toString();
		
	}
	
	public int joinGameRoom(AllClient ac) {
		
		for (int i=0; i<gameRoomUsers.length; i++) {
			
			if (gameRoomUsers[i] == null) {
				
				gameRoomUsers[i] = ac;
				
				ac.setGameRoomSlotIndex(i);
				ac.getUserInfo().setGameSlotIndex(i);
				
				isJoined = i;
				
				userNum++;
				
				break;
				
			}
			
		}
		
		return isJoined;
		
	}
	
	// 게임방 나가기
	public void outGameRoom(AllClient ac) {
		
		for (int i=0; i<gameRoomUsers.length; i++) {
			
			if (gameRoomUsers[i] != null && gameRoomUsers[i].getUserInfo().getNickName().equals(ac.getUserInfo().getNickName())) {
			
				gameRoomUsers[i] = null;
				
				userNum--;
				
				break;			
				
			}
			
		}
		
	}
	
	public void startGame() {
		
		inGame = true;
		
		gri.setPlayingGame(true);
		
		Question q = new Question();
		
		question = q.setQuestion();
		
		ArrayList<Integer> validIndexArr = new ArrayList<>();
		
		try {
			
			for (int i=0; i<gameRoomUsers.length; i++) {
				
				if (gameRoomUsers[i] != null)
					validIndexArr.add(i);
				
			}			
			
			testerIndex %= validIndexArr.size();
			testerIndex = validIndexArr.get(testerIndex);
			
			SketchQuiz sq20 = new SketchQuiz(SketchQuiz.GAME_START);	
			
			sq20.setUserInfoArr(getUserInfoArr());
			sq20.setMsg(question);			
			sq20.setGameStaterIndex(testerIndex);
			
			sendGameRoomProtocol(sq20);
			
			testerIndex++;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	private void setAllUserState(int state) {
		
		for(int i=0; i<gameRoomUsers.length; i++) {
			
			if(gameRoomUsers[i] != null)
				gameRoomUsers[i].getUserInfo().setState(state);
			
		}
		
	}
	
	public void stopGame() {
		
		inGame = false;
		
		gri.setPlayingGame(false);
		
		try {
			
			SketchQuiz sq21 = new SketchQuiz(SketchQuiz.GAME_STOP);
			
			setAllUserState(UserInfo.WAIT_STATE);
			
			sq21.setUserInfoArr(getUserInfoArr());
			sq21.setTimeout(isTimeout());
			
			setTimeout(false);
			
			sendGameRoomProtocol(sq21);	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public GameRoomInfo getGri() {
		return gri;
	}
	
	public void setGri(GameRoomInfo gri) {
		this.gri = gri;
	}
	
	public AllClient getCopyClientBySlotIndex(int index) {
		return gameRoomUsers[index];
	}
	
	public void sendGameRoomProtocol(SketchQuiz sq) {
		
		try {
			
			for(AllClient ac : gameRoomUsers) {
				
				if(ac != null) 
					ac.getOut().writeObject(sq);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public UserInfo[] getUserInfoArr() {
		
		UserInfo[] userInfoArr = new UserInfo[gri.getGameUserNum()];
		
		for (int i=0; i<userInfoArr.length; i++) {
			
			if(gameRoomUsers[i] == null)
				userInfoArr[i] = null;
			
			else
				userInfoArr[i] = gameRoomUsers[i].getUserInfo();
			
		}
		
		return userInfoArr;
		
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public int getUserNum() {
		return userNum;
	}
	
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	public boolean isInGame() {
		return inGame;
	}
	
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	
	public void updateGameRoomUI() {
		
		SketchQuiz sq = new SketchQuiz(SketchQuiz.UPDATE_GAME_ROOM_UI);
		
		sq.setUserInfoArr(getUserInfoArr());
		sendGameRoomProtocol(sq);
		
	}
	
	public int getCriterionIndex() {
		return testerIndex;
	}
	
	public void setCriterionIndex(int criterionIndex) {
		this.testerIndex = criterionIndex;
	}
	
	public boolean isTimeout() {
		return timeout;
	}
	
	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
	}
	
	public boolean isStarter_out() {
		return starter_out;
	}
	
	public void setStarter_out(boolean starter_out) {
		this.starter_out = starter_out;
	}	
	
}
