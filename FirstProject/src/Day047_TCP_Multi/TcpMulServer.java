package Day047_TCP_Multi;

public class TcpMulServer {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법 : 서버실행은 "+" \'java 패키지명.파일명 포트번호\' 형식으로 입력");
		}
		
		//new ServeClass()
		new ServerClass(Integer.parseInt(args[0]));
		//객체생성 - 초기치 생성자 
	}

}

