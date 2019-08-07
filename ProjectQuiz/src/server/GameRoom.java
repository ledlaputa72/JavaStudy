package server;


import java.util.ArrayList;

import protocol.SketchQuiz;
import protocol.GameRoomInfo;
import protocol.UserInfo;

public class GameRoom{
	AllClient[] gameRoomUsers;
	GameRoomInfo gri;
	int isJoined = -1;
	int userNum=0;
	boolean inGame = false;
	String question;
	int criterionIndex=0;   //출제자 인덱스
	boolean timeout;
	boolean starter_out;
	
	public GameRoom(GameRoomInfo gri){
		this.gri = gri;
		gameRoomUsers = new AllClient[gri.getGameUserNum()];
	}
	public String getGameRoomName(){
		StringBuffer sb = new StringBuffer();
		sb.append(gri.getRoomName());
		sb.append("(");
		sb.append(userNum);
		sb.append("/");
		sb.append(gri.getGameUserNum());
		sb.append(")");
		return sb.toString();
	}
	public int joinGameRoom(AllClient cc){
		for(int i=0; i<gameRoomUsers.length; i++){
			if(gameRoomUsers[i] == null){
				gameRoomUsers[i] = cc;
				cc.setGameRoomSlotIndex(i);
				cc.getUserInfo().setGameSlotIndex(i);
				isJoined = i;
				userNum++;
				break;
			}
		}
		return isJoined;
	}
	
	//게임방 나가기
	public void outGameRoom(AllClient cc){
		for(int i =0; i<gameRoomUsers.length; i++){
			if(gameRoomUsers[i] != null && gameRoomUsers[i].getUserInfo().getNickName().equals(cc.getUserInfo().getNickName())){
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
				if (gameRoomUsers[i]!=null){
					validIndexArr.add(i);
				}
			}			
			criterionIndex%=validIndexArr.size();
			criterionIndex = validIndexArr.get(criterionIndex);
			SketchQuiz cmp20 = new SketchQuiz(SketchQuiz.GAME_START);	
			cmp20.setUserInfoArr(getUserInfoArr());
			cmp20.setMsg(question);			
			cmp20.setGameStaterIndex(criterionIndex);
			sendGameRoomProtocol(cmp20);
			criterionIndex++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void setAllUserState(int state){
		for(int i=0; i<gameRoomUsers.length; i++){
			if(gameRoomUsers[i]!=null){
				gameRoomUsers[i].getUserInfo().setState(state);
			}
		}
	}
	public void stopGame() {
		inGame = false;
		gri.setPlayingGame(false);
		try {
			SketchQuiz cmp21 = new SketchQuiz(SketchQuiz.GAME_STOP);
			setAllUserState(UserInfo.WAIT_STATE);
			cmp21.setUserInfoArr(getUserInfoArr());
			cmp21.setTimeout(isTimeout());
			setTimeout(false);
			sendGameRoomProtocol(cmp21);	
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
	public AllClient getCopyClientBySlotIndex(int index){
		return gameRoomUsers[index];
	}
	public void sendGameRoomProtocol(SketchQuiz cmp){
		try {
			for(AllClient cc : gameRoomUsers){
				if(cc !=null){
					cc.getOut().writeObject(cmp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UserInfo[] getUserInfoArr(){
		UserInfo[] userInfoArr = new UserInfo[gri.getGameUserNum()];
		for(int i =0; i<userInfoArr.length; i++){
			if(gameRoomUsers[i] == null){
				userInfoArr[i]= null;
			}else{
				userInfoArr[i] = gameRoomUsers[i].getUserInfo();
			}
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
	public void updateGameRoomUI(){
		SketchQuiz cmp = new SketchQuiz(SketchQuiz.UPDATE_GAME_ROOM_UI);
		cmp.setUserInfoArr(getUserInfoArr());
		sendGameRoomProtocol(cmp);
	}
	public int getCriterionIndex() {
		return criterionIndex;
	}
	public void setCriterionIndex(int criterionIndex) {
		this.criterionIndex = criterionIndex;
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
