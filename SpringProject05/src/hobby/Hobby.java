package hobby;

import sawonpkg.Sawon;

public class Hobby {
	
	private Sawon sawon;	//여기서는 필드명, 실제로는 객체 
	//Setter Injection을 사용하여 객체를 처리, ref사용
	//선언 및 작업은 xml에서 
	
	public Sawon getSawon() {
		return sawon;
	}

	public void setSawon(Sawon sawon) {
		this.sawon = sawon;
	}

}
