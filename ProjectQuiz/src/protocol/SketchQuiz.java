package protocol;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import canvas.CanvasElement;
import canvas.CanvasSegment;

public class SketchQuiz implements Serializable{
	//사용자의 입장 퇴장등 종료 등과 관련된 프로토콜은 1의 자리수 사용(ex 방만들기)
	public static final int USER_ACCEPT = 1;  
	public static final int USER_DUPLICATED = 2;  
	public static final int EXIT_WAIT_ROOM = 3;  
	public static final int DISCONNECT_SOCKET = 4;  
	public static final int UPDATE_WAIT_USER_LIST = 5;  
	public static final int WAIT_ROOM_SEND_MSG = 6;  
	public static final int CREATE_GAME_ROOM = 7;  
	public static final int UPDATE_GAME_ROOM_LIST = 8;  
	public static final int JOIN_GAME_ROOM = 9;  
	public static final int EXIT_GAME_ROOM = 10;
	public static final int DISCONNECT_SOCKET_ON_GAME = 11;  
	
	//게임내 사용(20~)
	public static final int GAME_START = 20;
	public static final int GAME_STOP = 21;
	public static final int GAME_CHAT = 22;
	public static final int CORRECT_ANSWER = 23;
	public static final int SET_GAME_ROOM_INDEX = 24;
	public static final int UPDATE_GAME_ROOM_UI = 25;
	
	//그리기 관련은 100의 자리수 사용
	public static final int DRAW_LINE = 100;
	public static final int DRAW_LINE_NEW_SEGMENT = 101;
	public static final int DRAW_LINE_COLOR=102;
	public static final int DRAW_LINE_THICK=103;
	public static final int CANVAS_CLEAR=104;
	
	int cmd;
	ArrayList<CanvasSegment> clsArr;
	CanvasElement canvasLine;
	Color color = Color.black;
	int lineThick=5; //라인 두께
	UserInfo userInfo;
	UserInfo[] userInfoArr;
	GameRoomInfo gameRoomInfo;
	
	String[] waitingRoomUserList;
	String[] gameRoomList;
	String msg;
	int gameRoomIndex;
	int gameStaterIndex;
	int correctAnswerIndex;
	int chatSlotIndex;
	int idx, x, y, clr; // idx:슬롯인덱스, x:캔버스x, y:캔버스y, clr:브러시컬러넘버
	boolean timeout;
	boolean starter_out;
		
	
	public boolean isStarter_out() {
		return starter_out;
	}

	public void setStarter_out(boolean starter_out) {
		this.starter_out = starter_out;
	}

	public boolean isTimeout() {
		return timeout;
	}

	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
	}

	public int getGameStaterIndex() {
		return gameStaterIndex;
	}

	public void setGameStaterIndex(int gameStaterIndex) {
		this.gameStaterIndex = gameStaterIndex;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getClr() {
		return clr;
	}

	public void setClr(int clr) {
		this.clr = clr;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public UserInfo[] getUserInfoArr() {
		return userInfoArr;
	}

	public void setUserInfoArr(UserInfo[] userInfoArr) {
		this.userInfoArr = userInfoArr;
	}

	public String[] getWaitingRoomUserList() {
		return waitingRoomUserList;
	}

	public void setWaitingRoomUserList(String[] waitingRoomUserList) {
		this.waitingRoomUserList = waitingRoomUserList;
	}

	public SketchQuiz(int cmd) {
		this.cmd = cmd;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public ArrayList<CanvasSegment> getClsArr() {
		return clsArr;
	}

	public void setClsArr(ArrayList<CanvasSegment> clsArr) {
		this.clsArr = clsArr;
	}

	public CanvasElement getCanvasLine() {
		return canvasLine;
	}

	public void setCanvasLine(CanvasElement canvasLine) {
		this.canvasLine = canvasLine;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public GameRoomInfo getGameRoomInfo() {
		return gameRoomInfo;
	}

	public void setGameRoomInfo(GameRoomInfo gameRoomInfo) {
		this.gameRoomInfo = gameRoomInfo;
	}

	public String[] getGameRoomList() {
		return gameRoomList;
	}

	public void setGameRoomList(String[] gameRoomList) {
		this.gameRoomList = gameRoomList;
	}

	public int getGameRoomIndex() {
		return gameRoomIndex;
	}

	public void setGameRoomIndex(int gameRoomIndex) {
		this.gameRoomIndex = gameRoomIndex;
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

	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}

	public void setCorrectAnswerIndex(int correctAnswerIndex) {
		this.correctAnswerIndex = correctAnswerIndex;
	}

	public int getChatSlotIndex() {
		return chatSlotIndex;
	}

	public void setChatSlotIndex(int chatSlotIndex) {
		this.chatSlotIndex = chatSlotIndex;
	}

	
}
