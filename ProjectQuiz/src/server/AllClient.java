package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import main.MainServer;
import protocol.SketchQuiz;
import protocol.GameRoomInfo;
import protocol.UserInfo;

public class AllClient extends Thread{
	MainServer server;
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	UserInfo userInfo;
	int gameRoomSlotIndex;
	GameRoom currentGameRoom;
	public AllClient(Socket s, MainServer server){
		this.s = s;
		this.server = server;
		try {
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			bk:while(true){
				SketchQuiz p = (SketchQuiz)in.readObject();
				switch(p.getCmd()){
				case SketchQuiz.DRAW_LINE:
					server.addCanvasLine(p.getCanvasLine());
					SketchQuiz temp_p = new SketchQuiz(SketchQuiz.DRAW_LINE);
					temp_p.setCanvasLine(p.getCanvasLine());
					server.sendProtocol(temp_p);
//					CatchMindProtocol ppp = new CatchMindProtocol(CatchMindProtocol.DRAW_LINE);
//					ArrayList<CanvasLineSegment> clsArr2 = new ArrayList<CanvasLineSegment>();
//					clsArr2.add(new CanvasLineSegment());
//					for(int i=0; i<server.getClsArr().get(0).getCanArr().size();i++){
//						clsArr2.get(0).getCanArr().add(server.getClsArr().get(0).getCanArr().get(i));
//					}
//					ppp.setClsArr(clsArr2);
//					server.sendProtocol(ppp);
					break;
				case SketchQuiz.USER_ACCEPT:   //��ȭ���� �Է��Ͽ� ������ ���� �õ�
					this.userInfo = p.getUserInfo();  //����ڷ� ���� ����� ������ �Է� �޴´�
					if(!isDuplicated()){  //�ߺ��Ǵ� �г��� ����ڰ� ���ٸ�
						SketchQuiz sq = new SketchQuiz(SketchQuiz.USER_ACCEPT); //������ ������ ���� �˷���
						sq.setUserInfo(userInfo);
						out.writeObject(sq);
						out.flush();
						server.getClinetArr().add(this); //���Ӱ� ������ �̿��ϴ� ��ü ������ �߰�
						server.getWaitingRoom().getWaitingRoomUsers().add(this);  //������ �̿��ϴ� ��������Ʈ�� �߰�
						server.getWaitingRoom().sendUpdateUserInfo();  //���� ����ڵ鿡�� ���� ������ ��������Ʈ�� ������ ����Ʈ�� ������
						server.getWaitingRoom().sendUpdateGameRoomInfo();
						SketchQuiz sq2 = new SketchQuiz(SketchQuiz.WAIT_ROOM_SEND_MSG); //���� ����ڿ��� �޼��� ����
						sq2.setMsg("�١ڡ� "+userInfo.getNickName()+"�� ���� �١ڡ�");
						server.getWaitingRoom().sendMsg(sq2);  //���� ���� �޼��� ����
					}else{
						SketchQuiz sq = new SketchQuiz(SketchQuiz.USER_DUPLICATED); //�ߺ� �Ǵ� ��ȭ���� �������� �˷���
						out.writeObject(sq);
						break bk;
					}
					break;
				case SketchQuiz.DISCONNECT_SOCKET:
					SketchQuiz sq = new SketchQuiz(SketchQuiz.DISCONNECT_SOCKET); 
					out.writeObject(sq);
					server.getClinetArr().remove(this);
					waitRoomExitProcess(sq);
					break bk;
				case SketchQuiz.DISCONNECT_SOCKET_ON_GAME:
					SketchQuiz on_game_sq = new SketchQuiz(SketchQuiz.DISCONNECT_SOCKET); 
					out.writeObject(on_game_sq);
					currentGameRoom.outGameRoom(this);
					server.getClinetArr().remove(this);
					//���¹��� ���� ��ü�� �������̾��ٸ� ���ӹ� ��Ͽ��� �� ����...
					if(currentGameRoom.userNum == 0) {
						server.getWaitingRoom().getGameRoomList().remove(currentGameRoom);
						currentGameRoom=null;
					}	
					
					if(currentGameRoom!= null){
						currentGameRoom.updateGameRoomUI();
						if(currentGameRoom.getUserNum()<3 && currentGameRoom.isInGame()){
							currentGameRoom.stopGame();
						}
					}
					server.getWaitingRoom().sendUpdateGameRoomInfo();
					break bk;
//				case CatchMindProtocol.WAIT_ROOM_SEND_MSG:
//					CatchMindProtocol sq2 = new CatchMindProtocol(CatchMindProtocol.WAIT_ROOM_SEND_MSG); //���� ����ڿ��� �޼��� ����
//					sq2.setMsg(userInfo.getNickName()+" : "+ p.getMsg());
//					server.getWaitingRoom().sendMsg(sq2);  //���� ���� �޼��� ����
//					break;
				case SketchQuiz.EXIT_WAIT_ROOM:
					SketchQuiz sq3 = new SketchQuiz(SketchQuiz.EXIT_WAIT_ROOM); 
					out.writeObject(sq3);
					waitRoomExitProcess(sq3);
					break bk;
				case SketchQuiz.CREATE_GAME_ROOM:
					GameRoomInfo gri = p.getGameRoomInfo();
					GameRoom gr = new GameRoom(gri);
					server.getWaitingRoom().getWaitingRoomUsers().remove(this);
					int index = gr.joinGameRoom(this);
					currentGameRoom = gr;
					server.getWaitingRoom().getGameRoomList().add(gr);
					server.getWaitingRoom().sendUpdateUserInfo();
					server.getWaitingRoom().sendUpdateGameRoomInfo();
					SketchQuiz sq4 = new SketchQuiz(SketchQuiz.CREATE_GAME_ROOM); 
					sq4.setGameRoomInfo(gri);
					sq4.setUserInfoArr(gr.getUserInfoArr());
					gr.sendGameRoomProtocol(sq4);
					SketchQuiz create_index_sq = new SketchQuiz(SketchQuiz.SET_GAME_ROOM_INDEX);
					create_index_sq.setIdx(index);
					out.writeObject(create_index_sq);
					break;
				case SketchQuiz.JOIN_GAME_ROOM:
					GameRoom join_gr = server.getWaitingRoom().getGameRoomList().get(p.getGameRoomIndex());
					int join_index=-1;
					if((join_index =join_gr.joinGameRoom(this))!=-1){
						currentGameRoom = join_gr;
						SketchQuiz join_index_sq = new SketchQuiz(SketchQuiz.SET_GAME_ROOM_INDEX);
						join_index_sq.setIdx(join_index);
						out.writeObject(join_index_sq);
						server.getWaitingRoom().getWaitingRoomUsers().remove(this);
						server.getWaitingRoom().sendUpdateUserInfo();
						server.getWaitingRoom().sendUpdateGameRoomInfo();
						SketchQuiz joinedsq = new SketchQuiz(SketchQuiz.JOIN_GAME_ROOM); 
						joinedsq.setGameRoomInfo(join_gr.getGri());
						joinedsq.setUserInfoArr(join_gr.getUserInfoArr());
						join_gr.sendGameRoomProtocol(joinedsq);
						
						if(currentGameRoom.getUserNum()>=3 && !currentGameRoom.isInGame()){
							currentGameRoom.startGame();
						}
					}
					break;
				case SketchQuiz.EXIT_GAME_ROOM:
					currentGameRoom.outGameRoom(this);
					//���¹��� ���� ��ü�� �������̾��ٸ� ���ӹ� ��Ͽ��� �� ����...
					if(currentGameRoom.userNum == 0) {
						server.getWaitingRoom().getGameRoomList().remove(currentGameRoom);
						currentGameRoom=null;
					}	
					
					if(currentGameRoom!= null){
						currentGameRoom.updateGameRoomUI();
						
						if(currentGameRoom.getUserNum()<3 && currentGameRoom.isInGame()){
							currentGameRoom.stopGame();
						}
					}
					server.getWaitingRoom().getWaitingRoomUsers().add(this);  //���ǿ��ٰ� �߰�..					
					server.getWaitingRoom().sendUpdateUserInfo();
					server.getWaitingRoom().sendUpdateGameRoomInfo();
					
					SketchQuiz exit_sq = new SketchQuiz(SketchQuiz.EXIT_GAME_ROOM);
					out.writeObject(exit_sq);
				
					break;
				case SketchQuiz.DRAW_LINE_NEW_SEGMENT:
					SketchQuiz new_seg_sq = new SketchQuiz(SketchQuiz.DRAW_LINE_NEW_SEGMENT); 
					currentGameRoom.sendGameRoomProtocol(new_seg_sq);
					break;
				case SketchQuiz.DRAW_LINE_THICK:
					SketchQuiz lineThicksq = new SketchQuiz(SketchQuiz.DRAW_LINE_THICK);
					lineThicksq.setLineThick(p.getLineThick());
					currentGameRoom.sendGameRoomProtocol(lineThicksq);
					break;
				case SketchQuiz.DRAW_LINE_COLOR:
					SketchQuiz colorsq = new SketchQuiz(SketchQuiz.DRAW_LINE_COLOR);
					colorsq.setColor(p.getColor());
					currentGameRoom.sendGameRoomProtocol(colorsq);
					break;
				case SketchQuiz.GAME_CHAT:
					String game_msg = p.getMsg();
					if(currentGameRoom.getQuestion()!=null && currentGameRoom.getQuestion().equals(game_msg)
							&&currentGameRoom.getUserNum()>=3 && currentGameRoom.isInGame()){
						SketchQuiz correct_cpm = new SketchQuiz(SketchQuiz.CORRECT_ANSWER);
						correct_cpm.setUserInfoArr(currentGameRoom.getUserInfoArr());
						correct_cpm.setCorrectAnswerIndex(getGameRoomSlotIndex());
						currentGameRoom.sendGameRoomProtocol(correct_cpm);
						currentGameRoom.startGame();
					}
					SketchQuiz game_chat = new SketchQuiz(SketchQuiz.GAME_CHAT);
//					game_chat.setChatSlotIndex(getUserInfo().getGameSlotIndex());
					game_chat.setMsg(userInfo.getNickName() + " : " + game_msg);
					currentGameRoom.sendGameRoomProtocol(game_chat);
					break;
				case SketchQuiz.CANVAS_CLEAR:
					SketchQuiz clean_sq = new SketchQuiz(SketchQuiz.CANVAS_CLEAR);
					currentGameRoom.sendGameRoomProtocol(clean_sq);
					break;
				case SketchQuiz.GAME_STOP:
					currentGameRoom.setTimeout(p.isTimeout());
					p.setTimeout(false);
					currentGameRoom.stopGame();	
					//currentGameRoom.setStarter_out(p.isStarter_out());
					if(currentGameRoom.getUserNum()>=3 && !currentGameRoom.isInGame()){
						currentGameRoom.startGame();
					}
					break;
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closed();
	}
	
	private void closed(){
		try {
			if(in!=null){
				in.close();
				in = null;
			}
			if(out!=null){
				out.close();
				out= null;
			}
			if(s!=null) {
				s.close();
				s= null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ObjectOutputStream getOut() {
		return out;
	}
	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	private boolean isDuplicated(){   //CopyClient ��ü�� �����Ǿ� UserInfo�� �޾� ���� ��ȭ���� ���� �ٸ� ������ �ִ��� �˻��Ѵ�
		ArrayList<AllClient> allUsers = server.getClinetArr();
		Iterator<AllClient> it  = allUsers.iterator();
		while(it.hasNext()){
			AllClient cc = it.next();
			if(cc.getUserInfo().getNickName().equals(this.userInfo.getNickName())){
				return true; //�ߺ� �Ǵ� ��ȭ���� ������ �����Ѵ�
			}
		}
		return false; //�ݺ����� ���� ���� �ߺ��Ǵ� ��ȭ���� �߰����� ���ϸ� false�� �����Ѵ�
	}
	private void waitRoomExitProcess(SketchQuiz sq){
		server.getClinetArr().remove(this);
		server.getWaitingRoom().getWaitingRoomUsers().remove(this);
		server.getWaitingRoom().sendUpdateUserInfo();
		sq= new SketchQuiz(SketchQuiz.WAIT_ROOM_SEND_MSG);
		sq.setMsg("�ޡߡ�  "+userInfo.getNickName()+" �� ���� �ޡߡ�");
		server.getWaitingRoom().sendMsg(sq);
	}

	public int getGameRoomSlotIndex() {
		return gameRoomSlotIndex;
	}

	public void setGameRoomSlotIndex(int gameRoomSlotIndex) {
		this.gameRoomSlotIndex = gameRoomSlotIndex;
	}
	
}
